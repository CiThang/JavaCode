package application;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

public class PersonTableView extends VBox {

	private TableView<Person> table;
	private TableColumn<Person, String> firstNameColumn;
	private TableColumn<Person, String> lastNameColumn;	
	private TableColumn<Person, Integer> ageColumn;
	public PersonTableView() {
		buildUI();
	}

	private void buildUI() {
		table = new TableView<>();
		table.setEditable(true);
		firstNameColumn = new TableColumn<>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
			
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				Person Person = event.getRowValue();
				Person.setFirstName(event.getNewValue());
				
			}
		});
		
		
		lastNameColumn = new TableColumn<>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,String>>() {
			
			@Override
			public void handle(CellEditEvent<Person, String> event) {
				Person Person = event.getRowValue();
				Person.setLastName(event.getNewValue());
				
			}
		});
		
		
		ageColumn = new TableColumn<>("Age");
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
		ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		ageColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person,Integer>>() {
			
			@Override
			public void handle(CellEditEvent<Person, Integer> event) {
				Person Person = event.getRowValue();
				Person.setAge(event.getNewValue());
				
			}
		});
		
		
		table.getColumns().add(firstNameColumn);
		table.getColumns().add(lastNameColumn);
		table.getColumns().add(ageColumn);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		

		getChildren().add(table);
	}
	
	public void add(Person person) {
		table.getItems().add(person);
	}
}
