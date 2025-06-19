package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchSceneC extends Application {

	private Stage stage;
	private Scene scene;
	private BorderPane borderPane;

	private VBox vBox1;
	private Button button1;

	private VBox vBox2;
	private Button button2;

	@Override
	public void start(Stage primarytaStage) throws Exception {
		stage = primarytaStage;
		stage.setTitle("Switching Scenes");

		vBox1 = createPaneOne();
		vBox2 = createPaneTwo();
		
		borderPane = new BorderPane();
		borderPane.setTop(new VBox(new Button("Top")));
		borderPane.setLeft(new VBox(new Button("Left")));
		borderPane.setRight(new VBox(new Button("Right")));
		borderPane.setBottom(new VBox(new Button("Bottom")));
		
		borderPane.setCenter(vBox1);
		
		scene = new Scene(borderPane, 800, 500);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage.setScene(scene);
		
		stage.show();
	}

	private VBox createPaneOne() {
		button1 = new Button("Click to show Pane 2");
		button1.setOnAction(e -> switchPanes(vBox2));
		vBox1 = new VBox(button1);
		vBox1.setStyle("-fx-background-color: green");

		return vBox1;
	}

	private VBox createPaneTwo() {
		button2 = new Button("Click to show Pane 1");
		button2.setOnAction(e -> switchPanes(vBox1));
		vBox2 = new VBox(button2);
		vBox2.setStyle("-fx-background-color: yellow");

		return vBox2;
	}

	// Switch Layout Panes in Center of BorderPane
	public void switchPanes(Pane pane) {
		borderPane.setCenter(pane);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
