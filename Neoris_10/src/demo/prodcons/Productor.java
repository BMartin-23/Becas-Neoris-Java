package demo.prodcons;

public class Productor extends Thread
{
	private Buffer buffer;
	
	public Productor(Buffer b)
	{
		this.buffer = b;
	}
	
	@Override
	public void run()
	{
		try
		{
			for(int i=0; i<10; i++ )
			{
				// demoro entre 0 y 5 segundos
				int delay = (int)(Math.random()*5000);
				Thread.sleep(delay);

				// muestro un caracter al azar
				char c = (char)((Math.random()*26)+'A');

				// pongo en el buffer
				buffer.poner(c);
				
				System.out.println("Produje --->"+c);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		super.run();
	}
}
