package application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView {
	
	private Stage stage;
	private PersonTableView table;
	
	
	public MainView() {
		buildUI();
	}

	private void buildUI() {

		BorderPane root = new BorderPane();

		stage = new Stage(StageStyle.DECORATED);
		
		table = new PersonTableView();
		
		table.add(new Person("Buggs", "Bunny", 79));
		table.add(new Person("Daffy", "Duck", 83));
		table.add(new Person("Foghorn", "Leghorn", 74));
		root.setCenter(table);

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("TableView");
		stage.setScene(scene);
		stage.show();
	
		
	}
}
