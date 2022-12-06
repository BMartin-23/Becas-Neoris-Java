package neoris.app;

import java.util.List;
import java.util.Scanner;

import neoris.app.domain.Categoria;
import neoris.app.domain.Cerrar;
import neoris.app.domain.Cliente;
import neoris.app.domain.Empleado;
import neoris.app.domain.Producto;
import neoris.app.domain.Promocion;
import neoris.app.domain.Proveedor;

 
public class Frontend
{
	static 
	{
		Runtime.getRuntime().addShutdownHook(new Cerrar());
	}
	
	public static void Decision()
	{
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Desea realizar otra consulta? -- 1:Si | 0: No");
		int des = scanner.nextInt();
		if (des==1) Inicio();
		
		scanner.close();
	}
	
	public static void Inicio(){
		
		MiHilo hilo = MiHilo.getInstance();
		if(!hilo.isAlive()) hilo.start();
		
		Scanner scanner = new Scanner(System.in);
		Facade MiFacade = FacadeImple.getInstance();
		
		System.out.println("-- Bienvenido! --");
		System.out.println("Ingrese la opcion a elegir");
		System.out.println("1: CLIENTES QUE ADQUIRIERON UN PRODUCTO");
		System.out.println("2: EMPLEADOS QUE ATENDIERON A UN CLIENTES");
		System.out.println("3: LISTADO DE LOS PRODUCTOS QUE TIENEN PROMOCIONES EN VIGENCIA");
		System.out.println("4: LISTADO DE LAS PROMOCIONES PARA UN PRODUCTO");
		System.out.println("5: PROVEEDORES POR CATEOGORIA");
		
		int op = scanner.nextInt();
		
				
		switch(op)
		{
			case 1:
				System.out.println("eligio --> 1: CLIENTES QUE ADQUIRIERON UN PRODUCTO");
				System.out.println("Seleccione alguno de los siguientes productos:");
				
				List<Producto> pro = MiFacade.obtenerProductos();
				
				for(Producto dto:pro)
				{
					System.out.println(dto.getIdProducto()+": "+dto.getDescripcion());
				}				
				
				int idProducto = scanner.nextInt();				
				List<Cliente> cli = MiFacade.obtenerClientesQueAdquirieron(idProducto);
				
				for(Cliente dto:cli)
				{
					System.out.println(dto.getNombre());
				}
				
				if (cli.isEmpty()) System.out.println("Aun no se ha vendido ese producto");
				
				Decision();
				
				break;

			case 2:
				System.out.println("eligio --> 2: EMPLEADOS QUE ATENDIERON A UN CLIENTES");
				System.out.println("Seleccione alguno de los siguientes clientes:");
				
				List<Cliente> clie = MiFacade.obtenerClientes();
				
				for(Cliente dto:clie)
				{
					System.out.println(dto.getIdCliente()+": "+dto.getNombre());
				}
				
				int idCliente = scanner.nextInt();
				List<Empleado> emp = MiFacade.obtenerEmpleadosQueAntendieron(idCliente);
				
				for(Empleado dto:emp)
				{
					System.out.println(dto.getNombre());
				}
				
				Decision();
				
				break;
				
			case 3:
				System.out.println("eligio --> 3: LISTADO DE LOS PRODUCTOS QUE TIENEN PROMOCIONES EN VIGENCIA");
				
				List<Producto> prom = MiFacade.obtenerProductosConPromocionesVigentes();
				for(Producto dto:prom)
				{
					System.out.println(dto.getIdProducto()+": "+dto.getDescripcion()+" -- "+dto.getDescripcionPromo());
				}
				
				Decision();
				
				break;
				
			case 4:
				System.out.println("eligio --> 4: LISTADO DE LAS PROMOCIONES PARA UN PRODUCTO\"");
				System.out.println("Seleccione alguno de los siguientes productos:");
				
				List<Producto> prod = MiFacade.obtenerProductos();				
				for(Producto dto:prod)
				{
					System.out.println(dto.getIdProducto()+": "+dto.getDescripcion());
				}				
				
				int idProd = scanner.nextInt();
				
				List<Promocion> promprod = MiFacade.obtenerPromociones(idProd);
				for(Promocion dto:promprod)
				{
					System.out.println(dto.getIdProducto()+": "+dto.getDescripcion());
				}				
				if (promprod.isEmpty()) System.out.println("No existen promociones vigentes para el producto seleccionado");

				Decision();
				
				break;
				
			case 5:
				System.out.println("eligio --> 5: PROVEEDORES POR CATEOGORIA");
				System.out.println("Seleccione alguna de las siguientes categorias:");
				
				List<Categoria> cat = MiFacade.obtenerCategorias();				
				for(Categoria dto:cat)
				{
					System.out.println(dto.getIdCategoria()+": "+dto.getDescripcion());
				}
				int cate = scanner.nextInt();
				
				List<Proveedor> prov = MiFacade.obtenerProveedores(cate);				
				for(Proveedor dto:prov)
				{
					System.out.println(dto.getNombre());
				}

				Decision();
				
				break;
				
			default:
				System.out.println("Opcion fuera de rango");				
				Inicio();
				break;
		}
		
		scanner.close();
		hilo.stop();
	}


	public static void main(String[] args)
	{
		Inicio();
	}
}
