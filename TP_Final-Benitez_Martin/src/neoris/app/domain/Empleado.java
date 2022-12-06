package neoris.app.domain;

import java.util.ArrayList;
import java.util.List;

import neoris.app.bd.MiJdbc;

public class Empleado
{
	public List<Empleado> Atendido(int idCliente)
	{
		
		MiJdbc x = MiJdbc.getInstance();
		String sql="";
		sql+="SELECT * FROM EMPLEADO c WHERE EXISTS ";
		sql+="(SELECT * FROM ORDEN a WHERE EXISTS ";
		sql+="( SELECT * FROM CLIENTE b WHERE ";
		sql+="(b.ID_CLIENTE = a.ID_CLIENTE) ";
		sql+="AND (c.ID_EMPLEADO = a.ID_EMPLEADO) AND ";
		sql+="b.ID_CLIENTE =?";
		sql+="))";
		List<Object[]> lst = x.query(sql,idCliente);
		
		List<Empleado> ret = new ArrayList<>();
		for(Object[] fila:lst)
		{
			Empleado dto = new Empleado();
			dto.setNombre((String)fila[1]);
			ret.add(dto);
		}
		
		return ret;
	}
	
	private String nombre;
	private Integer IdEmpleado;

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Integer getIdEmpleado()
	{
		return IdEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado)
	{
		IdEmpleado = idEmpleado;
	}
}
