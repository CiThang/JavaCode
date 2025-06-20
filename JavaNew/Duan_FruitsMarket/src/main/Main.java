package main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static final String CURRENCY = "$";
	@Override
	public void start(Stage primaryStage) {
		try {          
	           	Parent root = FXMLLoader.load(getClass().getResource("../views/market.fxml"));
	            Scene scene = new Scene(root);
	            
	            primaryStage.setTitle("Fruits Marker");
	            primaryStage.setScene(scene);
	            primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
