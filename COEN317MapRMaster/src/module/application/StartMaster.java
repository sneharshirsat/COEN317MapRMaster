package module.application;
import javafx.application.Application;
import javafx.stage.Stage;
import module.files.FileSelectorThread;


public class StartMaster extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Application Started");
		
		new FileSelectorThread().start(); 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
