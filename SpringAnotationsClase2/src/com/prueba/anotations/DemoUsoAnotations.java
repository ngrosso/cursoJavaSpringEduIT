package com.prueba.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interfaces.IEmpleados;

public class DemoUsoAnotations {

	public static void main(String[] args) {
		
		// 1) Cargamos el XML con la config de spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2) Solicitamos el bean al contenedor de Spring a partir del ID dicho en la anotacion
		IEmpleados comercial = context.getBean("comercialExperimentado",IEmpleados.class);
		
		// 3) Utilizamos el bean
		System.out.println("Utilizamos el bean con anotaciones");
		System.out.println(comercial.getTareas());
		System.out.println(comercial.getInforme());
		
		// 4) Cerramos el contexto para liberar recursos
		context.close();
	}

}
