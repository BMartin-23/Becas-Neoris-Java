package ejercicios;

import java.util.Scanner;

public class AppFibonacci
{
	public static void main(String[] args)
	{
		// preparo todo para que el usuario ingrese un valor
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un número: ");
		int n = s.nextInt();
		
		double t1 = 1;
		double t2 = 1;
		double t3 = 1;
		
		int i=2;
		while( i<n )
		{
			t3 = t1+t2;
			t1 = t2;
			t2 = t3;
			
			i = i+1;
		}
		
		// 1 1 2 3 5 8 13 21 34 
		System.out.println(t3);
		
		s.close();
	}
}
