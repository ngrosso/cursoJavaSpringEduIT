package ar.com.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Clase que configura par que Spring sepa que se trata del archivo de configuracion
// y que vamos a utilizar AOP e indicarle donde buscar la clase con los aspectos
@Configuration // Indicamos que esta clase es un archivo de configuracion
@EnableAspectJAutoProxy // Habilitamos la configuracion de programacion orientada a aspectos
@ComponentScan("ar.com.aop") // Le indica a donde ir a buscar los aspectos, definiendo el paquete raiz y busca en los paquetes subyacentes 
public class Configuracion {
	// Esta clase no necesita llevar codigo en su interior
}
