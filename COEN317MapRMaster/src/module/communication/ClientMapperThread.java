/**
 * COEN 317 Distributed Computing (Winter 2016)
 * Final Project: MapReduce with Android Workers
 * Nishant Phatangare, Sneha Shirsat
 */
package module.communication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author nishant
 *
 */
public class ClientMapperThread implements Runnable {
	
	private Thread t;
	private String threadName = "Client Mapper Thread";
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private int StoCPort=50000;
	
	private String chunkToRead = "/home/nishant/Desktop/COEN317/chunksebook/1.txt";
	

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	public void start () {
		System.out.println("--Starting " +  threadName );
	    if (t == null) {
	    	t = new Thread (this, threadName);
	        t.start ();
	     }
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("--Running " +  threadName );
		
		
		try {
	        serverSocket = new ServerSocket(StoCPort);  //Server socket
	        

	    } catch (IOException e) {
	        System.out.println("Could not listen on port: "+StoCPort);
	    }

	    System.out.println("Server started. Listening to the port "+StoCPort);

	    while (true) {
	        
	    	try {
	        	
	            clientSocket = serverSocket.accept();   //accept the client connection
	            
                // sending to client (pwrite object)
	            OutputStream ostream = clientSocket.getOutputStream(); 
	            PrintWriter pwrite = new PrintWriter(ostream, true);
				
				// receiving from server ( receiveRead  object)
				InputStream istream = clientSocket.getInputStream();
				BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
				
				String receiveMessage;
				String sendMessage = "This is from PC by Nishant";
				  
				// The name of the file to open.
			     //String fileName = this.fileName;//"/home/nishant/Documents/OSfilesendTest.txt";
			     String line2 = null;
				  
				  // FileReader reads text files in the default encoding.
		            FileReader fileReader = 
		                new FileReader(chunkToRead);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);
		            
		            String line3 = "---fileSendingFinishedByServer---";
		            System.out.println("file being sent - " +chunkToRead); 
		            while((line2 = bufferedReader.readLine()) != null) {
					  //line3 = line3 + line2;
					  pwrite.println(line2);             
					  pwrite.flush();
					  //System.out.println(line2);
		            } 	
		            // Always close files.
		            bufferedReader.close();  
		            pwrite.println(line3);             
					pwrite.flush();
				  
				  while(true)
				  {
				    if((receiveMessage = receiveRead.readLine()) != null)  
				    {
				       System.out.println("Current Count: " +receiveMessage);  
				       //long countInThisFile = processReceivedResult(receiveMessage);
				       //System.out.println("Total Count so far: " +countInThisFile);
				    }         
				   
				  }               
			
	        } catch (IOException ex) {
	            System.out.println("Problem in message reading");
	        }
	        
	    }

	}

}
