package ar.com.aop.aspectos;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// esta clase sera nuestro aspecto y contendra esa funcionalidad transversal 
// que tiene que ejecutarse siempre
@Component 	// Indicamos que es un componente
@Aspect 	// Indicamos que esta clase es un aspecto
public class LoginConAspectos {
	
	// Utilizamos before para que se ejecute antes del metodo "insertaCliente()"
	//@Before("execution(public void insertaCliente())")
	// que pasa si tengo mas de un metodo con ese nombre en distintas clases? hacemos la prueba
	// con la clase clienteVIPDAO, el aspecto se va a ejecutar siempre porque no hace distincion de nombre de clase
	// que pasa si quiero que solo se ejecute este aspecto para ClienteVIPDAO??
	// para ello debemos incluir la ruta en la anotacion @Before
	//@Before("execution(public void ar.com.aop.dao.ClienteVIPDAO.insertaCliente())")
	// Otro ejemplo es usar pointCut para que se ejecute en muchos casos genericos:
	@Before("execution(public void inserta*())")
	public void antesInsertarCliente() {
		System.out.println("Se comprobo que el usuario esta logueado");
		System.out.println("Se comprobo el rol/perfil del usuario logueado "
				+ "y puede realizar operaciones CRUD en las tablas de la base de datos");
	}
	
	
	// Esta anotacion ejecuta un advice despues de la ejecucion del pointcut especificado,
	// Siempre que el metodo del punto de corte "retorne de forma normal", sin excepciones
	@AfterReturning("execution(public void inserta*())")
	public void despuesDeInsertarCliente() {
		System.out.println("Se ejecuta despues de insertar un cliente");
	}
	
	@AfterThrowing(pointcut="execution(public * insertaClienteVIPConError())", throwing = "daoe")
	public void logException(Exception daoe) {
		System.out.println("Sucedio un error en el metodo insertaClienteVIPConErrore() y por eso me acabo de ejecutar");
		System.out.println("aqui podriamos disparar una alerta al area de monitoreo para que se verifique");
	}
}
