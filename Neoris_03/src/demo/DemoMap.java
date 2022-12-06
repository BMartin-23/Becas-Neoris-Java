package demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class DemoMap
{
	public static void main(String[] args)
	{
		Map<String,Integer> m = new Hashtable<>();
		m.put("uno",1);
		m.put("dos",2);
		m.put("tres",3);
		
		Integer x = m.get("dos");
		System.out.println(x);

		x = m.get("VERDURA");
		System.out.println(x);
		
		for(Map.Entry<String,Integer> entry:m.entrySet())
		{
			String k = entry.getKey();
			int v = entry.getValue();
			System.out.println(k+", "+v);			
		}
	}
}
