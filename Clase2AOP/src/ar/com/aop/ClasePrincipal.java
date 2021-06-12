package ar.com.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.aop.dao.ClienteDao;
import ar.com.aop.dao.ClienteVIPDAO;

public class ClasePrincipal {

	public static void main(String[] args) {

		// leemos la configuracion de Spring indicandole en el constructor 
		// cual es la clase que posee la config
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtenemos el bean del contenedor de Spring
		ClienteDao miCliente = contexto.getBean("clienteDAO",ClienteDao.class);
		ClienteVIPDAO miClienteVIP = contexto.getBean("clienteVIPDAO",ClienteVIPDAO.class);

		
		// Llamamos al metodo
		System.out.println("*******************miCliente.insertaCliente()***************************");
		miCliente.insertaCliente(); //este es el nombre del metodo que debe coincidir con el @before

		// Llamamos a otra clase con el mismo nombre de metodo 
		System.out.println("*******************miClienteVIP.insertaCliente()***************************");
		miClienteVIP.insertaCliente(); //este es el nombre del metodo que debe coincidir con el @before
		
		// Llamamos a otra clase con el mismo nombre de metodo 
		System.out.println("*******************miClienteVIP.insertaClienteVIP()***************************");
		miClienteVIP.insertaClienteVIP(); //este es el nombre del metodo que debe coincidir con el @before
		
		// Llamamos a otra clase con el mismo nombre de metodo 
		System.out.println("*******************miClienteVIP.insertaClienteVIPConError()***************************");
		try {
			miClienteVIP.insertaClienteVIPConError(); //este es el nombre del metodo que debe coincidir con el @before
		}catch(Exception e) {
			System.out.println("Se capturo un error en insertaClienteVIPConError");
		}
	
		//cerramos el contexto
		contexto.close();
	}

}
