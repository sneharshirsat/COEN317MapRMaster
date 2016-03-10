/**
 * COEN 317 Distributed Computing (Winter 2016)
 * Final Project: MapReduce with Android Workers
 * Nishant Phatangare, Sneha Shirsat
 */
package module.files;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;


public class FileSelectorThread implements Runnable {
	
	private Thread t;
	private String threadName = "FileSelector Thread";
	private String chunkPath = "/home/nishant/Desktop/COEN317/chunks";
	private File selectedFile;
	private long totalChunks;
	
	private List<Chunk> allFileChunksList;
	private List<Chunk> sentFileChunksList;
	private List<Chunk> processedFileChunksList;
	// = new ArrayList<Chunk>();
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	public FileSelectorThread() {
		this.allFileChunksList = new ArrayList<Chunk>();
		this.sentFileChunksList = new ArrayList<Chunk>();
		this.processedFileChunksList = new ArrayList<Chunk>();
		
	}
	
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
		
		//Open UI for file chooser
    	Container c = new Container();
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    	int result = fileChooser.showOpenDialog(c);
    	
    	if (result == JFileChooser.APPROVE_OPTION) {
    		selectedFile = fileChooser.getSelectedFile();
    		System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    	}
	}
	
	private void splitFile(){
		int countLines = 0;
		String line = null;
		int chunkNumer = 0;
		String chunkfileContent = "";
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(selectedFile);
			bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				countLines++;
				chunkNumer = countLines/20;
				String extentionRemoved = selectedFile.getName().split("\\.")[0];
				chunkPath = chunkPath +extentionRemoved +"/";
				
				File theDir = new File(chunkPath);
            	// if the directory does not exist, create it
            	if (!theDir.exists()) {
            	    System.out.println("creating new directory: ");
            	    boolean result = false;

            	    try {
            	        theDir.mkdir();
            	        result = true;
            	    } 
            	    catch(SecurityException se){
            	        //handle it
            	    }        
            	    if(result) {    
            	        System.out.println("DIR created");  
            	    }
            	}
            	chunkfileContent = chunkfileContent +"\n"+ line;
            	if(countLines%20 == 0) {
            		
            		//writeLineToFile(chunkfileContent,chunkPath,chunkNumer);
            		chunkfileContent = "";
            	}
			}
			//writeLineToFile(chunkfileContent,chunkPath,chunkNumer);
            // Always close files.
            bufferedReader.close();     
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
