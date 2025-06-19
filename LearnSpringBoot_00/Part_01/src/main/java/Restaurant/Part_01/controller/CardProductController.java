package Restaurant.Part_01.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import Restaurant.Part_01.model.Product;
import Restaurant.Part_01.service.CustomerService;
import Restaurant.Part_01.service.ProductService;
import Restaurant.Part_01.service.ReceiptService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Controller
@Configuration
@ComponentScan("Restaurant.Part_01.service")
@Scope("prototype")
public class CardProductController implements Initializable {

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ReceiptService receiptService;

	 @Autowired
	private final MainFormControler mainFormControler;
	
	@Autowired
	public CardProductController(MainFormControler mainFormControler) {
		this.mainFormControler = mainFormControler;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public ReceiptService getReceiptService() {
		return receiptService;
	}

	public void setReceiptService(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	@FXML
	private Button prod_addBtn;

	@FXML
	private ImageView prod_imageView;

	@FXML
	private Label prod_name;

	@FXML
	private Label prod_price;

	@FXML
	private Spinner<Integer> prod_spinner;

//	private SpinnerValueFactory<Integer> spin;

	private Product prodData;
	private Image image;

	private String prodID;
	private String type;
	private String prod_image;
	private java.sql.Date prod_date;

	public void setData(Product prodData) {
		this.prodData = prodData;

		prod_image = prodData.getImage();
		prod_date = prodData.getDate();
		type = prodData.getType();
		prodID = prodData.getProductID();
		prod_name.setText(prodData.getProductName());
		prod_price.setText("$" + String.valueOf(prodData.getPrice()));
		String path = "File:" + prodData.getImage();
		image = new Image(path, 200, 90, false, true);
		prod_imageView.setImage(image);
		pr = prodData.getPrice();
	}

	private int cID;

	public void customerID() {
		try {
			cID = customerService.findMaxCusomerId();
			int checkID = receiptService.findMaxCustomerId();
			if (cID == 0) {
				cID += 1;
			} else if (cID == checkID) {
				cID += 1;
			}
			data.cID = cID;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int qty;

	public void setQuantity() {
		SpinnerValueFactory<Integer> spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
		prod_spinner.setValueFactory(spin);
	}

	private double totalP;
	private double pr;

	public void addBtn() {
		try {
			mainFormControler.customerID();
			System.out.println(prodID);
			qty = prod_spinner.getValue();

			Integer checkStock = productService.getStock(prodID);
			int upStock = checkStock - qty;
			if (checkStock == 0) {
				productService.updateProduct(prodID, prod_name.getText(), type, 0, pr, "Unavailable", prod_image,
						prod_date);
			}
			String checkAvailable = productService.getStatus(prodID);

			if (!checkAvailable.equals("Available") || qty == 0) {
				showAlert(AlertType.ERROR, "Error Message", "Product is Unavailable/ Quantity = 0 :3");
			} else {
				if (checkStock < qty) {
					showAlert(AlertType.ERROR, "Error Message", "Invalid. This product is Out of stock");
				} else {
					prod_image = prod_image.replace("\\", "\\");
					totalP = (qty * pr);
					java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

					customerService.createCustomer(data.cID, prodID, prod_name.getText(), type, qty, totalP, sqlDate,
							prod_image, data.username);

					productService.updateProduct(prodID, prod_name.getText(), type, upStock, pr, checkAvailable,
							prod_image, prod_date);

					showAlert(AlertType.INFORMATION, "Information Message", "Successfully Added!");
					
					
					mainFormControler.menuGetTotal();
//					mainFormControler.menuShowOrderData();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// SHOW NOTIFICATION
	private void showAlert(Alert.AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {

		setQuantity();
	}
}
