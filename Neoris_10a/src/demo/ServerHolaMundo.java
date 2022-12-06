package demo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHolaMundo
{
	public static void main(String[] args)
	{
		try
		{
		
			int port = 5432;
			ServerSocket ss = new ServerSocket(port);

			while( true )
			{
				Socket s = null;
				ObjectInputStream ois = null;
				ObjectOutputStream oos = null;
				
				try
				{
					System.out.println("Esperando conexion...");

					// blockeante
					s = ss.accept();

					System.out.println("Conexion establecida!");

					ois = new ObjectInputStream(s.getInputStream());
					oos = new ObjectOutputStream(s.getOutputStream());
					
					// leo el nombre del cliented (nombre del usuario)
					String nombreCli = ois.readObject().toString();
					
					// confecciono y envio la respuesta
					String ret = "Hola Mundo, "+nombreCli;
					oos.writeObject(ret);
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
						if( oos!=null ) oos.close();
						if( ois!=null ) ois.close();
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
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
}
