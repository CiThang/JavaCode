module JavaFx_Properties {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
