package demo;

import java.util.List;

public class MiJdbc
{
	private static MiJdbc instancia = null;
	
	private String url = null;
	private String driver = null;
	private String usr = null;
	private String pwd = null;
	
	private MiJdbc()
	{
		// no hay nada que hacer
	}
	
	public void disconnect()
	{
		// cerrar la conexion con la db
	}
	
	public List<Object[]> query(String sql,Object ...params)
	{
		// crear el pstm, setearle los parametros, ejecutarla
		// crear un ArrayList de Object[], llenarlo con los datos del rs
		// retornarlo
		
		return null;
	}

	public static MiJdbc getInstance()
	{
		if( instancia==null )
		{
			instancia = new MiJdbc();
			// usando Properties, leer MiJdbc.properties y asignar los valores
			// a los parametros
			// y conectar!			
		}
		
		return instancia;
	}
}
