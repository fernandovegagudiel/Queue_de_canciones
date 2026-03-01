## 1️ Cómo compilar la librería

### 🔹 Desde consola

1. Abrir una terminal.
2. Ubicarse en la raíz del proyecto `queue-library` (donde se encuentra el `pom.xml`).

mvn clean install

Este comando:
- Limpia compilaciones anteriores.
- Compila el proyecto.
- Instala la librería en el repositorio local de Maven.

### 🔹 Desde Eclipse

1. Clic derecho sobre el proyecto `queue-library`.
2. Seleccionar Run As → Maven Build.
3. En Goals escribir:
clean install
4. Ejecutar.


## 2️ Cómo instalar en local

Al ejecutar:
mvn clean install

La librería:
- Genera el archivo .jar
- Se instala en el repositorio local (.m2)
- Puede ser utilizada como dependencia en otros proyectos Maven

Para usarla en otro proyecto, agregar en el pom.xml:

<dependency>
    <groupId>umg.edu.gt</groupId>
    <artifactId>queue-library</artifactId>
    <version>1.0.0</version>
</dependency>


## 3️ Cómo compilar el handler

El proyecto `handler` es el módulo que utiliza la librería para ejecutar la simulación de la cola de canciones.

Este proyecto tiene configurada la dependencia hacia `queue-library` en su `pom.xml`.

### 🔹 Desde consola

Ubicarse en la carpeta raíz del `handler`:

mvn clean package

Esto genera el archivo ejecutable dentro de la carpeta `target/`.

### 🔹 Desde Eclipse

1. Clic derecho sobre el proyecto `handler`.
2. Run As → Maven Build
3. En Goals escribir:
clean package


## 4️ Cómo ejecutar desde consola

Para ejecutar el handler desde consola:

java -jar target/handler-1.0.0.jar

Este comando inicia la ejecución del sistema que simula la cola de canciones con prioridad.


## 5️ Explicación del diseño

El sistema fue dividido en dos módulos Maven independientes:

### Proyecto `queue-library`

Contiene la implementación manual de la estructura de datos:
- QueueLinked<T>
- Node<T>

Este módulo funciona como una librería reutilizable.

Se utilizan:
- Referencias privadas head y tail para controlar la cola.
- Una variable size para llevar el control del número de elementos.
- Encapsulamiento para exponer únicamente los métodos necesarios.

### Proyecto `handler`

Contiene la lógica que utiliza la estructura:
- Gestión de canciones
- Uso de prioridad
- Clase principal que ejecuta la simulación

Se aplicó separación de responsabilidades:
- La estructura de datos no contiene lógica de negocio.
- El handler no implementa estructuras internas.
- La clase principal únicamente inicia el sistema.


## 6️ Decisiones técnicas

- Se utilizó una estructura enlazada manual en lugar de un arreglo dinámico.
- Se implementó el principio FIFO (First In, First Out).
- Se agregó soporte para prioridad en la gestión de canciones.
- Se mantuvo el proyecto modular separando librería y ejecución.
- Se utilizó Maven para la gestión de dependencias y empaquetado.


## 7️ Cómo implementaste la prioridad

La prioridad se maneja separando las canciones según su nivel.

Se pueden utilizar dos colas:

private QueueLinked<Song> highPriority;
private QueueLinked<Song> normalPriority;

Al agregar una canción:

if (song.getPriority() == 1) {
    highPriority.enqueue(song);
} else {
    normalPriority.enqueue(song);
}

Durante la ejecución:
1. Se procesan primero las canciones de alta prioridad.
2. Luego se procesan las canciones normales.

Esto garantiza que las canciones importantes se atiendan primero.


## Conclusión

El proyecto fue desarrollado utilizando Java y gestionado mediante Maven.

Se implementó:
- Cola enlazada genérica manual
- Arquitectura modular con librería reutilizable
- Manejo de prioridad
- Separación clara de responsabilidades
- Empaquetado y gestión mediante Maven
