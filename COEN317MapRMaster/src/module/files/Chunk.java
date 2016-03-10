/**
 * COEN 317 Distributed Computing (Winter 2016)
 * Final Project: MapReduce with Android Workers
 * Nishant Phatangare, Sneha Shirsat
 */
package module.files;


public class Chunk {
	
	private String chunkFileName;
	private boolean sent;
	private boolean processed;
	
	public String getChunkFileName() {
		return chunkFileName;
	}
	public void setChunkFileName(String chunkFileName) {
		this.chunkFileName = chunkFileName;
	}
	public boolean isSent() {
		return sent;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
	
}
