package queueHandler.handler;

	import umg.edu.gt.data_structure.queue.manual.QueueLinked;

	public class DemoQueue {

		 public void playPlaylist(QueueLinked<Song> highPriority,
                 QueueLinked<Song> normalPriority) {

System.out.println("[LOG] Starting playlist...");

	while (!highPriority.isEmpty()) {
		play(highPriority.dequeue());
	}

	while (!normalPriority.isEmpty()) {
		play(normalPriority.dequeue());
	}

	System.out.println("[LOG] Playlist finished.");
		 }

		 private void play(Song song) {

	System.out.println("[LOG] Now playing: " + song);

	for (int i = 1; i <= song.getDuration(); i++) {
			try {
    Thread.sleep(1000);

    String bar = drawBar(i, song.getDuration());

    System.out.println("[LOG] Playing: "
            + song.getTitle()
            + " | "
            + bar
            + " "
            + i + "s / "
            + song.getDuration() + "s");

				} catch (InterruptedException e) {
    System.out.println("Error en la reproducción.");
							}
	}

		System.out.println("[LOG] Finished: " + song.getTitle() + "\n");
			}

   			private String drawBar(int current, int total) {

       if (total <= 0) return "[----------]";

    StringBuilder bar = new StringBuilder("[");
     int progress = (current * 10) / total;

    for (int i = 0; i < 10; i++) {
    bar.append(i < progress ? "#" : "-");
      }

return bar.append("]").toString();
}
	}


