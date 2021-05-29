package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.IEmpleados;

public class SecretarioEmpleado implements IEmpleados {
	
	private CreacionInformes informeNuevo;

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Soy un secretario";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "";
	}
	
	//Generamos un setter para poder usar la inyeccion de dependencias mediante
	//el tag <property>
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

}
