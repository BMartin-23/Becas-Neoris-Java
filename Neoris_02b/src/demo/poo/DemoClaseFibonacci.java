package demo.poo;

public class DemoClaseFibonacci
{
	public static void main(String[] args)
	{
		Fibonacci f = new Fibonacci(8);
		double r = f.calcular();		
		System.out.println(r);
	}
}
