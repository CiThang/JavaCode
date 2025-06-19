package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("TextField Exploer");
			
			// 1. Create new TextFiled
			TextField textField = new TextField();
			
			// 2. Set Prompt Text
			textField.setPromptText("Enter some text");
			textField.setFocusTraversable(false);
			
			// 3. Set On Action
			textField.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("You entered some text!!!");
					
					// 4. Get Text from TextField
					System.out.println(textField.getText());
					
					// 5. Set Text on TextField
					textField.setText("I replaced your text!!!");
				}
			});
			
			
			HBox hBox = new HBox(textField);
			Scene scene = new Scene(hBox,400,400);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
