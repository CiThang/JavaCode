package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			TableView<PersonEdit> table = new TableView<>();
			table.setEditable(true);
			TableColumn<PersonEdit, String> firstNameColumn = new TableColumn<>("First Name");
			firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
			firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonEdit,String>>() {
				
				@Override
				public void handle(CellEditEvent<PersonEdit, String> event) {
					PersonEdit personEdit = event.getRowValue();
					personEdit.setFirstName(event.getNewValue());
					
				}
			});
			
			
			TableColumn<PersonEdit, String> lastNameColumn = new TableColumn<>("Last Name");
			lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
			lastNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonEdit,String>>() {
				
				@Override
				public void handle(CellEditEvent<PersonEdit, String> event) {
					PersonEdit personEdit = event.getRowValue();
					personEdit.setLastName(event.getNewValue());
					
				}
			});
			
			
			TableColumn<PersonEdit, Integer> ageColumn = new TableColumn<>("Age");
			ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
			ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			ageColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonEdit,Integer>>() {
				
				@Override
				public void handle(CellEditEvent<PersonEdit, Integer> event) {
					PersonEdit personEdit = event.getRowValue();
					personEdit.setAge(event.getNewValue());
					
				}
			});
			
			
			table.getColumns().add(firstNameColumn);
			table.getColumns().add(lastNameColumn);
			table.getColumns().add(ageColumn);

			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			table.getItems().add(new PersonEdit("Buggs", "Bunny", 79));
			table.getItems().add(new PersonEdit("Daffy", "Duck", 83));
			table.getItems().add(new PersonEdit("Foghorn", "Leghorn", 74));

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
