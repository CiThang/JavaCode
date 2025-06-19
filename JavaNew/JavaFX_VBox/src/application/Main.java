package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("VBox Explorer");
			
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.CENTER);
			
			Button button1 = new Button("One");
			Button button2 = new Button("Two");
			Button button3 = new Button("Three");
			
			button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			
			vBox.setVgrow(button1, Priority.ALWAYS);
			vBox.setVgrow(button2, Priority.ALWAYS);
			vBox.setVgrow(button3, Priority.ALWAYS);
			
			vBox.getChildren().addAll(button1,button2,button3);
			
			Scene scene = new Scene(vBox, 500, 300);
			
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
