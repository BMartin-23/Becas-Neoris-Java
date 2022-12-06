package neoris.app.domain;


import java.util.ArrayList;
import java.util.List;

import neoris.app.bd.MiJdbc;


public class Producto
{
	public List<Producto> findAll()
	{
		MiJdbc x = MiJdbc.getInstance();		
		List<Object[]> lst = x.query("SELECT * FROM producto");
		
		List<Producto> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Producto dto = new Producto();
			dto.setIdProducto((Integer)fila[0]);
			dto.setDescripcion((String)fila[1]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	public List<Producto> promos()
	{
		MiJdbc x = MiJdbc.getInstance();
		
		String sql="";
		sql+="SELECT prod.id_producto ,prod.descripcion ,prom.descripcion ";
		sql+="FROM producto prod ,promocion_producto pp ,promocion_vigencia pv ,promocion prom ";
		sql+="WHERE pp.id_producto=prod.id_producto ";
		sql+="AND pv.id_promocion_vigencia=pp.id_promocion_vigencia ";
		sql+="AND prom.id_promocion=pv.id_promocion AND pv.fecha_inicio<=NOW AND pv.fecha_fin>=NOW";
		List<Object[]> lst = x.query(sql);
		
		List<Producto> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Producto dto = new Producto();
			dto.setIdProducto((Integer)fila[0]);
			dto.setDescripcion((String)fila[1]);
			dto.setDescripcionPromo((String)fila[2]);
			ret.add(dto);
		}
		
		return ret;
	}
	

	private int idProducto;
	private String Descripcion;
	private String DescripcionPromo;
	
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

	public String getDescripcionPromo()
	{
		return DescripcionPromo;
	}

	public void setDescripcionPromo(String descripcionPromo)
	{
		DescripcionPromo = descripcionPromo;
	}
	
}