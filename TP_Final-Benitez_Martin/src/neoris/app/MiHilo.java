package neoris.app;

public class MiHilo extends Thread
{
	private static MiHilo Instancia = null;
	
	private MiHilo()
	{
		
	}
	
	public static MiHilo getInstance()
	{
		try
		{
			if( Instancia==null )
			{
				Instancia = new MiHilo();
			}
			
			return Instancia;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void run() {
		
		Facade MiFacade = FacadeImple.getInstance();
			
			try {
				 
				while(true) {
					Thread.sleep(40000);
					MiFacade.generarReposicionProducto();					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}


}