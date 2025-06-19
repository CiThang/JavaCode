package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
//	private BorderPane root;
	private Scene scene;
	
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		StackPane stackPane = new StackPane();
		
		// Layer 1  - Image
		ImageView iview = new ImageView("file:D:\\Pictures\\3.png");
		stackPane.getChildren().add(iview);
		
		// Layer 2 - Label
		Label label = new Label("Do, or do not! There is no try");
		stackPane.getChildren().add(label);
		StackPane.setAlignment(label, Pos.BOTTOM_CENTER);
		
		// Layer 3 - Button
		Button button = new Button("Click");
		button.setOnAction(e -> label.setText("Always pass on what you have learned"));
		stackPane.getChildren().add(button);
		StackPane.setAlignment(button, Pos.TOP_RIGHT);
		
		scene = new Scene(stackPane,800,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("StackPane Demo");
		stage.setScene(scene);
		stage.show();
	}
	
}
