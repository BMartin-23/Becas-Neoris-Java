package demo;

import java.util.Scanner;

public class SumaSucesiva
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingresá dos valores numéricos: ");
		int a = s.nextInt();
		int b = s.nextInt();
		
		int sum = 0;
		int i = 0;
		
		while(i<a)
		{
			sum = sum + b;
			i = i+1;
		}
		
		System.out.println(sum);
		
		s.close();
	}
}
