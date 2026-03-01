# Proyecto: Cola Genérica con Prioridad y Simulación

Este proyecto consiste en una cola genérica hecha manualmente en Java y luego una simulación donde se usan canciones con prioridad.

El proyecto está dividido en dos partes: una librería donde está la estructura de datos y otro módulo que la utiliza para hacer la simulación.

---

## 1️ Cómo compilar la librería

### Desde consola

Primero hay que ubicarse en la carpeta `queue-library`, donde está el archivo `pom.xml`.

Luego ejecutar:

```bash
mvn clean install
```

Este comando limpia lo anterior, compila el proyecto y deja la librería instalada en el repositorio local de Maven.

### Desde Eclipse

- Clic derecho al proyecto `queue-library`
- Run As → Maven Build
- En Goals escribir:

```
clean install
```

- Ejecutar

---

## 2️ Cómo usar la librería en otro proyecto

Después de hacer `mvn clean install`, la librería ya queda disponible en el repositorio local (.m2).

Si se quiere usar en otro proyecto Maven, solo se agrega esta dependencia en el `pom.xml`:

```xml
<dependency>
    <groupId>umg.edu.gt</groupId>
    <artifactId>queue-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## 3️ Cómo compilar el handler

El proyecto `handler` es el que usa la librería para simular la cola de canciones.

Desde la carpeta del handler ejecutar:

```bash
mvn clean package
```

Esto genera el `.jar` dentro de la carpeta `target`.

Desde Eclipse es parecido:

- Clic derecho al proyecto `handler`
- Run As → Maven Build
- En Goals escribir:

```
clean package
```

---

## 4️ Cómo ejecutar

Después de compilar, se puede ejecutar desde consola con:

```bash
java -jar target/handler-1.0.0.jar
```

Eso inicia la simulación de la cola de canciones.

---

## 5️ Cómo está organizado el proyecto

El proyecto está separado en dos módulos:

### queue-library

Aquí hice la estructura de datos manual:

- `QueueLinked<T>`
- `Node<T>`

La cola funciona con referencias `head` y `tail`, y una variable `size` para saber cuántos elementos hay.

Esta parte no tiene nada que ver con canciones, solo es la estructura como tal.

### handler

Aquí ya se usan canciones y se aplica la prioridad.

Este módulo solo usa la cola, no implementa la estructura desde cero.

Separé las cosas así para que la estructura se pueda reutilizar en otros proyectos si se quiere.

---

## 6️ Decisiones que tomé

- Usé una lista enlazada en vez de un arreglo para no estar redimensionando.
- La cola funciona con el principio FIFO (First In, First Out), o sea que lo primero que entra es lo primero que sale.
- Agregué prioridad para que algunas canciones se reproduzcan antes que otras.
- Usé Maven para organizar dependencias y poder generar el .jar fácilmente.

---

## 7️ Cómo funciona la prioridad

La prioridad la manejé separando las canciones en dos colas.

Por ejemplo:

```java
private QueueLinked<Song> highPriority;
private QueueLinked<Song> normalPriority;
```

Cuando se agrega una canción:

```java
if (song.getPriority() == 1) {
    highPriority.enqueue(song);
} else {
    normalPriority.enqueue(song);
}
```

Al momento de reproducir, primero se revisa la cola de alta prioridad y luego la normal.

Así las canciones importantes salen antes.

---

## Conclusión

En este proyecto hice una cola genérica manual en Java y luego la usé para simular una cola de canciones con prioridad.

Se trabajó con estructura enlazada, separación en módulos y uso de Maven para compilar y empaquetar.
