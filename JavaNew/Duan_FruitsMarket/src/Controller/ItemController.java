package Controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import model.Fruit;

public class ItemController {

	@FXML
	private Label nameLabel;

	@FXML
	private Label priceLabel;
	
	@FXML
	private ImageView img;
	
	
	   @FXML
	    void click(MouseEvent event) {
		   myListener.onClickListener(fruit);
	    }

	private Fruit fruit;
	private MyListener myListener;
	
	public void setData(Fruit fruit , MyListener myListener) {
		this.fruit=fruit;
		this.myListener = myListener;
		nameLabel.setText(fruit.getName());
		priceLabel.setText(Main.CURRENCY+fruit.getPrice());
		Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
		img.setImage(image);
	}

}
