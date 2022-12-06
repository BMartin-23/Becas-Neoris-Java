package demo;

public class DemoMiThread
{
	public static void main(String[] args)
	{
		// disparo un hilo que corre concurrentemente al main
		MiThread mt = new MiThread();
		mt.start();
		
		for(int i=0; i<10; i++)
		{
			try
			{
				// demoro entre 0 y 5 segundos
				int delay = (int)(Math.random()*5000);
				Thread.sleep(delay);
				
				// muestro un caracter al azar
				int n = (int)(Math.random()*100);
				System.out.println("Main --->"+n);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}
}
