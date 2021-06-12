package ar.com.aop.dao;

import org.springframework.stereotype.Component;

@Component("clienteVIPDAO")
public class ClienteVIPDAO {
	//esta clase posee un metodo "insertaCliente()" con el mismo nombre de la clase clienteDAO()
	
	public void insertaCliente() {
		// aqui estaria el codigo de insercion en la DB
		System.out.println("insertaCliente(): Se inserto el cliente desde clienteVIP en la base de datos correctamente");
	}
	
	public void insertaClienteVIP() {
		// aqui estaria el codigo de insercion en la DB
		System.out.println("insertaClienteVIP(): Se inserto el cliente VIP en la base de datos correctamente");

	}
	
	public void insertaClienteVIPConError() throws Exception {
		// aqui estaria el codigo de insercion en la DB
		System.out.println("insertaClienteVIPConError(): Se inserto el cliente VIP en la base de datos correctamente");
		throw new Exception();
	}
}
