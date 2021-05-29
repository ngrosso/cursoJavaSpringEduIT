package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.IEmpleados;

public class DirectorEmpleado implements IEmpleados {

	//Creacion de atributo del tipo CreacionInformes(Interface), para la DI
	private CreacionInformes informeNuevo;
	
	//Creacion de un constructor que se encargue de inyectar la dependencia
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;		
	}
	
	@Override
	public String getTareas() {
		//utilizamos el metodo getInforme() de la interface
		return "Informe creado por el director: "+informeNuevo.getInforme();
	}

	@Override
	public String getInforme() {
		
		return "Esto es un informe del director empleado";
	}

}
