package com.prueba.anotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;
import com.interfaces.IEmpleados;

//	Podemos prescindir de darle un nombre o un id al componente, en ese caso
//	Spring tomaria como id el nombre de la clase, pero con la primer letra en minuscula
//	entonces se vuelve muy importante escribir bien el nombre de nuestras clases,
//	para no tener problemas luego al solicitar nuestro beans.
//@Component()
//	Utilizamos una anotation @Component y le definimos un ID,
//	no es necesario que el nombre coincida con el nombre de la clase.
//	Una vez importada la anotation ya tendriamos registrado nuestro Bean
@Component("comercialExperimentado")
//@Scope("prototype")
public class ComercialExperimentado implements IEmpleados{
	
	//Creacion de atributo de tipo CreacionInformesFinancieros para iny de dependencias
	private CreacionInformesFinancieros informeNuevo;

	// El Override chequea que exista el metodo en la clase padre, 
	//no es obligatorio utilizarlo pero si recomendable
	@Override 	
	public String getTareas() {
		return "Soy un vendedor y me encargo de vender mucho!";
	}

	@Override
	public String getInforme() {
		// Utilizamos el metodo getInforme de la interface (Sin la inyeccion de dependencia)
		//return "Informe creado por el comercial con mucha experiencia";
		
		//Ahora lo hacemos con la DI = Dependency Inyection (osea @Autowired ya implementado)
		return informeNuevo.getInformeFinanciero();
	}
	
	// Creamos el constructor para que a traves de este podamos inyectar la dependencia
	// con la notacion @Autowired, spring busca en mi paquete o proyecto si existe la clase
	// que implemente la interface InformeFinanciero y si la encuentra es de esa 
	// clase de donde obtiene la dependencia, una vez que spring detecta la clase,
	// solamente deberiamos llamar a getInforme()
	
	@Autowired
	public ComercialExperimentado(CreacionInformesFinancieros informeNuevo) {
		this.informeNuevo = informeNuevo; 
	}
	
	//Nota sobre Autowired: Si comentamos la anotacion @Autowired sigue funcionando, 
	//pero depende de la version de spring, en las ultimas versiones no es necesario utilizarlo. 
	//Si el bean que necesita utilizar la inyeccion de dependencia define solamente un UNICO CONSTRUCTOR 
	//y es justo nuestro caso. Como recomendacion utilicen SIEMPRE @Autowired para que a la hora de escalar 
	//la aplicacion y agregar mas constructores no se vuelve engorroso el codigo.
	//Autowired tambien se puede implementar en atributos, esto es posible gracias al concepto de Reflexion
	//e incluso en setters
	//--------------------------------------------------------------------------------------------------------
	// Para usar @PostConstruct y @PreDestroy, si o si debemos utilizar el Scope SINGLETON
	// esto se debe a que Spring no controla el ciclo de vida por completo del bean si trabajamos
	// con un Scope Prototype
	
	// Ejecucion de codigo despues de la creacion del bean
	// Este codigo se ejecuta despues de la construccion del bean

	@PostConstruct
	public void ejecutarDespuesCreacion() {
		System.out.println("Ejecutando tras la creacion del bean");
	}

	// Ejecucion de codigo del apagado del contenedor de Spring

	@PreDestroy
	public void ejecutarAntesDestroy() {
		System.out.println("Ejecutando tareas magicas antes de la destruccion");
	}

	
	
	
}
