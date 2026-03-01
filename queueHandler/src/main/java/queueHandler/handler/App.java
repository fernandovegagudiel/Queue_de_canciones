package queueHandler.handler;


import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class App {

    public static void main(String[] args) {

        QueueLinked<Song> highPriority = new QueueLinked<>();
        QueueLinked<Song> normalPriority = new QueueLinked<>();

        // Crear canciones
        highPriority.enqueue(new Song("Blinding Lights", "The Weeknd", 7, 1));
        highPriority.enqueue(new Song("Believer", "Imagine Dragons", 6, 1));
        highPriority.enqueue(new Song("Shape of You", "Ed Sheeran", 8, 1));


        // Ejecutar demo de reproducción
        DemoQueue dem= new DemoQueue();
        dem.playPlaylist(highPriority, normalPriority);
    }
}