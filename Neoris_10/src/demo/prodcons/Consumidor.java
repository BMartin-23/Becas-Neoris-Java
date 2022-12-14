package demo.prodcons;

public class Consumidor extends Thread
{
	private Buffer buffer;
	
	public Consumidor(Buffer b)
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

				// consumo un caracter del buffer
				char c = buffer.sacar();

				System.out.println("Consumi --->"+c);
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
