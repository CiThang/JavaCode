package application;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.FlowPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane flowPane = new FlowPane();
			
			Button button1 = new Button("One");
			Button button2 = new Button("Two");
			Button button3 = new Button("Three");
			Button button4 = new Button("Four");
			
			flowPane.getChildren().addAll(button1,button2,button3,button4);
			flowPane.setOrientation(Orientation.VERTICAL);
			flowPane.setVgap(10);
			flowPane.setHgap(10);
			
			
			primaryStage.setScene(new Scene(flowPane, 300, 275));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
