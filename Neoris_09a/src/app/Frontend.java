package app;

import java.util.List;
import java.util.Scanner;

import app.domain.CategoriaDTO;

public class Frontend
{
	static
	{
		Runtime.getRuntime().addShutdownHook(new MiShutdownHook());
	}
	
	public static void main(String[] args)
	{
		
		Facade facade = new Facade();
		
		Scanner scanner = new Scanner(System.in);

		// primera pantalla
		System.out.println("-- SELECCIONES CATEGORIA --");
		List<CategoriaDTO> categorias = facade.obtenerCategorias();
		
		for(CategoriaDTO dto:categorias)
		{
			System.out.println(dto.getIdCategoria()+": "+dto.getDescripcion());
		}
		
		System.out.print("Seleccione categoria: ");
		int idCat = scanner.nextInt();

		// segunda pantalla
		System.out.println("-- SELECCIONES PRODUCTO --");
		
		
		
		scanner.close();
	}
}
