package neoris.app;


import java.util.List;

import neoris.app.domain.Categoria;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;
import neoris.app.bd.MiJdbc;


public class FacadeImple implements Facade
{
	private static FacadeImple Instancia = null;
	
	public static FacadeImple getInstance()
	{
		try
		{
			if( Instancia==null )
			{
				Instancia = new FacadeImple();
			}
			
			return Instancia;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public List<Producto> obtenerProductos()
	{
		Producto dao = new Producto();
		return dao.findAll();
	}

	@Override
	public List<Cliente> obtenerClientesQueAdquirieron(int idProducto)
	{
		Cliente dao = new Cliente();
		return dao.CompraCliente(idProducto);
	}

	@Override
	public List<Cliente> obtenerClientes()
	{
		Cliente dao = new Cliente();
		return dao.AllClientes();
	}

	@Override
	public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente)
	{
		Empleado dao = new Empleado();
		return dao.Atendido(idCliente);
	}

	@Override
	public List<Producto> obtenerProductosConPromocionesVigentes()
	{
		Producto dao = new Producto();
		return dao.promos();
	}

	@Override
	public List<Promocion> obtenerPromociones(int idProducto)
	{
		Promocion dao = new Promocion();
		return dao.obtenerPromociones(idProducto);
	}

	@Override
	public List<Categoria> obtenerCategorias()
	{
		Categoria dao = new Categoria();
		return dao.findAll();
	}

	@Override
	public List<Proveedor> obtenerProveedores(int idCategoria)
	{
		Proveedor dao = new Proveedor();
		return dao.ProvXCat(idCategoria);
	}
	
	public String sql;
	public MiJdbc conexion;

	@Override
	public void generarReposicionProducto()
	{
		sql = "";
		sql +="INSERT INTO reposicion (id_producto,cantidad,fecha) ";
		sql +="SELECT p.id_producto,(p.unidades_stock_maximo - p.unidades_stock), CURRENT_DATE ";
		sql +="FROM producto p ";
		sql +="WHERE (p.unidades_stock < p.unidades_stock_minimo) ";
		sql +="AND NOT EXISTS (SELECT id_producto FROM reposicion)";
		
		conexion = MiJdbc.getInstance();		
		conexion.update(sql);
		
		System.out.println("Se ha actualizado las Reposiciones");

	}
	
}
