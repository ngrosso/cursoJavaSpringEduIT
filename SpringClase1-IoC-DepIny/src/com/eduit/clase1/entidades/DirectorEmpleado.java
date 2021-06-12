package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.IEmpleados;

public class DirectorEmpleado implements IEmpleados {

	// Creacion de atributo del tipo CreacionInformes(Interface), para la DI
	private CreacionInformes informeNuevo;

	// Creacion de un constructor que se encargue de inyectar la dependencia
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		// utilizamos el metodo getInforme() de la interface
		return "soy el director y gestiono mi nomina de empleados";
	}

	@Override
	public String getInforme() {

		return "Esto es un informe del director empleado";
	}

	// Creamos metodo Init() que ejecutara tareas antes de que el bean este
	// disponible. Los metodos no tienen que ser void aunque la mayoria de las veces
	// sera asi, siendo mas procedimientos que funciones, TAMPOCO TIENEN que
	// llamarse init y destroy, pueden tener el nombre que quieras, aca lo llamamos:
	public void metodoInicial() {
		// aca va el codigo que queremos ejecutar antes que el bean este disponible
		System.out.println("dentro del metodo Init(), aca van las tareas a ejecutar" 
		+ " antes que el bean este listo");

	}

	// Creamos el metodo Destroy() para ejecutar tareas despues de que el bean fue
	// utilizado
	public void metodoFinal() {
		// aca va el codigo que queremos ejecutar despues de que el bean "muere"
		System.out.println("Dentro del metodo destroy van las tareas a ejecutar "
				+ "despues de que muera nuestro bean");

	}
}
