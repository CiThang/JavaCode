package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;

public class MainSceneController {
	@FXML
	private TextField ttTile;

	// Event Listener on Button.onAction
	@FXML
	public void buttonOKclicked(ActionEvent event) {
		// TODO Autogenerated
		Stage mainWindown = (Stage) ttTile.getScene().getWindow();
		String title = ttTile.getText();
		mainWindown.setTitle(title);
	}
}
