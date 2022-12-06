package demo;

public class DemoNumero2
{
	public static void main(String[] args)
	{
		Object n = new Numero(10);	
		System.out.println(n.toString());
		
		Object m = new Numero(10);	
		
		if( n==m )
		{
			System.out.println("Son iguales");
		}
		else
		{
			System.out.println("Son distintos");			
		}
		
		if( n.equals(m) )
		{
			System.out.println("Son iguales");
		}
		else
		{
			System.out.println("Son distintos");			
		}
		
		if( n.equals("VERDURA") )
		{
			System.out.println("----");
		}
		
		
	}
}
