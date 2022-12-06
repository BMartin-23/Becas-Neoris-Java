package test.neoris.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import neoris.app.Facade;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;
import test.neoris.util.MiFactory;
import test.neoris.util.MiJdbc;

public class TestFacade
{
	@Test
	public void testObtenerProductos()
	{
		Facade f = MiFactory.getInstance("facade");
		List<Producto> lst = f.obtenerProductos();

		// 18 productos
		assertEquals(lst.size(),18);
	}

	@Test
	public void testClientesQueAdquirieron() 
	{
		Facade f = MiFactory.getInstance("facade");
		List<Cliente> lst = f.obtenerClientesQueAdquirieron(1);
		
		// 2 clientes
		assertEquals(lst.size(),2);		
	}
	
	@Test
	public void testObtenerClientes() 
	{
		Facade f = MiFactory.getInstance("facade");
		List<Cliente> lst = f.obtenerClientes();
		
		// 2 clientes
		assertEquals(lst.size(),7);		
	}
	
	@Test
	public void testObtenerEmpleadosQueAtendieron()
	{
		Facade f = MiFactory.getInstance("facade");

		// 2 empleados
		List<Empleado> lst = f.obtenerEmpleadosQueAntendieron(1);
		assertEquals(lst.size(),2);		
		
		// 2 empleados tambien
		lst = f.obtenerEmpleadosQueAntendieron(2);
		assertEquals(lst.size(),2);		
	}
	
	@Test
	public void testObtenerProductosConPromocionesVigentes()
	{
		Facade f = MiFactory.getInstance("facade");

		List<Producto> lst = f.obtenerProductosConPromocionesVigentes();
		assertEquals(lst.size(),10);				
	}
	
	@Test
	public void testObtenerPromociones()
	{
		Facade f = MiFactory.getInstance("facade");

		List<Promocion> lst = f.obtenerPromociones(1);
		assertEquals(lst.size(),0);				
		
		lst = f.obtenerPromociones(5);
		assertEquals(lst.size(),2);				
	}
	
	@Test
	public void testObtenerProveedores()
	{
		Facade f = MiFactory.getInstance("facade");

		List<Proveedor> lst = f.obtenerProveedores(1);
		assertEquals(lst.size(),3);				
		
		lst = f.obtenerProveedores(2);
		assertEquals(lst.size(),2);				
		
		lst = f.obtenerProveedores(3);
		assertEquals(lst.size(),2);				
	}
	
	@Test
	public void testGenerarReposicionProducto()
	{	
		MiJdbc j = MiFactory.getInstance("miJdbc");
		Facade f = MiFactory.getInstance("facade");
		f.generarReposicionProducto();
		f.generarReposicionProducto();
		
		String sql = "SELECT id_producto,cantidad FROM reposicion ";
		List<Object[]> lst = j.query(sql);
		assertEquals(lst.size(),3);
		
		Object[] fila = lst.get(0);
		assertEquals((int)(fila[0]),2);
		assertEquals((int)(fila[1]),8);
		
		fila = lst.get(1);
		assertEquals((int)(fila[0]),3);
		assertEquals((int)(fila[1]),9);
		
		fila = lst.get(2);
		assertEquals((int)(fila[0]),6);
		assertEquals((int)(fila[1]),9);
	}
	
	
}
