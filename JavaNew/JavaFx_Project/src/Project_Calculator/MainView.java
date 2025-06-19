package Project_Calculator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {

	private Label lbla;
	private Label lblb;
	private TextField txta;
	private TextField txtb;
	private Button btnCong;
	private Button btnTru;
	private Button btnNhan;
	private Button btnChia;
	private Button btnBar;
	
	private Scene scene;
	private Stage stage;
	private BorderPane root;
	
	
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		root = new BorderPane();
		
		
		scene = new Scene(root,200,500);
//		scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());
		stage.setTitle("Calculator");
		}
	
	public void show() {
		this.stage.show();
	}
}
