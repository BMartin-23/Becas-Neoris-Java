package demo;

public class DemoNumero
{
	public static void main(String[] args)
	{
		Numero n = new Numero(10);	
		boolean x = n.esPar();
		System.out.println(n.getValor()+" es par: "+x);
		
		Numero m = new Numero();
		m.setValor(15);
		boolean y = m.esPar();
		System.out.println(m.getValor()+" es par: "+y);
		
		int c = Numero.sumar(2,3);
		System.out.println(c);
		
		int t = n.sumar(10);
		System.out.println(t);
		
		Numero z = new Numero(5);
		z.sumar(m).sumar(n);
		System.out.println(z.getValor());
		
		
		
	}
}
