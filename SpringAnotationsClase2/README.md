#Pasos a seguir para utilizar annotations

1. agregar libreria "javax.annotation-api-1.3.2.jar" => esto es para poder utilizar las anottations
@PostConstruct y PreDestroy , ya que en versiones java 9 o superior no trae incorporado el paquete javax.anotation-api

2. Preparar el XML para que Spring escanee nuestro código (clases) ,OJO con el nombre del paquete debe apuntar 
al paquete donde estan las clases con anotaciones

3. agregar las annotations que necesitemos en nuestras clases 

4. Solicitar el Bean al contenedor 