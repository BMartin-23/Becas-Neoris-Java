package neoris.app.domain;

import neoris.app.bd.MiJdbc;

public class Cerrar extends Thread
{
	@Override
	public void run()
	{	
		MiJdbc.getInstance().disconnect();
		System.out.println("Hilo y BD Cerrada! --- Gracias por utilizar el sistema");
	}
}
