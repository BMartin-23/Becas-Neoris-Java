package demo.prodcons;

public class DemoProdCons
{
	public static void main(String[] args)
	{
		Buffer buffer = new Buffer();
		Productor p1 = new Productor(buffer);
		Consumidor c1 = new Consumidor(buffer);
		
//		p1.start();
//		c1.start();
		p1.run();
		c1.run();
	}
}
