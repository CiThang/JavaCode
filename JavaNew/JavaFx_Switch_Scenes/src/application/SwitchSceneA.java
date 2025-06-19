package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SwitchSceneA extends Application {

	// Two Stages and Two Scenes
	
	private Stage stage1;
	private Scene scene1;
	private VBox vBox1;
	private Button button1;
	
	private Stage stage2;
	private Scene scene2;
	private VBox vBox2;
	private Button button2;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage1 = createStageOne();
		stage2 = createStageTwo();
		
		stage1.show();
		
	}

	private Stage createStageOne() {
		
		stage1 = new Stage(StageStyle.DECORATED);
		stage1.setTitle("Stage 1");
		button1 = new Button("Click to show Stage 2");
		button1.setOnAction(e -> stage2.show());
		vBox1 = new VBox(button1);
		vBox1.setStyle("-fx-background-color: green");
		scene1 = new Scene(vBox1,800,500);
		
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage1.setScene(scene1);
		
		return stage1;
	}
	
	private Stage createStageTwo() {
		
		stage2 = new Stage(StageStyle.DECORATED);
		stage2.setTitle("Stage 2");
		stage2.initOwner(stage1);
		stage2.initModality(Modality.APPLICATION_MODAL);
		button2 = new Button("Click to close Stage 2");
		button2.setOnAction(e-> stage2.close());
		vBox2 = new VBox(button2);
		vBox2.setStyle("-fx-background-color: yellow");
		scene2 = new Scene(vBox2,700,400);
		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage2.setScene(scene2);
		
		return stage2;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
