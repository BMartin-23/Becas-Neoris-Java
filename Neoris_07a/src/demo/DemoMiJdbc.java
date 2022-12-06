package demo;

import java.util.List;

public class DemoMiJdbc
{
	public static void main(String[] args)
	{
		MiJdbc x = MiJdbc.getInstance();
		
		String sql="";
		sql+="SELECT id_producto,descripcion ";
		sql+="FROM producto ";
		sql+="WHERE id_categoria=? ";

		List<Object[]> rtdos = x.query(sql,1);
		
		for(Object[] fila:rtdos)
		{
			for(int i=0;i<fila.length; i++)
			{
				System.out.println(fila[i]+",");
			}
		}
		
		x.disconnect();
	}
}
