package neoris.app;

import java.util.List;


import neoris.app.domain.Categoria;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;

public interface Facade
{	
	// Caso de uso #1: CLIENTES QUE ADQUIRIERON UN PRODUCTO
	// Se debe mostrar por pantalla el listado de clientes que 
	// adquirieron, al menos en una oportunidad, un producto especificado.
	public List<Producto> obtenerProductos();	
	public List<Cliente> obtenerClientesQueAdquirieron(int idProducto);
	
	// Caso de uso #2: EMPLEADOS QUE ATENDIERON A UN CLIENTES
	// Se debe mostrar por pantalla el listado de empleados que 
	// atendieron, al menos en una oportunidad, un cliente especificado.
	public List<Cliente> obtenerClientes();	
	public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente);
	
	// Caso de uso #3: LISTADO DE LOS PRODUCTOS QUE TIENEN PROMOCIONES EN VIGENCIA
	// Se debe mostrar por pantalla el listado de los productos que 
	// tienen al menos una promocion en vigencia.
	public List<Producto> obtenerProductosConPromocionesVigentes();

	// Caso de uso #4: LISTADO DE LAS PROMOCIONES PARA UN PRODUCTO 
	// Se debe mostrar por pantalla el listado de TODAS las promociones 
	// aplicables a un producto especificado.	
	public List<Promocion> obtenerPromociones(int idProducto);
	
	// Caso de uso #5: PROVEEDORES POR CATEOGORIA
	// Se debe mostrar por pantalla el listado de los proveedores que 
	// proveen productos de una categoria especificada.
	public List<Categoria> obtenerCategorias();		
	public List<Proveedor> obtenerProveedores(int idCategoria);
	
	// THREAD
	// Verifica que productos deben ser encargados para mantener el stock, y
	// genera una fila en la tabla de REPOSICION
	public void generarReposicionProducto();
}
