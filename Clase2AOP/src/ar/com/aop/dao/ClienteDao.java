package ar.com.aop.dao;

import org.springframework.stereotype.Component;

// Esta clase debe funcionar a modo componentes asi que agregamos la anotacion:
@Component("clienteDAO")
public class ClienteDao {
	
	// Antes de ejecutar este metodo, por detras y de manera automatica,
	// se deberia ejecutar el aspecto LoginConAspectos que comprueba que el usuario
	// esta logueado, que las credenciales y roles son correctas
	public void insertaCliente() {
		// aqui estaria el codigo de insercion en la DB
		System.out.println("Se inserto el cliente en la base de datos correctamente");
	}
	
}
