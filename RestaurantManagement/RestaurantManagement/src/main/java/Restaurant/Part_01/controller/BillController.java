package Restaurant.Part_01.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import Restaurant.Part_01.model.Customer;
import Restaurant.Part_01.model.ProductOrder;
import Restaurant.Part_01.model.Receipt;
import Restaurant.Part_01.service.CustomerService;
import Restaurant.Part_01.service.ProductOrderService;
import Restaurant.Part_01.service.ReceiptService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller
@Configuration
@ComponentScan("Restaurant.Part_01.service")
@Scope("prototype")
public class BillController implements Initializable {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private ProductOrderService productOrderService;

	@FXML
	private TableView<Customer> bill_table;

	@FXML
	private TableColumn<Customer, Double> bill_price;

	@FXML
	private TableColumn<Customer, String> bill_proName;

	@FXML
	private TableColumn<Customer, String> bill_prodID;

	@FXML
	private TableColumn<Customer, Integer> bill_quantity;

	@FXML
	private Label bill_text_cashier;

	@FXML
	private Label bill_text_cusName;

	@FXML
	private Label bill_text_date;

	@FXML
	private TableColumn<ProductOrder, Double> bill_web_price;

	@FXML
	private TableColumn<ProductOrder, String> bill_web_proName;

	@FXML
	private TableColumn<ProductOrder, String> bill_web_prodID;

	@FXML
	private TableColumn<ProductOrder, Integer> bill_web_quantity;

	@FXML
	private TableView<ProductOrder> bill_table_web;

	public void setDataApp(Integer CustomerID) {
		bill_table.setVisible(true);
		bill_table_web.setVisible(false);
		ObservableList<Customer> list = FXCollections.observableArrayList();
		for (Customer customer : customerService.getCustomersByCustomerId(CustomerID)) {
			list.add(customer);
		}

		bill_prodID.setCellValueFactory(new PropertyValueFactory<>("product_ID"));
		bill_proName.setCellValueFactory(new PropertyValueFactory<>("product_Name"));
		bill_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		bill_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		bill_table.setItems(list);

		Receipt receipt = receiptService.getReceiptByCustomerId(CustomerID);
		bill_text_cashier.setText(receipt.getEm_username());
		bill_text_cusName.setText("ID-" + receipt.getCustomerID());
		bill_text_date.setText(receipt.getDate() + "");
	}
//
//	public void setDataWeb(String CustomerName, Date date) {
//		bill_table.setVisible(false);
//		bill_table_web.setVisible(true);
//		System.out.println(date);
//		System.out.println(CustomerName);
//		ObservableList<ProductOrder> list = FXCollections.observableArrayList();
//		for (ProductOrder productOrder : productOrderService.getProductOrdersByCustomerName(CustomerName, date)) {
//			list.add(productOrder);
//		}
//		
//		bill_web_prodID.setCellValueFactory(new PropertyValueFactory<>("product_ID"));
//		bill_web_proName.setCellValueFactory(new PropertyValueFactory<>("product_Name"));
//		bill_web_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//		bill_web_price.setCellValueFactory(new PropertyValueFactory<>("price"));
//		bill_table_web.setItems(list);
//
//		bill_text_cashier.setText(" in Web");
//		bill_text_cusName.setText(CustomerName);
//		bill_text_date.setText(date + "");
//
//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
