module JavaFx_Button {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
