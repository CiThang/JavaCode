package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Stage stage = new Stage();
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setTitle("Stage Title");
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.setFill(Color.DODGERBLUE);
			stage.setScene(scene);
			stage.show();
			
			// Chieu cao chieu rong toi da
			stage.setMaxHeight(1000);
			stage.setMinHeight(200);
			stage.setMaxWidth(600);
			stage.setMinWidth(200);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
