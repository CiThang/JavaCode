package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchSceneB extends Application {
	
	private Stage stage;
	
	private Scene scene1;
	private VBox vBox1;
	private Button button1;
	
	private Scene scene2;
	private VBox vBox2;
	private Button button2;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		stage.setTitle("Switching Scenes");
		
		scene1 = createSceneOne();
		scene2 = createSceneTwo();
		
		stage.setScene(scene1);
		
		stage.show();
	}
	
	private Scene createSceneOne() {
		
		button1 = new Button("Click to show Scene 2");
		button1.setOnAction(e->switchScenes(scene2)); // Switch Scenes
		vBox1 = new VBox(button1);
		vBox1.setStyle("-fx-background-color: green");
		scene1 = new Scene(vBox1, 800, 500);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene1;
	}
	
	private Scene createSceneTwo() {
		
		button2 = new Button("Click to show Scene 1");
		button2.setOnAction(e -> switchScenes(scene1)); // Switch Scene
		vBox2 = new VBox(button2);
		vBox2.setStyle("-fx-background-color: yellow");
		scene2 = new Scene(vBox2,700,400);
		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene2;
	}

	
	// Switch Scenes in single Stage
	public void switchScenes(Scene scene) {
		stage.setScene(scene);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
