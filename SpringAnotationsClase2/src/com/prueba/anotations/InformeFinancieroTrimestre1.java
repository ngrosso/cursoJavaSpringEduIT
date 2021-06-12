package com.prueba.anotations;

import org.springframework.stereotype.Component;
import com.interfaces.CreacionInformesFinancieros;

// esta clase es la dependencia de la clase "ComercialExperimentado"
@Component
// con @Component registramos la clase en el contenedor de spring
public class InformeFinancieroTrimestre1 implements CreacionInformesFinancieros {

	@Override
	public String getInformeFinanciero() {
		return "presentacion del informe financiero del primer trimestre";
	}

}
