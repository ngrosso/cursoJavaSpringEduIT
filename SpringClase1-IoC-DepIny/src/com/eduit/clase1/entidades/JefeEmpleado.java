package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.IEmpleados;

public class JefeEmpleado implements IEmpleados {

	//Sobreescribo el metodo de la interfaz
	@Override
	public String getTareas() {
		return "Soy un jefe empleado";
	}

	@Override
	public String getInforme() {
		return "";
	}

}
