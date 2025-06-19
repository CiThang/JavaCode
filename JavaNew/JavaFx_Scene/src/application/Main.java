package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	private Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			this.stage.setTitle("Primary Stage");
			
			Parent root = new VBox();
//			Scene scene = new Scene(root);
//			Scene scene = new Scene(root,Color.RED);
//			Scene scene = new Scene(root,400,400);
			Scene scene = new Scene(root,400,300,Color.RED);
			
			// Thiet lap con tro chuot
			scene.setCursor(Cursor.CROSSHAIR);
			
			this.stage.setScene(scene);
			this.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
