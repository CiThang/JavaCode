module JavaFx_tes {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
