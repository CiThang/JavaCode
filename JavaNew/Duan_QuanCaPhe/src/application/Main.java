package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Accordion accordion = new Accordion();
        VBox vBox = new VBox();
        Label lbl = new Label("sdfasdf");
        Label lbl2 = new Label("fkjsdhfh");
        vBox.getChildren().addAll(lbl,lbl2);

        // Tạo các TitledPane và đưa chúng vào Accordion
        TitledPane titledPane1 = new TitledPane("TitledPane 1",vBox);
        TitledPane titledPane2 = new TitledPane("TitledPane 2", new Label("Content of TitledPane 2"));
        TitledPane titledPane3 = new TitledPane("TitledPane 3", new Label("Content of TitledPane 3"));

        accordion.getPanes().addAll(titledPane1, titledPane2, titledPane3);

        VBox root = new VBox(10, accordion);
        
        // Thêm các Label phía sau Accordion
        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");
        root.getChildren().addAll(label1, label2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Accordion With Labels");
        primaryStage.show();

        // Sự kiện khi một TitledPane được mở hoặc đóng
        accordion.expandedPaneProperty().addListener((observable, oldPane, newPane) -> {
            // Kiểm tra xem có TitledPane mới được mở hay không
            if (newPane != null) {
                // Không cần điều chỉnh kích thước của VBox khi một TitledPane được mở
            } else {
                // Không cần điều chỉnh kích thước của VBox khi không có TitledPane nào được mở
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
