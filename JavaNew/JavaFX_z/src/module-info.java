module JavaFX_z {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
