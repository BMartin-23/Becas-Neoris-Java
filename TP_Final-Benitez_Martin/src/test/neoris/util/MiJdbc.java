package test.neoris.util;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MiJdbc
{
	private Connection con=null;

	public MiJdbc()
	{
		try (FileInputStream fis=new FileInputStream("MiJdbc.properties"))
		{
			Properties props=new Properties();
			props.load(fis);

			String url=props.getProperty("url");
			String driver=props.getProperty("driver");
			String usr=props.getProperty("usr");
			String pwd=props.getProperty("pwd");

			// levanto el driver
			Class.forName(driver);

			// Me conecto!
			con=DriverManager.getConnection(url,usr,pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void disconnect()
	{
		try
		{
			if(con!=null) con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Object[]> query(String sql, Object... params)
	{
		PreparedStatement pstm=null;
		ResultSet rs=null;

		try
		{
			// preparo la sentencia
			pstm=con.prepareStatement(sql);

			// seteo los parametros
			for(int i=0; i<params.length; i++)
			{
				pstm.setObject(i+1,params[i]);
			}

			// ejecuto el query
			rs=pstm.executeQuery();

			// metadata
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();

			// recorro el ResultSet y cargo los datos
			List<Object[]> ret=new ArrayList<>();
			while(rs.next())
			{
				Object[] fila=new Object[columnCount];
				for(int i=0; i<columnCount; i++)
				{
					fila[i]=rs.getObject(i+1);
				}
				ret.add(fila);
			}

			return ret;
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
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}


//	// insert, update y delete
	public int update(String sql,Object ...params)
	{
		PreparedStatement pstm = null;
		
		try
		{
			// preparo la sentencia
			pstm = con.prepareStatement(sql);

			// seteo los parametros
			for(int i=0; i<params.length;i++)
			{
				pstm.setObject(i+1,params[i]);
			}

			// ejecuto el update
			return pstm.executeUpdate();
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
				if( pstm!=null ) pstm.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}		
	}
}