package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import neoris.app.bd.MiJdbc;

public class Proveedor
{
	public List<Proveedor> ProvXCat(int idCategoria)
	{
		MiJdbc x = MiJdbc.getInstance();
		String sql="";
		sql = "SELECT DISTINCT P.empresa, P.contacto , P.direccion FROM proveedor P ";
		sql += "INNER JOIN proveedor_categoria PC ON P.id_proveedor = PC.id_proveedor ";
		sql += "WHERE PC.id_categoria = ? ";
		List<Object[]> lst = x.query(sql,idCategoria);
		
		List<Proveedor> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Proveedor dto = new Proveedor();			
			dto.setNombre((String)fila[0]);
			dto.setNombre((String)fila[1]);
			dto.setNombre((String)fila[2]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	public String getNombre()
	{
		return Nombre;
	}

	public void setNombre(String nombre)
	{
		Nombre = nombre;
	}

	private String Nombre;
}
