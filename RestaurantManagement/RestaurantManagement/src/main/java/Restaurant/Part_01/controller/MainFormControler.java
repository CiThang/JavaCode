package Restaurant.Part_01.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import Restaurant.Part_01.loaderProvider.ApplicationContextProvider;
import Restaurant.Part_01.loaderProvider.FXMLLoaderProvider;
import Restaurant.Part_01.model.Customer;
import Restaurant.Part_01.model.CustomerAccount;
import Restaurant.Part_01.model.Product;
import Restaurant.Part_01.model.Receipt;
import Restaurant.Part_01.model.ReceiptOrder;
import Restaurant.Part_01.service.CustomerAccountService;
import Restaurant.Part_01.service.CustomerService;
import Restaurant.Part_01.service.ProductOrderService;
import Restaurant.Part_01.service.ProductService;
import Restaurant.Part_01.service.ReceiptOrderService;
import Restaurant.Part_01.service.ReceiptService;
import javafx.scene.chart.XYChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

@Controller
@Configuration
@ComponentScan("Restaurant.Part_01.service")
@Scope("prototype")
public class MainFormControler implements Initializable {

	@Autowired
	private ProductService productService;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private ReceiptOrderService receiptOrderService;

	@Autowired
	private CustomerAccountService customerAccountService;

	@Autowired
	private ProductOrderService productOrderService;

	@FXML
	private Button customers_btn;

	@FXML
	private Button dashboard_btn;

	@FXML
	private Button inventory_addBtn;

	@FXML
	private Button inventory_btn;

	@FXML
	private Button inventory_clearBtn;

	@FXML
	private AnchorPane dashboard_form;

	@FXML
	private TableView<Product> inventory_tableView;

	@FXML
	private TableColumn<Product, String> inventory_col_date;

	@FXML
	private TableColumn<Product, String> inventory_col_price;

	@FXML
	private TableColumn<Product, String> inventory_col_productID;

	@FXML
	private TableColumn<Product, String> inventory_col_productName;

	@FXML
	private TableColumn<Product, String> inventory_col_status;

	@FXML
	private TableColumn<Product, String> inventory_col_type;

	@FXML
	private TableColumn<Product, String> inventory_col_stock;

	@FXML
	private Button inventory_deleteBtn;

	@FXML
	private AnchorPane inventory_form;

	@FXML
	private ImageView inventory_imageView;

	@FXML
	private Button inventory_importBtn;

	@FXML
	private Button inventory_updateBtn;

	@FXML
	private Button logout_btn;

	@FXML
	private AnchorPane main_form;

	@FXML
	private Button menu_btn;

	@FXML
	private Label username;

	@FXML
	private TextField inventory_price;

	@FXML
	private TextField inventory_productID;

	@FXML
	private TextField inventory_productName;

	@FXML
	private ComboBox<String> inventory_status;

	@FXML
	private TextField inventory_stock;

	@FXML
	private ComboBox<String> inventory_type;

	@FXML
	private Button menu_cancel_btn;

	@FXML
	private TextField menu_ed_price_find;

	@FXML
	private Button menu_find_btn;

	@FXML
	private TextField menu_price_bg_find;

	@FXML
	private TextField menu_prodName_find;

	@FXML
	private GridPane menu_GridPane;

	@FXML
	private TextField menu_amount;

	@FXML
	private Label menu_change;

	@FXML
	public TableColumn<Product, String> menu_col_price;

	@FXML
	public TableColumn<Product, String> menu_col_productName;

	@FXML
	public TableColumn<Product, String> menu_col_quanlity;

	@FXML
	private AnchorPane menu_form;

	@FXML
	private Button menu_payBtn;

	@FXML
	private Button menu_receiptBtn;

	@FXML
	private Button menu_removeBtn;

	@FXML
	private ScrollPane menu_scrollPane;

	@FXML
	public TableView<Product> menu_tableView;

	@FXML
	private Label menu_total;

	@FXML
	private TableColumn<Receipt, String> customer_col_Cashier;

	@FXML
	private TableColumn<Receipt, String> customer_col_customerID;

	@FXML
	private TableColumn<Receipt, String> customer_col_date;

	@FXML
	private TableColumn<Receipt, String> customer_col_total;

	@FXML
	private AnchorPane customer_form;

	@FXML
	private TableView<Receipt> customer_tableView;

	@FXML
	private Label dashboard_NC;

	@FXML
	private Label dashboard_NSP;

	@FXML
	private Label dashboard_TI;

	@FXML
	private BarChart<?, ?> dashboard_customerChart;

	@FXML
	private AreaChart<?, ?> dashboard_incomeChart;

	@FXML
	private Label dashboard_totali;

	@FXML
	private Button menu_showBtn;

	@FXML
	private Button weborder_btn;

	@FXML
	private AnchorPane weborder_form;

	@FXML
	private Button wo_acCreate_btn;

	@FXML
	private Button wo_acDelete_btn;

	@FXML
	private Button wo_acUpdate_btn;

	@FXML
	private AnchorPane wo_account_form;

	@FXML
	private TableColumn<CustomerAccount, String> wo_col_accusName;

	@FXML
	private TableColumn<ReceiptOrder, Double> wo_col_amount;

	@FXML
	private TableColumn<CustomerAccount, String> wo_col_email;

	@FXML
	private TableColumn<CustomerAccount, String> wo_col_pass;

	@FXML
	private TableColumn<ReceiptOrder, String> wo_col_recusname;

	@FXML
	private TableColumn<ReceiptOrder, Double> wo_col_total;

	@FXML
	private TableColumn<ReceiptOrder, java.sql.Date> wo_col_date;

	@FXML
	private Button wo_cusAccount_btn;

	@FXML
	private AnchorPane wo_intro_form;

	@FXML
	private Button wo_receipt_btn;

	@FXML
	private AnchorPane wo_receipt_form;

	@FXML
	private TableView<CustomerAccount> wo_tableAccount;

	@FXML
	private TableView<ReceiptOrder> wo_tableReceipt;

	@FXML
	private TextField wo_text_cusname;

	@FXML
	private TextField wo_text_email;

	@FXML
	private TextField wo_text_pass;

	@FXML
	private Button wo_re_cancel_btn;

	@FXML
	private Button wo_re_find_btn;

	@FXML
	private TextField wo_text_date_find;

	@FXML
	private ComboBox<String> menu_type_find;

	private Alert alert;

	private Image image;

	private ObservableList<Product> cardListData = FXCollections.observableArrayList();

// DASHBOARD
	public void dashBoardDisplayNC() {
		Long nc = receiptService.getReceiptCount();
		dashboard_NC.setText(String.valueOf(nc));
	}

	public void dashboardDisplayTI() {

		Double ti1 = receiptService.getTotalSumByDate(new java.sql.Date(new Date().getTime()));
		Double ti2 = receiptOrderService.getTotalSumByDate(new java.sql.Date(new Date().getTime()));
		if (ti1 == null) {
			dashboard_TI.setText("$" + ti2);
		} else if (ti2 == null) {
			dashboard_TI.setText("$" + ti1);
		} else {
			dashboard_TI.setText("$ 0.0");
		}
	}

	public void dashboardTotalI() {

		Double ti1 = receiptService.getTotalSum();
		Double ti2 = receiptOrderService.getTotalSum();

		if (ti1 == null) {
			dashboard_totali.setText("$" + ti2);
		} else if (ti2 == null) {
			dashboard_totali.setText("$" + ti1);
		} else {
			dashboard_totali.setText("$" + (ti1 + ti2));
		}

	}

	public void dashboardNSP() {

		Integer q1 = customerService.getQuantityCount();
		Integer q2 = productOrderService.getQuantityCount();

		if (q1 == null) {
			dashboard_NSP.setText(String.valueOf(q2));
		} else if (q2 == null) {
			dashboard_NSP.setText(String.valueOf(q1));
		} else {
			dashboard_NSP.setText(String.valueOf((q1 + q2)));
		}
	}

	public void dashboardIncomeChart() {
		dashboard_incomeChart.getData().clear();
		XYChart.Series chart = new XYChart.Series<>();
		List<Object[]> list = receiptService.getTotalSumByDateGroupByDateOrderByDate();
		for (Object[] receipt : list) {
			String date = receipt[0].toString();
			Double total = (Double) receipt[1];
			chart.getData().add(new XYChart.Data<>(date, total));
		}
		dashboard_incomeChart.getData().add(chart);
	}

	public void dashboardCustomerChart() {
		dashboard_customerChart.getData().clear(); // Xóa dữ liệu cũ khỏi biểu đồ

		XYChart.Series chart = new XYChart.Series<>(); // Tạo một loạt dữ liệu mới cho biểu đồ

		List<Object[]> list = receiptService.getCountByIdGroupByDateOrderByDate(); // Lấy danh sách các đối tượng
																					// Receipt

		for (Object[] receipt : list) {
			String date = receipt[0].toString(); // Lấy ngày từ mảng đối tượng
			Long count = (Long) receipt[1]; // Lấy số lượng từ mảng đối tượng

			chart.getData().add(new XYChart.Data<>(date, count.intValue())); // Thêm dữ liệu vào loạt dữ liệu biểu đồ
		}

		dashboard_customerChart.getData().add(chart); // Thêm loạt dữ liệu biểu đồ vào biểu đồ
	}

// INVENTORY ==================================================================
	// ADD BTN ================
	public void inventoryAddBtn() {
		if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty()
				|| inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
				|| inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null
				|| data.path == null) {

			showAlert(AlertType.ERROR, "Error Message", "Please fill all blank fields");
			alert.showAndWait();
		} else {
			try {
				Boolean checkProdId = productService.isProductidExists(inventory_productID.getText());
				System.out.println(checkProdId);
				if (checkProdId) {
					showAlert(AlertType.ERROR, "Error Message", inventory_productID.getText() + " is already taken");
				} else {

					String prod_id = inventory_productID.getText();
					String prod_name = inventory_productName.getText();
					String type = (String) inventory_type.getSelectionModel().getSelectedItem();
					Integer stock = Integer.valueOf(inventory_stock.getText());
					Double price = Double.valueOf(inventory_price.getText());
					String status = inventory_status.getSelectionModel().getSelectedItem();

					String path = data.path;
					path = path.replace("\\", "\\");
					String image = path;

					java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

					Product prod = new Product(prod_id, prod_name, type, stock, price, status, image, sqlDate);
					productService.addProduct(prod);
					showAlert(AlertType.INFORMATION, "Error Message", "Successfully Added!");
					inventoryShowData();
					inventoryClearBtn();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// UPDATE BTN ================
	public void inventoryUpdateBtn() {
		if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty()
				|| inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
				|| inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null
				|| data.path == null || data.id == 0) {
			showAlert(AlertType.ERROR, "Error Message", "Please fill all blank fields");
		} else {
			String prod_id = inventory_productID.getText();
			String prod_name = inventory_productName.getText();
			String type = (String) inventory_type.getSelectionModel().getSelectedItem();
			Integer stock = Integer.valueOf(inventory_stock.getText());
			Double price = Double.valueOf(inventory_price.getText());
			String status = inventory_status.getSelectionModel().getSelectedItem();

			String path = data.path;
			path = path.replace("\\", "\\");
			String image = path;

			java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

			// Confirm update with user
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to UPDATE Product ID: " + inventory_productID.getText() + " ?");
			Optional<ButtonType> result = alert.showAndWait();

			// If user confirms, execute update
			if (result.isPresent() && result.get() == ButtonType.OK) {
				productService.updateProduct(prod_id, prod_name, type, stock, price, status, image, sqlDate);
				showAlert(AlertType.INFORMATION, "Success",
						"Product ID: " + inventory_productID.getText() + " successfully updated!");
				inventoryShowData();
				inventoryClearBtn();
			} else {
				// User cancelled update

				showAlert(AlertType.ERROR, "Error Message", "Update cancelled.");
			}
		}
	}

	// DELETE BTN ================
	public void inventoryDeleteBtn() {
		if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty()
				|| inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
				|| inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null
				|| data.path == null || data.id == 0) {
			showAlert(AlertType.ERROR, "Error Message", "Please fill all blank fields");
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to DELETE Product ID: " + inventory_productID.getText() + " ?");

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				try {
					productService.deleteProductByProductID(inventory_productID.getText());
					showAlert(AlertType.ERROR, "Error Message", "Sucessfully Deleted!");
					inventoryShowData();
					inventoryClearBtn();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				showAlert(AlertType.ERROR, "Error Message", "Cancelled");
			}
		}
	}

	// CLEAR BTN ================
	public void inventoryClearBtn() {

		inventory_productID.setText("");
		inventory_productName.setText("");
		inventory_type.getSelectionModel().clearSelection();
		inventory_stock.setText("");
		inventory_price.setText("");
		inventory_status.getSelectionModel().clearSelection();
		data.path = "";
		data.id = 0;
		inventory_imageView.setImage(null);

	}

	// IMPORT BTN ================
	public void inventoryImportBtn() {

		FileChooser openFile = new FileChooser();
		openFile.getExtensionFilters().add(new ExtensionFilter("Open Image File", "*png", "*jpg"));

		File file = openFile.showOpenDialog(main_form.getScene().getWindow());

		if (file != null) {
			data.path = file.getAbsolutePath();
			image = new Image(file.toURI().toString(), 116, 126, false, true);
			inventory_imageView.setImage(image);
		}
	}

	// lay du lieu Product ra bang ================
	public ObservableList<Product> inventoryDataList() {

		ObservableList<Product> listData = FXCollections.observableArrayList();

		for (Product product : productService.getAllProduct()) {
			if (product.getStock() == 0) {
				product.setStatus("Unavailable");
			}
			listData.add(product);
		}

		return listData;
	}

	// them du lieu vao bang ================
	private ObservableList<Product> inventoryListData;

	public void inventoryShowData() {
		inventoryListData = inventoryDataList();
		inventory_col_productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
		inventory_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		inventory_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
		inventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
		inventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		inventory_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
		inventory_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

		inventory_tableView.setItems(inventoryListData);
	}

	// Click vao hang thi set du lieu len cac o ================
	public void inentorySelectData() {
		Product prodData = inventory_tableView.getSelectionModel().getSelectedItem();
		int num = inventory_tableView.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1)
			return;

		inventory_productID.setText(prodData.getProductID());
		inventory_productName.setText(prodData.getProductName());
		inventory_stock.setText(String.valueOf(prodData.getStock()));
		inventory_price.setText(String.valueOf(prodData.getPrice()));
		inventory_type.setValue(String.valueOf(prodData.getType()));
		inventory_status.setValue(String.valueOf(prodData.getStatus()));

		data.path = prodData.getImage();

		String path = "File:" + prodData.getImage();
		data.date = String.valueOf(prodData.getDate());
		data.id = prodData.getId();

		inventory_imageView.setImage(new Image(path, 116, 126, false, true));

	}

	// them gia tri Combox ================
	private String[] typeList = { "Meals", "Drinks" };

	public void inventoryTypeList() {
		List<String> typeL = new ArrayList<String>();
		for (String data : typeList) {
			typeL.add(data);
		}
		ObservableList<String> listData = FXCollections.observableArrayList(typeL);
		inventory_type.setItems(listData);
	}

	public void inventoryTypeListFind() {
		List<String> typeL = new ArrayList<String>();
		for (String data : typeList) {
			typeL.add(data);
		}
		ObservableList<String> listData = FXCollections.observableArrayList(typeL);
		menu_type_find.setItems(listData);
	}

	private String[] statusList = { "Available", "Unavailable" };

	public void inventoryStatusList() {
		List<String> statusL = new ArrayList<String>();

		for (String data : statusList) {
			statusL.add(data);
		}
		ObservableList<String> listData = FXCollections.observableArrayList(statusL);
		inventory_status.setItems(listData);
	}

//Menu ================================================================================

	public ObservableList<Product> menuGetData() {

		ObservableList<Product> listData = FXCollections.observableArrayList();
		for (Product product : productService.getAllProduct()) {
			listData.add(product);
		}
		return listData;

	}

	public ObservableList<Product> menuGetOrder() {
		customerID();
		ObservableList<Product> listData = FXCollections.observableArrayList();
		Product prod;
		for (Customer cus : customerService.getCustomersByCustomerId(cID)) {
			prod = new Product(cus.getId(), cus.getProduct_ID(), cus.getProduct_Name(), cus.getType(), cus.getPrice(),
					cus.getImg(), cus.getDate(), cus.getQuantity());
			listData.add(prod);
		}
		return listData;
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

	private ObservableList<Product> menuOrderListData;

	public void menuShowOrderData() {
		menuOrderListData = menuGetOrder();

		menu_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		menu_col_quanlity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		menu_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

		menu_tableView.setItems(menuOrderListData);
	}

	private int getid;

	public void menuSelecOrder() {
		Product prod = menu_tableView.getSelectionModel().getSelectedItem();
		int num = menu_tableView.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1)
			return;

		getid = prod.getId();
	}

	private double totalP;

	public void menuGetTotal() {
		try {
			customerID();
			totalP = customerService.sumPriceByCustomerId(cID);
		} catch (Exception e) {

		}

	}

	public void menuDisplayTotal() {
		menuGetTotal();
		menu_total.setText("$" + totalP);
	}

	private double amount;
	private double change = 0;

	public void menuAmount() {
		menuGetTotal();
		if (menu_amount.getText().isEmpty() || totalP == 0) {
			showAlert(AlertType.ERROR, "Error Message", "Invalid :3");
		} else {
			amount = Double.parseDouble(menu_amount.getText());
			if (amount < totalP) {
				menu_amount.setText("");
			} else {
				change = (amount - totalP);
				menu_change.setText("$" + change);
			}
		}
	}

	public void menuShowBtn() {
		menuDisplayTotal();
		menuShowOrderData();
	}

	public void menuPayBtn() {
		if (totalP == 0) {
			showAlert(AlertType.ERROR, "Error Message", "Please choose your order first!");
		} else {
			menuGetTotal();
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Message");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure ?");
			Optional<ButtonType> option = alert.showAndWait();
			if (amount == 0) {
				showAlert(AlertType.ERROR, "Error Messaged", "Something wrong :3");
			} else {
				if (option.get().equals(ButtonType.OK)) {
					String change = menu_change.getText().substring(1);
					receiptService.addReceipt(new Receipt(cID, totalP, Double.valueOf(menu_amount.getText()),
							Double.valueOf(change), new java.sql.Date(new Date().getTime()), data.username));
					showAlert(AlertType.INFORMATION, "Infomation Message", "Successfull");
					menuShowOrderData();
					menuRestart();
				} else {
					showAlert(AlertType.WARNING, "Infomation Message", "Cancelled");
				}
			}

		}
	}

	public void menuReceiptBtn() {
		try {
			// Tạo tên file với ngày giờ hiện tại
			String filePath = "D:\\CafeShop_Java Project\\Receipt\\receipt_" + (cID - 1) + "_"
					+ new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt";
			File filereceipt = new File(filePath);

			// Tạo file mới
			if (filereceipt.createNewFile()) {
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(filereceipt))) {
					Receipt receipt = receiptService.getReceiptByCustomerId(cID - 1);

					List<Customer> listCus = customerService.getCustomersByCustomerId(cID - 1);
					System.out.println(cID);
					writer.write(receipt.getEm_username() + " - " + receipt.getDate() + "\n");
					writer.write("=========================\n");
					for (Customer customer : listCus) {
						writer.write(customer.getProduct_Name() + " - " + customer.getQuantity() + " - "
								+ customer.getPrice() + "\n");
						writer.write("-------------\n");
					}
					writer.write("=========================\n");
					writer.write("Total: " + receipt.getTotal() + "\n");
					writer.write("Amount: " + receipt.getAmount() + "\n");
					writer.write("Change: " + receipt.getChange() + "\n");
					showAlert(AlertType.INFORMATION, "Infomation Message", "Successful");
				} catch (IOException e) {
					showAlert(AlertType.ERROR, "Error Message", "Error during invoice issuance");
					e.printStackTrace();
					System.out.println("Loi");
				}
			} else {
				showAlert(AlertType.ERROR, "Error Message", "Invoice cannot be issued");
			}
		} catch (IOException e) {
			e.printStackTrace();
			showAlert(AlertType.ERROR, "Error Message", "Error during invoice issuance");
			System.out.println("loi");
		}
	}

	public void menuRemoveBtn() {
		if (getid == 0) {
			showAlert(AlertType.ERROR, "Error Message", "Please select the order you want to remove");
		} else {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Message");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to delete this order ?");
			Optional<ButtonType> optional = alert.showAndWait();

			if (optional.get().equals(ButtonType.OK)) {
				customerService.deleteCusomerByProdId(getid);
			}
			menuShowOrderData();
		}
	}

	public void menuRestart() {
		totalP = 0;
		change = 0;
		amount = 0;
		menu_total.setText("$0.0");
		menu_amount.setText("");
		menu_change.setText("$0.0");
	}

	// private ObservableList<Product> listProducts = menuGetData();

	public void menuDisplayCard() {
		cardListData.clear();
		cardListData.addAll(menuGetData());

		int row = 0;
		int column = 0;

		menu_GridPane.getChildren().clear();
		menu_GridPane.getRowConstraints().clear();
		menu_GridPane.getColumnConstraints().clear();

		for (int q = 0; q < cardListData.size(); q++) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setControllerFactory(applicationContext::getBean);
				loader.setLocation(getClass().getResource("/Fxml/CardProduct.fxml"));
				AnchorPane pane = loader.load();
				CardProductController cardC = loader.getController();
				cardC.setData(cardListData.get(q));

				if (column == 3) {
					column = 0;
					row += 1;
				}
				// Thêm pane vào grid
				menu_GridPane.add(pane, column++, row);
				GridPane.setMargin(pane, new Insets(10));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		menu_prodName_find.setText("");
		menu_ed_price_find.setText("");
		menu_price_bg_find.setText("");
		menu_type_find.setValue("");

	}

	// find in menu

	public ObservableList<Product> menuGetDataWithCondition() {
		ObservableList<Product> listData = FXCollections.observableArrayList();

		String productNameCondition = menu_prodName_find.getText();
		String productTypeCondition = (String) menu_type_find.getSelectionModel().getSelectedItem();
		String minPriceText = menu_price_bg_find.getText();
		String maxPriceText = menu_ed_price_find.getText();

		Double minPriceCondition = null;
		Double maxPriceCondition = null;

		if (minPriceText != null && !minPriceText.isEmpty()) {
			minPriceCondition = Double.parseDouble(minPriceText);
		}

		if (maxPriceText != null && !maxPriceText.isEmpty()) {
			maxPriceCondition = Double.parseDouble(maxPriceText);
		}

		for (Product product : productService.getAllProduct()) {
			boolean matches = true;

			if (productNameCondition != null && !productNameCondition.isEmpty()) {
				matches &= product.getProductName().equals(productNameCondition);
			}

			if (productTypeCondition != null && !productTypeCondition.isEmpty()) {
				matches &= product.getType().equals(productTypeCondition);
			}

			if (minPriceCondition != null) {
				matches &= product.getPrice() >= minPriceCondition;
			}

			if (maxPriceCondition != null) {
				matches &= product.getPrice() <= maxPriceCondition;
			}

			if (matches) {
				listData.add(product);
			}
		}

		return listData;
	}

	public void menuDisplayCardCondition() {
		cardListData.clear();
		cardListData.addAll(menuGetDataWithCondition());

		int row = 0;
		int column = 0;

		menu_GridPane.getChildren().clear();
		menu_GridPane.getRowConstraints().clear();
		menu_GridPane.getColumnConstraints().clear();

		for (int q = 0; q < cardListData.size(); q++) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setControllerFactory(applicationContext::getBean);
				loader.setLocation(getClass().getResource("/Fxml/CardProduct.fxml"));
				AnchorPane pane = loader.load();
				CardProductController cardC = loader.getController();
				cardC.setData(cardListData.get(q));

				if (column == 3) {
					column = 0;
					row += 1;
				}
				// Thêm pane vào grid
				menu_GridPane.add(pane, column++, row);
				GridPane.setMargin(pane, new Insets(10));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

// CUSTOMER =================================================================
	public ObservableList<Receipt> customersDataList() {
		ObservableList<Receipt> list = FXCollections.observableArrayList();
		receiptService.findAllReceipts();
		for (Receipt receipt : receiptService.findAllReceipts()) {
			list.add(receipt);
		}

		return list;

	}

	private ObservableList<Receipt> customerListData;

	public void customerShowData() {
		customerListData = customersDataList();
		customer_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		customer_col_total.setCellValueFactory(new PropertyValueFactory<>("total"));
		customer_col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
		customer_col_Cashier.setCellValueFactory(new PropertyValueFactory<>("em_username"));
		customer_tableView.setItems(customerListData);
	}
	
	public void CustomerSelectData() {
	    Receipt receipt = customer_tableView.getSelectionModel().getSelectedItem();
	    if (receipt == null) {
	        return; // Không có hàng nào được chọn
	    }
	    Integer customerId = receipt.getCustomerID();
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Bill.fxml"));
	        Parent root = loader.load();
	        BillController billController = loader.getController();
	        
	        // Đảm bảo Spring injects bean vào controller
	        applicationContext.getAutowireCapableBeanFactory().autowireBean(billController);
	        
	        billController.setDataApp(customerId);

	        Stage stage = new Stage();
	        Scene scene = new Scene(root);
	        stage.setTitle("BILL");
	        stage.setMinWidth(328);
	        stage.setMinHeight(461);
	        stage.setScene(scene);
	        stage.show();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

// WEB ORDER 
	public void switchOrderForm(ActionEvent event) {
		if (event.getSource() == wo_receipt_btn) {
			wo_receipt_form.setVisible(true);
			wo_account_form.setVisible(false);

			OrderReceiptShowData();
		} else if (event.getSource() == wo_cusAccount_btn) {
			wo_receipt_form.setVisible(false);
			wo_account_form.setVisible(true);

			CustomerAcountShowData();
		}
	}

	
	
	
	// LAY DU LIEU ReceiptOrder
	// lay du lieu ReceiptOrder ra bang ================
	public ObservableList<ReceiptOrder> OrderReceiptList() {
		ObservableList<ReceiptOrder> listData = FXCollections.observableArrayList();
		for (ReceiptOrder receiptOrder : receiptOrderService.listReceiptOrders()) {
			listData.add(receiptOrder);
		}
		return listData;
	}

	// them du lieu vao bang ================
	private ObservableList<ReceiptOrder> OrderReceiptListData;

	public void OrderReceiptShowData() {
		OrderReceiptListData = OrderReceiptList();

		wo_col_recusname.setCellValueFactory(new PropertyValueFactory<>("customerName"));
		wo_col_total.setCellValueFactory(new PropertyValueFactory<>("total"));
		wo_col_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		wo_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		wo_tableReceipt.setItems(OrderReceiptListData);
	}

	public void handleFindButtonAction() {
		// Lấy ngày cần tìm kiếm từ TextField
		String dateString = wo_text_date_find.getText();

		// Kiểm tra xem ngày nhập vào có hợp lệ không
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Tạo danh sách mới để lưu trữ các bản ghi phù hợp
		ObservableList<ReceiptOrder> filteredList = FXCollections.observableArrayList();

		// Lọc các bản ghi có ngày trùng khớp với ngày tìm kiếm
		for (ReceiptOrder order : OrderReceiptListData) {
			if (dateFormat.format(order.getDate()).equals(dateString)) {
				filteredList.add(order);
			}
		}

		// Cập nhật TableView với danh sách đã lọc
		wo_tableReceipt.setItems(filteredList);
	}
	
//	
//	public void ReceiptOrderSelectData() {
//	    ReceiptOrder receiptOrder = wo_tableReceipt.getSelectionModel().getSelectedItem();
//	    if (receiptOrder == null) {
//	        return; // Không có hàng nào được chọn
//	    }
//	    String customerName = receiptOrder.getCustomerName();
//	    java.sql.Date date = receiptOrder.getDate();
//	    
//	    try {
//	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Bill.fxml"));
//	        Parent root = loader.load();
//	        BillController billController = loader.getController();
//	        
//	        // Đảm bảo Spring injects bean vào controller
//	        applicationContext.getAutowireCapableBeanFactory().autowireBean(billController);
//	        
//	        billController.setDataWeb(customerName, date);
//
//	        Stage stage = new Stage();
//	        Scene scene = new Scene(root);
//	        stage.setTitle("BILL");
//	        stage.setMinWidth(328);
//	        stage.setMinHeight(461);
//	        stage.setScene(scene);
//	        stage.show();
//
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}


	// LAY DU LIEU CustomerAcount
	// lay du lieu ReceiptOrder ra bang ================
	public ObservableList<CustomerAccount> CustomerAcoutntList() {
		ObservableList<CustomerAccount> listData = FXCollections.observableArrayList();
		for (CustomerAccount customerAccount : customerAccountService.listCustomerAccounts()) {

			listData.add(customerAccount);
		}

		return listData;
	}

	// them du lieu vao bang ================
	private ObservableList<CustomerAccount> CustomerAcountListData;

	public void CustomerAcountShowData() {
		CustomerAcountListData = CustomerAcoutntList();

		wo_col_accusName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
		wo_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		wo_col_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
		wo_tableAccount.setItems(CustomerAcountListData);
	}

	// Click vao hang thi set du lieu len cac o ================
	public void OrderCustomerAcountSelectData() {
		CustomerAccount customerAccount = wo_tableAccount.getSelectionModel().getSelectedItem();
		int num = wo_tableAccount.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1)
			return;
		wo_text_cusname.setText(customerAccount.getCusName());
		wo_text_email.setText(customerAccount.getEmail());
		wo_text_pass.setText(customerAccount.getPassword());

	}

	public void createCustomerAccount() {
		try {
			String cusname = wo_text_cusname.getText();
			String email = wo_text_email.getText();
			String pass = wo_text_pass.getText();

			
			if (customerAccountService.cusNameExists(cusname)) {
				showAlert(AlertType.ERROR, "Error Message", cusname + " is already taken");
			} else if (pass.length() < 8) {
				showAlert(AlertType.ERROR, "Error Message", "Invalid Password, atleast 8 characters are needed");
			} else if (customerAccountService.emailExists(email)) {
				showAlert(AlertType.ERROR, "Error Message", email + " is already taken");
			} else if(!isValidEmail(email)){
				showAlert(AlertType.ERROR, "Error Message", "Invalid email");
			} else {
				KeyGenerator keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(256); // AES key size is 256 bits
				SecretKey secretKey = keyGen.generateKey();
				String sercuriryPass = encryptPassword(pass, secretKey);
				CustomerAccount customerAccount = new CustomerAccount(null, cusname, email, sercuriryPass,secretKey);
				if (customerAccount != null) {					
					customerAccountService.createCustomerAccount(customerAccount);
					showAlert(Alert.AlertType.INFORMATION, "User Account Created",
							"The user account was created successfully.");
					CustomerAcountShowData();
					this.customerAccountClearBtn();
				}
			}
			
		} catch (Exception e) {
			showAlert(Alert.AlertType.ERROR, "Creation Failed", "There was an error creating the customer account.");
		}
	}

	// Phương thức kiểm tra tính hợp lệ của địa chỉ email bằng biểu thức chính quy
		private boolean isValidEmail(String email) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			return email.matches(emailRegex);
		}

		
	    // Encrypt password
	    public static String encryptPassword(String password, SecretKey secretKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
	        return Base64.getEncoder().encodeToString(encryptedBytes);
	    }
	
	
	// DELETE BTN ================
	public void CustomerAcountDeleteBtn() {
		if (wo_text_cusname.getText().equals("")) {
			showAlert(AlertType.ERROR, "Error Message", "Please fill all blank fields");
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to DELETE Customer Name: " + wo_text_cusname.getText() + " ?");

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				try {
					customerAccountService.deleteCustomerAccountByCusName(wo_text_cusname.getText());
					showAlert(AlertType.ERROR, "Error Message", "Sucessfully Deleted!");
					CustomerAcountShowData();
					customerAccountClearBtn();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				showAlert(AlertType.ERROR, "Error Message", "Cancelled");
			}
		}
	}
	// UPDATE BTN ================
	public void CustomerAccountUpdateBtn() {
		if (wo_text_cusname.getText().equals("")) {
			showAlert(AlertType.ERROR, "Error Message", "Please fill all blank fields");
		} else {
			String cusname = wo_text_cusname.getText();
			String email = wo_text_email.getText();
			String pass = wo_text_pass.getText();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to UPDATE CustomerName: " + wo_text_cusname.getText() + " ?");
			Optional<ButtonType> result = alert.showAndWait();

			// If user confirms, execute update
			if (result.isPresent() && result.get() == ButtonType.OK) {
			try {
				KeyGenerator keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(256); // AES key size is 256 bits
				SecretKey secretKey = keyGen.generateKey();
				String sercuriryPass = encryptPassword(pass, secretKey);
				customerAccountService.updateCustomerAccount(cusname, email, sercuriryPass, secretKey);
				showAlert(AlertType.INFORMATION, "Success",
						"CustomerName: " + wo_text_cusname.getText() + " successfully updated!");
				this.customerAccountClearBtn();
				CustomerAcountShowData();
			} catch (Exception e) {
				e.printStackTrace();
			}

			} else {
				// User cancelled update

				showAlert(AlertType.ERROR, "Error Message", "Update cancelled.");
			}
		}
	}

	// CLEAR BTN ================
	public void customerAccountClearBtn() {

		wo_text_cusname.setText("");
		wo_text_email.setText("");
		wo_text_pass.setText("");

	}

// switchForm  ===============================
	public void switchForm(ActionEvent event) {
		if (event.getSource() == dashboard_btn) {
			dashboard_form.setVisible(true);
			inventory_form.setVisible(false);
			menu_form.setVisible(false);
			customer_form.setVisible(false);
			weborder_form.setVisible(false);

			dashBoardDisplayNC();
			dashboardDisplayTI();
			dashboardNSP();
			dashboardTotalI();

		} else if (event.getSource() == inventory_btn) {
			dashboard_form.setVisible(false);
			inventory_form.setVisible(true);
			menu_form.setVisible(false);
			customer_form.setVisible(false);
			weborder_form.setVisible(false);

			inventoryTypeList();
			inventoryStatusList();
			inventoryShowData();
		} else if (event.getSource() == menu_btn) {
			dashboard_form.setVisible(false);
			inventory_form.setVisible(false);
			menu_form.setVisible(true);
			customer_form.setVisible(false);
			weborder_form.setVisible(false);

			menuDisplayCard();
			inventoryTypeListFind();
			menuDisplayTotal();
			menuShowOrderData();
		} else if (event.getSource() == customers_btn) {
			dashboard_form.setVisible(false);
			inventory_form.setVisible(false);
			menu_form.setVisible(false);
			customer_form.setVisible(true);
			weborder_form.setVisible(false);

			customerShowData();
		} else if (event.getSource() == weborder_btn) {
			dashboard_form.setVisible(false);
			inventory_form.setVisible(false);
			menu_form.setVisible(false);
			customer_form.setVisible(false);
			weborder_form.setVisible(true);

//			wo_receipt_form.setVisible(true);

			OrderReceiptShowData();
		}
	}

	// LOGOUT BTN ================
	public void logout() {
		try {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to logout?");
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {

				logout_btn.getScene().getWindow().hide();

				FXMLLoader loader = ApplicationContextProvider.getContext().getBean(FXMLLoaderProvider.class)
						.getLoader("/Fxml/Login.fxml");
				Parent root = loader.load();

				Stage loginStage = new Stage();
				Scene scene = new Scene(root);
				
				loginStage.setTitle("Restaurant Management System");
				loginStage.getIcons().add(new Image("/icon/restaurant.png"));
				loginStage.setMinWidth(600);
				loginStage.setMinHeight(400);
				loginStage.setScene(scene);
				// Show MainForm
				loginStage.show();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SET USERNAM sau khi dang nhap thanh cong
	public void displayUsername() {
		String user = data.username;
		user = user.substring(0, 1).toUpperCase() + user.substring(1);
		username.setText(user);
	}

	// SHOW NOTIFICATION
	private void showAlert(Alert.AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		displayUsername();

		dashBoardDisplayNC();
		dashboardDisplayTI();
		dashboardNSP();
		dashboardTotalI();

		dashboardIncomeChart();
		dashboardCustomerChart();

		inventoryTypeList();
		inventoryStatusList();
		inventoryShowData();

		menuDisplayCard();
		menuGetOrder();
		menuDisplayTotal();
		menuShowOrderData();
		inventoryTypeListFind();
		customerShowData();
	}

}
