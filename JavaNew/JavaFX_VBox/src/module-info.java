module JavaFX_VBox {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
