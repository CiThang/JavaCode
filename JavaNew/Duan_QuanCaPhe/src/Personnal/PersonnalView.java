package Personnal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PersonnalView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonnalView.fxml"));
            
            Parent root = loader.load();
            
            Button btnThanhToan = (Button) root.lookup("#btnThanhToan");
            
            btnThanhToan.setOnAction(event -> System.out.println("click"));
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("PersonCSS.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
