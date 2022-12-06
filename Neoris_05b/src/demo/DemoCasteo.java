package demo;

import java.io.FileInputStream;

public class DemoCasteo
{
	public static void main(String[] args)
	{
		try
		{
			FileInputStream fis = new FileInputStream("pp.txt");
			System.out.println("Ahora si, voy a trabajar con mi archivo !!!");
			int b = fis.read();
			int i = Integer.parseInt("VERDURA");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
