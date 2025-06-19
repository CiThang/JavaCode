package application;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private TilePane tilePane;
	private Scene scene;
	private Button[] buttons;
	
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		
		// 1. Create TilePane
		tilePane = new TilePane();
		tilePane.setPadding(new Insets(10));
		
		// 2. Add Child Nodes to the TilePane
		buttons = new Button[51];
		for(int i=1; i<51;i++) {
			Button button = new Button(Integer.toString(i));
			button.setPrefWidth(50);
			button.setPrefHeight(50);
			tilePane.getChildren().add(button);
			buttons[i]=button;
			
		}
		
		// 3. Set TilePane Orientation
		tilePane.setOrientation(Orientation.HORIZONTAL);
//		tilePane.setOrientation(Orientation.VERTICAL);
		
		
		// 4. Set Horizontal Gap and Vertical Gap
		tilePane.setHgap(5);
		tilePane.setVgap(5);
		
		// 5. Set preferred number of columns and rows
		tilePane.setPrefColumns(10);
//		tilePane.setPrefRows(10);
		
		
		// 6. Set default child Node alignment for the TilePane
		buttons[25].setPrefHeight(75);
		buttons[25].setPrefWidth(75);
		tilePane.setTileAlignment(Pos.TOP_LEFT);
		
		
		// 7. Set explicit child Node alignment for the TilePane
		TilePane.setAlignment(buttons[1], Pos.BOTTOM_RIGHT);
		TilePane.setAlignment(buttons[50], Pos.BOTTOM_RIGHT);
		
		scene = new Scene(tilePane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("TilePane Demo");
		stage.setScene(scene);
		stage.show();
	}
	
}
