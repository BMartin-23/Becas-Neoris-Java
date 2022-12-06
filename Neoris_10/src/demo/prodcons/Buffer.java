
package demo.prodcons;

public class Buffer
{
	char buffer[] = new char[5];
	int len = 0;
	
	public synchronized void poner(char c)
	{
		try
		{
			while( len>=buffer.length )
			{
				wait();
			}
			
			buffer[len] = c;
			len++;

			notify();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public synchronized char sacar()
	{
		try
		{
			while( len==0)
			{
				wait();
			}
			
			len--;
			char c = buffer[len];
			
			notify();
			return c;			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
}
