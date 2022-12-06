package demo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteHolaMundo
{
	public static void main(String[] args)
	{
		Socket s = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try
		{
			s = new Socket("localhost",5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			// envio mi nombre
			oos.writeObject(args[0]);
			
			// espero el resultado
			String ret = ois.readObject().toString();
			
			System.out.println(ret);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			try
			{
				if( ois!=null ) ois.close();
				if( oos!=null ) oos.close();
				if( s!=null ) s.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
		
	}
}
