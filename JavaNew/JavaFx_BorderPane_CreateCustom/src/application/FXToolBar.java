package application;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class FXToolBar extends HBox {

	private ToolBar toolBar;
	private Button btnOpen;
	private Button btnSave;
	private Button btnExit;
	private ContentDisplay CONTENT_DISPLAY = ContentDisplay.GRAPHIC_ONLY;
	
	public FXToolBar() {
		buildUI();
	}
	
	public void buildUI() {
		btnOpen = createButton("Opent","open.png");
		btnOpen.setContentDisplay(CONTENT_DISPLAY);
		btnSave = createButton("Save", "save.png");
		btnSave.setContentDisplay(CONTENT_DISPLAY);
		btnExit = createButton("Exit", "exit.png");
		btnExit.setContentDisplay(CONTENT_DISPLAY);
		
		toolBar = new ToolBar(btnOpen, btnSave, btnExit);
		getChildren().add(this.toolBar);
		HBox.setHgrow(this.toolBar, Priority.ALWAYS);
		
	}
	
	public Button createButton(String text, String file) {
		  String path = "file:///D:/FileCode/img/";
		Image image = new Image(path+file);
		
		ImageView iView = new ImageView(image);
		iView.setFitHeight(32);
		iView.setFitWidth(32);
		Button button = new Button(text,iView);
		return button;
	}
}
