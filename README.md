# Queue_de_canciones
# Proyecto: Cola Genérica con Prioridad y Simulación

## Cómo compilar la librería
Para compilar la librería me ubico en la carpeta raíz del proyecto (donde está el `pom.xml`) y ejecuto:
```bash
mvn clean install

### Cómo compilar el handler
El handler es el módulo que utiliza la librería. Para compilarlomvn:
mvn clean package , Esto genera un JAR ejecutable en la carpeta target/.

### Como instalar en local 
Con el comando anterior (mvn install) la librería queda disponible en mi repositorio Maven local.
Si quiero usarla en otro proyecto, agrego la dependencia en el pom.xml del consumidor:

<dependency>
    <groupId>umg.edu.gt</groupId>
    <artifactId>queue-library</artifactId>
    <version>1.0.0</version>
</dependency>

### Como compilar el handler
El handler es el módulo que utiliza la librería. Para compilarlo ejecuto:```mvn clean package



### Cómo ejecutar desde consola
Para correr el handler desde consola utilizo:```java -jar target/handler-1.0.0.jar

### Explicación del diseño
-- Implementé una cola genérica (QueueLinked<T>) que permite almacenar cualquier tipo de dato.
- Creé la clase Node<T> para encapsular el valor y la referencia al siguiente nodo.
- Uso referencias privadas head y tail para manejar el frente y el final de la cola.
- Mantengo una variable interna size para controlar el tamaño actual.
- Encapsulé correctamente los atributos, exponiendo solo los métodos necesarios.
- Separé responsabilidades: la librería implementa la estructura, el handler (DemoQueue) se encarga de la simulación y ejecución.
.

  ### Decisiones técnicas
- Opté por una estructura enlazada en lugar de un arreglo dinámico para evitar redimensionamientos costosos.
- La cola se implementó como FIFO con soporte para prioridad.
- Mantengo el código modular: nodos, cola y simulación están en clases distintas.
- Uso Maven para gestionar dependencias y empaquetado, lo que facilita la reutilización en otros proyectos.

  








