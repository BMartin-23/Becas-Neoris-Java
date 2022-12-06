package demo.parseo;

import com.google.gson.Gson;

public class DemoFecha
{
	public static void main(String[] args)
	{
		String s = "03/10/1995";
		Fecha miFecha = Fecha.parseFecha(s);
		System.out.println(miFecha);
		
		Gson g = new Gson();
		String sMiFechaJson = g.toJson(miFecha);
		System.out.println(sMiFechaJson);
		
		Fecha miFecha2 = g.fromJson(sMiFechaJson,Fecha.class);
		System.out.println(miFecha2);
	}
}
