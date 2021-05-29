package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;

public class Informe implements CreacionInformes {

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Esto es un informe detallado, demo inyeccion de dependencias,"
				+ " y esta es una caracteristica que tienen en comun todas "
				+ "las entidades (Jefe, Secretario, Director, etc) de nuestra app";
	}

}
