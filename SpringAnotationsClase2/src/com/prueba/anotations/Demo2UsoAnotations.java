package com.prueba.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interfaces.IEmpleados;

public class Demo2UsoAnotations {
	// Demostracion de anotation @Scope
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IEmpleados comercialJose = context.getBean("comercialExperimentado", IEmpleados.class);
		IEmpleados comercialPedro = context.getBean("comercialExperimentado", IEmpleados.class);
		
		// Comprobamos si los dos apuntan a la misma direccion de memoria
		System.out.println("Direccion de memoria Jose: "+ comercialJose.toString());
		System.out.println("Direccion de memoria Pedro: "+ comercialPedro.toString());
		if(comercialJose == comercialPedro) {
			System.out.println("Singleton: Apuntan al mismo lugar de memoria");
		}else {
			System.out.println("Prototype: Apuntan a distintos lugares de memoria, son instancias diferentes");
		}
		context.close();
	}

}
