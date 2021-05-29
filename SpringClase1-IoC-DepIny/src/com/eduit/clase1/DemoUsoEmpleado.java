package com.eduit.clase1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase1.entidades.DirectorEmpleado;
import com.eduit.clase1.entidades.JefeEmpleado;
import com.eduit.clase1.entidades.SecretarioEmpleado;
import com.eduit.clase1.interfaces.IEmpleados;

public class DemoUsoEmpleado {

	public static void main(String[] args) {
		//Creamos objeto del tipo empleado
		JefeEmpleado e1 = new JefeEmpleado();
		
		//Creo una referencia a la abstraccion
		IEmpleados e2 = new JefeEmpleado();
		IEmpleados e3 = new SecretarioEmpleado();
		//IEmpleados e4 = new DirectorEmpleado();
		
		//el problema que se plantea aqui es que si quiero crear un objeto de un tipo diferente
		//me veo obligado a modificar el codigo y/o definir una nueva clase.
		//por ejemplo: si quiero dejar de usar una clase deberia eliminarla
		
		System.out.println("e1: "+e1.getTareas());
		System.out.println("e2: "+e2.getTareas());
		System.out.println("e3: "+e3.getTareas());
		
		System.out.println("Demo IOC Spring XML");
		//Ahora hacemos lo mismo pero con el contenedor de spring
		//1) Cargar el XML de configuracion
		//se crea el contexto y le pasamos el nombre del archivo con extension .xml
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2) Solicitarle el bean al contexto, enviandole el parametro id 
		//y en segundo lugar enviandole el nombre de la abstraccion
		IEmpleados alex = contexto.getBean("miEmpleado",IEmpleados.class);
		
		//3) Utilizar el objeto solicitado.
		System.out.println("Utilizamos bean: "+alex.getTareas());
		
		//3.1) Reutilizando en otra clase como por ejemplo jefeEmpleado
		System.out.println("Utilizamos la inyeccion en Constructor: "+alex.getInforme());
		
		//4) Cerramos el contexto liberando los recursos
		contexto.close();
	}
	
}
