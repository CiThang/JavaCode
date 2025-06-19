package application;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class as extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo TableView
        TableView<String> tableView = new TableView<>();

        // Tạo cột tên
        TableColumn<String, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

        // Tạo cột tùy chỉnh để chứa Button
        TableColumn<String, String> buttonColumn = new TableColumn<>("Action");
        buttonColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue())); // Cần một giá trị cho mỗi ô, ở đây là tên

        // Đặt cột tùy chỉnh để hiển thị Button
        buttonColumn.setCellFactory(column -> new TableCell<String, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    Button button = new Button("Click Me");
                    setGraphic(button);
                    button.setOnAction(event -> {
                        // Xử lý sự kiện khi nút được nhấn
                        System.out.println("Button clicked for item: " + item);
                    });
                }
            }
        });

        // Thêm cột vào TableView
        tableView.getColumns().addAll(nameColumn, buttonColumn);

        // Thêm dữ liệu vào TableView
        tableView.getItems().addAll("Item 1", "Item 2", "Item 3");

        // Tạo và hiển thị Scene
        Scene scene = new Scene(new VBox(tableView), 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView Button Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
