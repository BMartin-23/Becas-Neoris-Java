package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import neoris.app.bd.MiJdbc;

public class Categoria
{
	public List<Categoria> findAll()
	{
		MiJdbc x = MiJdbc.getInstance();		
		List<Object[]> lst = x.query("SELECT * FROM categoria");
		
		List<Categoria> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Categoria dto = new Categoria();
			dto.setIdCategoria((Integer)fila[0]);
			dto.setDescripcion((String)fila[1]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	private Integer IdCategoria;
	private String Descripcion;
	
	public Integer getIdCategoria()
	{
		return IdCategoria;
	}

	public void setIdCategoria(Integer idCategoria)
	{
		IdCategoria = idCategoria;
	}

	public String getDescripcion()
	{
		return Descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		Descripcion = descripcion;
	}

	

}
