package demo;

import java.util.Scanner;

public class HolaMundo
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		System.out.println("Cómo te llamás? ");
		String x = s.nextLine();
		System.out.println("Dijiste que te llamás: "+x);

		if( x.equalsIgnoreCase("Carlos") )
		{
			System.out.println("Te odio!");
		}
		else
		{
			System.out.println("Mucho gusto en conocerte!");
		}
		
		s.close();
	}
}
