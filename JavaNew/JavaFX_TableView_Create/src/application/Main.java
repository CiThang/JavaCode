package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			TableView<Person> table = new TableView<Person>();
			table.setEditable(true);
			TableColumn<Person, String> firstNameColumn = new TableColumn<Person, String>("Frist Name");
			firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

			TableColumn<Person, String> lastNameColumn = new TableColumn<Person, String>("Last Name");
			lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

			TableColumn<Person, Integer> ageColumn = new TableColumn<Person, Integer>("Age");
			ageColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));

			table.getColumns().add(firstNameColumn);
			table.getColumns().add(lastNameColumn);
			table.getColumns().add(ageColumn);

			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			table.getItems().add(new Person("Buggs", "Bunny", 79));
			table.getItems().add(new Person("Daffy", "Duck", 83));
			table.getItems().add(new Person("Foghorn", "Leghorn", 74));

			root.setCenter(table);

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
