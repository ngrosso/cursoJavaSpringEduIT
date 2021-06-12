package com.eduit.clase1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase1.entidades.SecretarioEmpleado;

public class DemoUsoSingletonYPrototype {
	public static void main(String args[]) {
		//1) Cargar el xml de config
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		/*
		 * Peticion de beans al container de spring
		 * solicitamos dos beans del tipo secretarioEmpleado
		 * como por defecto Spring trabaja con Singleton, ambos beans deberian apuntar al mismo objeto en memoria*/
		SecretarioEmpleado maria = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		SecretarioEmpleado pedro = contexto.getBean("miSecretarioEmpleado",SecretarioEmpleado.class);
		System.out.println(maria);
		System.out.println(pedro);
		if(maria == pedro) {
			System.out.println("maria y pedro apuntan al mismo objeto");
		}else {
			System.out.println("maria y pedro apuntan a distintos objetos");
		}
		contexto.close();
	}
}