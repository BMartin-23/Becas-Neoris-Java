package demo;

import java.util.ArrayList;

public class DemoArrayList
{
	public static void main(String[] args)
	{
		ArrayList<Integer> al  = new ArrayList<>();
		for(int i=0;i<5;i=i+1)
		{
			al.add(i);
		}
		
		for(int i=0;i<al.size();i=i+1)
		{
			int x = al.get(i);
			System.out.println(x);
		}
		
		for(Integer x:al)
		{
			System.out.println("-->"+x);
		}
	}
}
