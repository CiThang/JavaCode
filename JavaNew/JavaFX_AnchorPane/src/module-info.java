module JavaFX_AnchorPane {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
