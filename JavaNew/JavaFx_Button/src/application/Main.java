package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
//			// Tao button
//			Button button = new Button();
//			button.setText("Save");
//		
//			// Them anh vao button
//			Image image = new Image(getClass().getResourceAsStream("save.png"));
//			ImageView iview = new ImageView(image);
//			button.setGraphic(iview);
			
			// Viet gon code
			Image image = new Image(getClass().getResourceAsStream("save.png"));
			ImageView iview = new ImageView(image);
			Button button = new Button("Save",iview);
			
			// Sua Font chua
			button.setFont(new Font("Arial",24));
			
			
			//
			button.setRotate(90);
			
			// Them button vao root
			root.setCenter(button);
			
			button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("Click");
				}
			});
			
			
			
			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
