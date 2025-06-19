package Restaurant.Part_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Restaurant.Part_01.loaderProvider.ApplicationContextProvider;
import Restaurant.Part_01.loaderProvider.FXMLLoaderProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@SpringBootApplication
//@ComponentScan(basePackages = {"Restaurant.Part_01.controller", "Restaurant.Part_01.service"})
public class RestaurantManagementApplication extends Application {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagementApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = ApplicationContextProvider.getContext().getBean(FXMLLoaderProvider.class).getLoader("/Fxml/Login.fxml");
            Parent root = loader.load();
            primaryStage.setTitle("Login");
            primaryStage.getIcons().add(new Image("/icon/restaurant.png"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {
        // Khởi tạo ứng dụng
    }
}
