package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private BorderPane root;
	private Scene scene;
	private Label label = new Label();
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		root = new BorderPane();
		
		Button top = createButton("Top");
		Button left = createButton("Left");
		Button center = createButton("Center");
		Button right = createButton("Right");
		Button bottom = createButton("Bottom");
		
		
		
		root.setTop(top);
		root.setLeft(left);
		root.setCenter(center);
		root.setRight(right);
		root.setBottom(bottom);
		root.setCenter(label);
		
		
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Java Code - BorderPane Demo");
		stage.setScene(scene);
		stage.setMinWidth(550);
		stage.setMinHeight(400);
		stage.show();
		
	}
	
	private Button createButton(String text) {
		Button button = new Button(text);
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				label.setText(text);
				
			}
		});
		button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);
		button.setMinWidth(150);
		BorderPane.setMargin(button, new Insets(10, 10, 10, 10));
		BorderPane.setAlignment(button, Pos.CENTER);
		return button;
	}
}
