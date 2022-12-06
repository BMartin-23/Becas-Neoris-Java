package ejercicios;

import java.util.Scanner;

public class AppFactorial
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un número: ");
		int n = s.nextInt();
		
		double prod = 1;
		
		while( n>1 )
		{
			prod = prod*n;
			n = n-1;
		}
		
		System.out.println(prod);
		s.close();
	}
}
