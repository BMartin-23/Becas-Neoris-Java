package app;

import java.util.List;

import app.domain.CategoriaDAO;
import app.domain.CategoriaDTO;

public class Facade
{
	public List<CategoriaDTO> obtenerCategorias()
	{
		CategoriaDAO dao = new CategoriaDAO();
		return dao.findAll();
	}
}
