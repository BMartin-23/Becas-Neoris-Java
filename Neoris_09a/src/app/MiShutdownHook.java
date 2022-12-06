package app;

import demo.MiJdbc;

public class MiShutdownHook extends Thread
{
	@Override
	public void run()
	{
		MiJdbc.getInstance().disconnect();
		System.out.println("Conexion DB cerrada!");
	}
}
