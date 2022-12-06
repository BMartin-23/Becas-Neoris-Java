package demo.parseo;

public class Fecha
{
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha() {}
	public Fecha(int d,int m, int a)
	{
		dia = d;
		mes = m;
		anio = a;
	}
	
	// "dd-mm-aaaa"
	// "aaaa-mm-dd"
	public static Fecha parseFecha(String s)
	{
		Fecha fRet = new Fecha();
		
		int i=0;
		char c = s.charAt(i);
		while(Character.isDigit(c) && i<s.length())
		{
			i++;
			c = s.charAt(i);
		}
		
		int p1 = s.indexOf(c);
		int p2 = s.lastIndexOf(c);

		String x = s.substring(0,p1);
		String y = s.substring(p1+1,p2);
		String z = s.substring(p2+1);
		
		fRet.setMes(Integer.parseInt(y));
		if( x.length()==2 )
		{
			fRet.setDia(Integer.parseInt(x));
			fRet.setAnio(Integer.parseInt(z));
		}
		else
		{
			fRet.setDia(Integer.parseInt(z));
			fRet.setAnio(Integer.parseInt(x));			
		}
		
		return fRet;
	}
	
	@Override
	public String toString()
	{
		return anio+"/"+mes+"/"+dia;
	}
	
	public int getDia()
	{
		return dia;
	}
	public void setDia(int dia)
	{
		this.dia=dia;
	}
	public int getMes()
	{
		return mes;
	}
	public void setMes(int mes)
	{
		this.mes=mes;
	}
	public int getAnio()
	{
		return anio;
	}
	public void setAnio(int anio)
	{
		this.anio=anio;
	}
	
	
}
