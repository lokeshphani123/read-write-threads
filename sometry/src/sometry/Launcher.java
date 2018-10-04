package sometry;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			    BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

			    ReaderThread reader = new ReaderThread(queue);
			    WriterThread writer = new WriterThread(queue);

			    new Thread(reader).start();
			    new Thread(writer).start();


	}

}
