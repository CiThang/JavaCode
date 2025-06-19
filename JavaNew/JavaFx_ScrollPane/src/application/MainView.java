package application;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView {

	private Scene scene;
	private BorderPane root;
	private Stage stage;
	
	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}
	
	private void buildUI() {
		
		root = new BorderPane();
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(getImage());
		
		// Di chuyen anh bang chuot
		scrollPane.setPannable(true);
		
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		root.setCenter(scrollPane);
		scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("ScrollPane Demo");
		stage.setScene(scene);
	}
	public void show() {
		this.stage.show();
	}
	private ImageView getImage() {
		Image image = new Image("file:D:\\Pictures\\3.png");
		ImageView iview = new ImageView(image);
		return iview;
	}
}
