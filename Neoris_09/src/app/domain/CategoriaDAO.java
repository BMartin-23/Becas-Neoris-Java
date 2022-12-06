package app.domain;

import java.util.ArrayList;
import java.util.List;

import demo.MiJdbc;

public class CategoriaDAO
{
	public List<CategoriaDTO> findAll()
	{
		MiJdbc x = MiJdbc.getInstance();		
		List<Object[]> lst = x.query("SELECT * FROM categoria");
		
		List<CategoriaDTO> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			CategoriaDTO dto = new CategoriaDTO();
			dto.setIdCategoria((Integer)fila[0]);
			dto.setDescripcion((String)fila[1]);
			ret.add(dto);
		}
		
		return ret;
	}
}
