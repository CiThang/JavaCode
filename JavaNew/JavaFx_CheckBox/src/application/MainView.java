package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

	public Stage stage;
	private BorderPane root;
	private Scene scene;
	private CheckBox checkBox;
	private TitledPane titledPane;
	private DatePicker datePicker;
	
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		root = new BorderPane();
		
		// 1. Create a new CheckBox
		checkBox = new CheckBox();
		
		// 2. Set Text for a CheckBox
		checkBox.setText("Show Address");
//		checkBox = new CheckBox("Show Address");
		
		// 3. Indeterminate Property
		checkBox.setAllowIndeterminate(false);
		
		// 4. Set CheckBox value
		checkBox.setSelected(false);
		
		// 5. Get CheckBox value
//		System.out.println(checkBox.isSelected());
		
		// 6. Bonus Content
		titledPane = createTitledPane(); 
		datePicker = new DatePicker();
		
		
		VBox vBox = new VBox(checkBox,titledPane,datePicker);
		vBox.setPadding(new Insets(10));
		VBox.setMargin(checkBox, new Insets(10));
		VBox.setMargin(titledPane, new Insets(10));
		VBox.setMargin(datePicker, new Insets(10));
		
		titledPane.expandedProperty().bindBidirectional(checkBox.selectedProperty());
		
		root.setLeft(vBox);
		
		
		scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("CheckBox");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public TitledPane createTitledPane() {
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(new Label("Street Name"), 0, 1);
		gridPane.add(new TextField(), 1, 1);
		gridPane.add(new Label("Street Number"), 0, 0);
		gridPane.add(new TextField(), 1, 0);
		gridPane.add(new Label("City"), 0, 2);
		gridPane.add(new TextField(), 1, 2);
		gridPane.add(new Label("Province"), 0, 3);
		gridPane.add(new TextField(), 1, 3);
		gridPane.add(new Label("Postal Code"), 0, 4);
		gridPane.add(new TextField(), 1, 4);
		
		TitledPane titledPane = new TitledPane("Address",gridPane);
		titledPane.setExpanded(false);
		
		return titledPane;
	}
}
