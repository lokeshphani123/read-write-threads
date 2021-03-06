package sometry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ReaderThread implements Runnable{
 //   BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(100);

	//This is updated on 10/23/2018

	  protected BlockingQueue<String> blockingQueue = null;

	  public ReaderThread(BlockingQueue<String> blockingQueue){
	    this.blockingQueue = blockingQueue;     
	  }

	  @Override
	  public void run() {
	    BufferedReader br = null;
	     try {
	            br = new BufferedReader(new FileReader(new File("C:\\Users\\lokeshphani123\\Desktop\\New folder\\a.txt")));
	            String buffer =null;
	            while((buffer=br.readLine())!=null){
	                blockingQueue.put(buffer);
	            }
	            blockingQueue.put("EOF");  //When end of file has been reached

	        } catch (FileNotFoundException e) {

	            e.printStackTrace();
	        } catch (IOException e) {

	            e.printStackTrace();
	        } catch(InterruptedException e){

	        }finally{
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }


	  }



	
}
