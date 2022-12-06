package demo;

public class DemoNumero
{
	public static void main(String[] args)
	{
		Numero n = new Numero();
		n.asignarValor(10);
		
		boolean x = n.esPar();
		System.out.println(x);
	}
}
