package demo;

public class Numero
{
	private int valor;
	
	public boolean esPar()
	{
		boolean ret;
		
		int resto = valor%2;
		if( resto==0 )
		{
			ret = true;
		}
		else
		{
			ret = false;
		}
		
		return ret;
	}
	
	public void asignarValor(int v)
	{
		valor = v;
	}
	
	public int obtenerValor()
	{
		return valor;
	}
}
