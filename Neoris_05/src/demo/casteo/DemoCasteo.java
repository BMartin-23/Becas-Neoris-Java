package demo.casteo;

import java.util.Scanner;

public class DemoCasteo
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		double c = a/(double)b;
		System.out.println(c);
		
		s.close();
	}
}
