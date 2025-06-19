package application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private BorderPane root;
	private Scene scene;
	
	private FXMenu fxMenu;
	private FXToolBar fxToolBar;
	private FXForm fxForm;
	private FXTable fxTable;
	private FXStatusBar fxStatusBar;
	
	
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		this.root = new BorderPane();
		root.addEventFilter(PersonEvent.ANY, this::handlePeronEvent);
		
		
		fxMenu = new FXMenu();
		fxToolBar = new FXToolBar();
		
		VBox top = new VBox(fxMenu,fxToolBar);
		root.setTop(top);
		
		fxForm = new FXForm();
		root.setLeft(fxForm);
		
		fxTable = new FXTable();
		root.setCenter(fxTable);
		
		fxStatusBar = new FXStatusBar();
		root.setBottom(fxStatusBar);
		
		scene = new Scene(root, 800, 500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Java Code - BorderPane 2");
		stage.setScene(scene);
		stage.show();
	}
	
	public void handlePeronEvent(PersonEvent event) {
		System.out.println(event.getPerson().getFirstName()+" "+event.getPerson().getLastName());
	}
}
