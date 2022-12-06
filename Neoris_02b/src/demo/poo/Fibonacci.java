package demo.poo;

public class Fibonacci
{
	private int termino;
	
	public Fibonacci(int n)
	{
		termino = n;
	}
	
	public double calcular()
	{
		double t1 = 1;
		double t2 = 1;
		double t3 = 1;
		
		int i=2;
		while( i<termino )
		{
			t3 = t1+t2;
			t1 = t2;
			t2 = t3;
			
			i = i+1;
		}

		return t3;
	}
}
