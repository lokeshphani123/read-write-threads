package sometry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WriterThread implements Runnable{

//    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(100);

	//This is updated on 10/23/2018

	 protected BlockingQueue<String> blockingQueue = null;

	  public WriterThread(BlockingQueue<String> blockingQueue){
	    this.blockingQueue = blockingQueue;     
	  }

	  @Override
	  public void run() {
	    PrintWriter writer = null;

	    try {
	        writer = new PrintWriter(new File("C:\\Users\\lokeshphani123\\Desktop\\New folder\\b.txt"));

	        while(true){
	            String buffer = blockingQueue.take();
	            //Check whether end of file has been reached
	            if(buffer.equals("EOF")){ 
	                break;
	            }
	            writer.println(buffer);
	        }               


	    } catch (FileNotFoundException e) {

	        e.printStackTrace();
	    } catch(InterruptedException e){

	    }finally{
	        writer.close();
	    } 

	  }


}
