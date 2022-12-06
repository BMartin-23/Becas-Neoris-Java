package demo;

public class DemoArray
{
	public static void main(String[] args)
	{
		int a[] = new int[5];
		for(int i=0;i<5;i=i+1)
		{
			a[i] = i;
		}
		
		for(int i=0;i<5;i=i+1)
		{
			System.out.println(a[i]);
		}

	}
}
