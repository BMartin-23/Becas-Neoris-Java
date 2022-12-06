package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import neoris.app.bd.MiJdbc;

public class Promocion
{
	public List<Promocion> obtenerPromociones(int idProducto)
	{
		MiJdbc x = MiJdbc.getInstance();		
		String sql="";
		sql = "SELECT DISTINCT P.id_promocion, P.descripcion FROM promocion P ";
		sql += "INNER JOIN promocion_vigencia V ON P.id_promocion = V.id_promocion ";
		sql += "INNER JOIN Promocion_Producto D ON V.id_promocion_vigencia = D.id_promocion_vigencia ";
		sql += "WHERE D.id_producto = ? ";
		List<Object[]> lst = x.query(sql,idProducto);
		
		List<Promocion> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Promocion dto = new Promocion();
			dto.setIdProducto((Integer)fila[0]);
			dto.setDescripcion((String)fila[1]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	private int idProducto;
	private String Descripcion;

	public int getIdProducto()
	{
		return idProducto;
	}
	public void setIdProducto(int idProducto)
	{
		this.idProducto=idProducto;
	}
	public String getDescripcion()
	{
		return Descripcion;
	}
	public void setDescripcion(String Descripcion)
	{
		this.Descripcion = Descripcion;
	}

}



