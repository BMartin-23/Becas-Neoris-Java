package test.neoris.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class MiFactory
{
	private static HashMap<String,Object> instancias = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String objName)
	{
		Object obj = instancias.get(objName);
		if( obj!=null )
		{
			return (T)obj;
		}
		
		try(FileInputStream fis=new FileInputStream("mifactory.properties"))
		{
			Properties p = new Properties();
			p.load(fis);
			obj = Class.forName(p.getProperty(objName)).getDeclaredConstructor().newInstance();
			instancias.put(objName,obj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return (T)obj;
	}
	
}
