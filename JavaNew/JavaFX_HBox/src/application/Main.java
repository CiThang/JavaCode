package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;


public class Main extends Application {
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox hBox = new HBox();
			
			Button button1 = new Button("One");
//			button1.setPrefWidth(75);
			button1.setMaxWidth(Integer.MAX_VALUE);
//			button1.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
			hBox.setMargin(button1, new Insets(10)); // Giong margin trong CSS
			hBox.setHgrow(button1, Priority.SOMETIMES);
			
			Button button2 = new Button("Two");
//			button2.setPrefWidth(75);
			button2.setMaxWidth(Integer.MAX_VALUE);
			hBox.setMargin(button2, new Insets(10));
			hBox.setHgrow(button2, Priority.SOMETIMES);
			
			
			Button button3 = new Button("Three");
//			button3.setPrefWidth(75);
			button3.setMaxWidth(Integer.MAX_VALUE);
			hBox.setMargin(button3, new Insets(10));
			hBox.setHgrow(button3, Priority.SOMETIMES);
			
			Region region = new Region();
			
			hBox.setHgrow(region, Priority.ALWAYS);
			
			hBox.setAlignment(Pos.CENTER);
			hBox.getChildren().addAll(button1,region,button2,button3);
			
			Scene scene = new Scene(hBox,400,200);
			primaryStage.setScene(scene);
			primaryStage.show();
					
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
