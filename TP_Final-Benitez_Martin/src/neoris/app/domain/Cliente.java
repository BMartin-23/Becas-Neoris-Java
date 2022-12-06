package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import neoris.app.bd.MiJdbc;

public class Cliente
{
	
	public List<Cliente> CompraCliente(int idProducto)
	{
		
		MiJdbc x = MiJdbc.getInstance();
		String sql="";
		sql+="SELECT NOMBRE FROM CLIENTE c WHERE EXISTS ";
		sql+="(SELECT * FROM ORDEN a WHERE EXISTS ";
		sql+="(SELECT * FROM DETALLE_ORDEN b WHERE ";
		sql+="(b.ID_ORDEN = a.ID_ORDEN) ";
		sql+="AND (c.ID_CLIENTE = a.ID_CLIENTE) AND ";
		sql+="b.ID_PRODUCTO =?";
		sql+="))";
		List<Object[]> lst = x.query(sql,idProducto);
		
		List<Cliente> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Cliente dto = new Cliente();
			dto.setNombre((String)fila[0]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	public List<Cliente> AllClientes()
	{
		MiJdbc x = MiJdbc.getInstance();		
		List<Object[]> lst = x.query("SELECT * FROM cliente");
		
		List<Cliente> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Cliente dto = new Cliente();
			dto.setIdCliente((Integer)fila[0]);
			dto.setNombre((String)fila[2]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	private String nombre;
	private Integer IdCliente;

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Integer getIdCliente()
	{
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente)
	{
		IdCliente = idCliente;
	}
}
