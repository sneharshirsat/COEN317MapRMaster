/**
 * COEN 317 Distributed Computing (Winter 2016)
 * Final Project: MapReduce with Android Workers
 * Nishant Phatangare, Sneha Shirsat
 */
package module.communication;

/**
 * @author nishant
 *
 */
public class ClientMapperThread implements Runnable {
	
	private Thread t;
	private String threadName = "Client Mapper Thread";

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

	}

}
