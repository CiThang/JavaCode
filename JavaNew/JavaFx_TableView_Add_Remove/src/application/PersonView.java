package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

public class PersonView extends VBox {

	private TableView<Person> table;
	private TableColumn<Person, String> firstNameColumn;
	private TableColumn<Person, String> lastNameColumn;	
	private TableColumn<Person, Integer> ageColumn;
	
	private TextField firstName;
	private TextField lastName;
	private TextField age;

	private Button btnAdd;
	private Button btnDelete;
	
	public PersonView() {
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

		firstName = new TextField();
		firstName.setPromptText("First Name");
		firstName.setTooltip(new Tooltip("Enter first name"));
		lastName = new TextField();
		lastName.setPromptText("Last Name");
		lastName.setTooltip(new Tooltip("Enter last name"));
		age = new TextField();
		age.setPromptText("Age");
		age.setTooltip(new Tooltip("Enter age"));
		
		HBox hbox1 = new HBox();
		hbox1.setSpacing(10);
		hbox1.setPadding(new Insets(10,10,10,10));
		hbox1.getChildren().addAll(firstName,lastName,age);
		
		btnAdd = new Button("Add");
		btnAdd.setPrefWidth(100);
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Person person = new Person(firstName.getText(),lastName.getText(),Integer.parseInt(age.getText()));
				add(person);
			}
		});
		btnDelete = new Button("Delete");
		btnDelete.setPrefWidth(100);
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int row = table.getSelectionModel().getSelectedIndex();
				delete(row);
				
			}
		});
		
		HBox hbox2 = new HBox();
		hbox2.setSpacing(10);
		hbox2.setPadding(new Insets(8,10,10,10));
		hbox2.getChildren().addAll(btnAdd,btnDelete);
		hbox2.setAlignment(Pos.TOP_RIGHT);
		getChildren().addAll(table,hbox1,hbox2);
	}
	
	public void add(Person person) {
		table.getItems().add(person);
		clearFields();
	}
	
	public void delete(int row) {
		if(row>=0) {
			table.getItems().remove(row);
			table.getSelectionModel().clearSelection();
		}
	}
	
	private void clearFields() {
		firstName.clear();
		lastName.clear();
		age.clear();
		firstName.requestFocus();
	}
}
