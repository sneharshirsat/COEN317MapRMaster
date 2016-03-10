/**
 * COEN 317 Distributed Computing (Winter 2016)
 * Final Project: MapReduce with Android Workers
 * Nishant Phatangare, Sneha Shirsat
 */
package module.communication;

import java.util.List;

import module.files.Chunk;

/**
 * @author nishant
 *
 */
public class NewConnectionListenerThread implements Runnable {
	
	
	private Thread t;
	private String threadName = "New Connection Listener Thread";
	
	private List<Chunk> allFileChunksList;
	private List<Chunk> sentFileChunksList;
	private List<Chunk> processedFileChunksList;
	
	
	public NewConnectionListenerThread (List<Chunk> all,List<Chunk> sent,List<Chunk> processed) {
		this.allFileChunksList = all;
		this.sentFileChunksList = sent;
		this.processedFileChunksList = processed;
	}
	
	public void start () {
		System.out.println("--Starting " +  threadName );
	    if (t == null) {
	    	t = new Thread (this, threadName);
	        t.start ();
	     }
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("--Running " +  threadName );
		
		
	}

}
