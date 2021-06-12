package com.eduit.clase1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase1.entidades.DirectorEmpleado;
import com.eduit.clase1.interfaces.IEmpleados;

public class DemoCicloDeVidaMetodoInitDestroy {

	public static void main(String[] args) {
		// cargamos el xml de config de spring
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext3.xml");

		// solicitamos el bean al containner de spring
		IEmpleados director = contexto.getBean("miDirectorEmpleado", DirectorEmpleado.class);

		// utilizamos el bean
		System.out.println(director.getInforme());

		// cerramos el contexto y liberamos recursos
		contexto.close();

	}

}