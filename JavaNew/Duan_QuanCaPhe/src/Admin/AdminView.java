package Admin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminView extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FruitsMarket.fxml"));
            
            Parent root = loader.load();
        
            Scene scene = new Scene(root);
            
            // Đảm bảo rằng tên file CSS được chỉ định đúng
//            scene.getStylesheets().add(getClass().getResource("AdminCSS.css").toExternalForm());
            
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
