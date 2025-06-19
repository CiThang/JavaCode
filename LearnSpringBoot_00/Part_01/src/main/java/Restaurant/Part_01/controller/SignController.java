package Restaurant.Part_01.controller;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;

import Restaurant.Part_01.loaderProvider.ApplicationContextProvider;
import Restaurant.Part_01.loaderProvider.FXMLLoaderProvider;
import Restaurant.Part_01.model.Employee;
import Restaurant.Part_01.service.UserAccountService;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

//@Component
@Controller
@Configuration
@ComponentScan(basePackages = "Restaurant.Part_01.service")
public class SignController implements Initializable {

	@Autowired
	private UserAccountService userAccountService;

	@FXML
	private TextField fp_answer;

	@FXML
	private Button fp_back;

	@FXML
	private Button fp_proceedBtn;

	@FXML
	private ComboBox<String> fp_question;

	@FXML
	private TextField fp_username;

	@FXML
	private AnchorPane fp_questionForm;

	@FXML
	private Button np_back;

	@FXML
	private Button np_changePassBtn;

	@FXML
	private PasswordField np_comfirmPassword;

	@FXML
	private AnchorPane np_newPassForm;

	@FXML
	private PasswordField np_newPassword;

	@FXML
	private Hyperlink si_forgotPass;

	@FXML
	private Button si_loginBtn;

	@FXML
	private AnchorPane si_loginForm;

	@FXML
	private PasswordField si_password;

	@FXML
	private TextField si_username;

	@FXML
	private Button side_alreadyHave;

	@FXML
	private Button side_createBtn;

	@FXML
	private AnchorPane side_form;

	@FXML
	private TextField su_answer;

	@FXML
	private PasswordField su_password;

	@FXML
	private ComboBox<String> su_question;

	@FXML
	private Button su_signupBtn;

	@FXML
	private AnchorPane su_sigupForm;

	@FXML
	private TextField su_userName;

	private Alert alert;

	// LOGIN ACCOUNT
	public void loginBtn() {
		if (si_username.getText().isEmpty() || si_password.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Incorrect Username/Password");
			alert.showAndWait();

		} else {
			try {
				Boolean isAuthenticated = userAccountService.authenticate(si_username.getText(), si_password.getText());
//				Boolean checkpass =  BCrypt.checkpw(si_password.getText(), isAuthenticated.getPassword());
				if (isAuthenticated) {
					showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome!");

					// lay username
					data.username = si_username.getText();
					FXMLLoader loader = ApplicationContextProvider.getContext().getBean(FXMLLoaderProvider.class)
							.getLoader("/Fxml/MainForm.fxml");
					Parent root = loader.load();

					Stage stage = new Stage();
					Scene scene = new Scene(root);
					stage.setTitle("Restaurant Management System");
					stage.setMinWidth(1100);
					stage.setMinHeight(600);
					stage.setScene(scene);
					stage.show();
					si_loginBtn.getScene().getWindow().hide();
				} else {
					showAlert(Alert.AlertType.ERROR, "Error Message", "Incorrect Username/Password");
					si_password.setText("");
				}
			} catch (Exception e) {
				showAlert(Alert.AlertType.ERROR, "Login Failed", "An error occurred during login.");
				e.printStackTrace();
			}
		}
	}

// CREATE ACCOUNT
	public void regBtn() {
		if (su_userName.getText().isEmpty() || su_password.getText().isEmpty()
				|| su_question.getSelectionModel().getSelectedItem() == null || su_answer.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setContentText("Please fill all blank fields");
		} else {
			try {
				String username = su_userName.getText();
				String password = su_password.getText();
				String question = su_question.getSelectionModel().getSelectedItem();
				String answer = su_answer.getText();
				Date date = new Date();
				  String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
				
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				Employee newEmployee = new Employee(username, hashedPassword, question, answer,
						sqlDate);

				if (userAccountService.checkUserName(username)) {
					showAlert(AlertType.ERROR, "Error Message", username + " is already taken");
				} else if (password.length() < 8) {
					showAlert(AlertType.ERROR, "Error Message", "Invalid Password, atleast 8 characters are needed");
				} else {
					if (newEmployee!= null) {
						userAccountService.createUserAccount(newEmployee);
						showAlert(Alert.AlertType.INFORMATION, "User Account Created",
								"The user account was created successfully.");
						TranslateTransition slider = new TranslateTransition();

						slider.setNode(side_form);
						slider.setToX(0);
						slider.setDuration(Duration.seconds(.5));

						slider.setOnFinished((ActionEvent e) -> {
							side_alreadyHave.setVisible(false);
							side_createBtn.setVisible(true);
						});

						slider.play();
					} 
				}

			} catch (Exception e) {
				showAlert(Alert.AlertType.ERROR, "Creation Failed", "There was an error creating the user account.");
				e.printStackTrace();
			}
		}
	}

	private String[] questionList = { "What is your favorite color?", "What is your favorite food?",
			"What is your birth date?" };

	public void regLquestionList() {
		List<String> listQ = new ArrayList<>();
		for (String data : questionList) {
			listQ.add(data);
		}
		ObservableList<String> listData = FXCollections.observableArrayList(listQ);
		su_question.setItems(listData);
	}

	public void switchForgotPass() {
		fp_questionForm.setVisible(true);
		si_loginForm.setVisible(false);
		forgotPassQuestionList();
	}

	public void proceesdBtn() {
		if (fp_username.getText().isEmpty() || fp_question.getSelectionModel().getSelectedItem() == null
				|| fp_answer.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all blank fields");
			alert.showAndWait();
		} else {
			boolean checkuser = userAccountService.checkQuestionAndAnswer(fp_username.getText(),
					(String) fp_question.getSelectionModel().getSelectedItem(), fp_answer.getText());
			if (checkuser) {
				np_newPassForm.setVisible(true);
				fp_questionForm.setVisible(false);
			} else {
				showAlert(AlertType.ERROR, "Error Massage", "Incorrect Information");
			}
		}

	}

	public void changePassBtn() {
		if (np_newPassword.getText().isEmpty() || np_comfirmPassword.getText().isEmpty()) {

			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all blank fields");
			alert.showAndWait();

		} else {
			if (np_newPassword.getText().equals(np_comfirmPassword.getText())) {
				userAccountService.updatedata(fp_username.getText(), np_newPassword.getText(),
						new java.sql.Date(new Date().getTime()));

				showAlert(AlertType.INFORMATION, "Informmation Message", "Successfully changed Password!");

				si_loginForm.setVisible(true);
				np_newPassForm.setVisible(false);

				// Xoa form
				np_comfirmPassword.setText("");
				np_newPassword.setText("");
				fp_question.getSelectionModel().clearSelection();
				fp_answer.setText("");
				fp_username.setText("");
			}
		}
	}

	public void forgotPassQuestionList() {
		List<String> listQ = new ArrayList<String>();

		for (String data : questionList) {
			listQ.add(data);
		}
		ObservableList<String> listData = FXCollections.observableArrayList(listQ);
		fp_question.setItems(listData);
	}

	public void backToLoginForm() {
		si_loginForm.setVisible(true);
		fp_questionForm.setVisible(false);

		fp_answer.setText("");
		fp_question.getSelectionModel().clearSelection();
		fp_answer.setText("");
	}

	public void backToQuestionForm() {
		fp_questionForm.setVisible(true);
		np_newPassForm.setVisible(false);
		np_newPassword.setText("");
		np_comfirmPassword.setText("");
	}

	// CHANGE FORM REGISTER AND LOGNIN
	public void switchForm(ActionEvent event) {
		TranslateTransition slider = new TranslateTransition();
		if (event.getSource() == side_createBtn) {
			slider.setNode(side_form);
			slider.setToX(300);
			slider.setDuration(Duration.seconds(.5));
			slider.setOnFinished((ActionEvent e) -> {
				side_alreadyHave.setVisible(true);
				side_createBtn.setVisible(false);

				fp_questionForm.setVisible(false);
				si_loginForm.setVisible(true);
				np_newPassForm.setVisible(false);

				regLquestionList();
			});
			slider.play();
		} else if (event.getSource() == side_alreadyHave) {
			slider.setNode(side_form);
			slider.setToX(0);
			slider.setDuration(Duration.seconds(.5));
			slider.setOnFinished((ActionEvent e) -> {
				side_alreadyHave.setVisible(false);
				side_createBtn.setVisible(true);

				fp_questionForm.setVisible(false);
				si_loginForm.setVisible(true);
				np_newPassForm.setVisible(false);
			});
			slider.play();
		}
	}

// SHOW NOTIFICATION
	private void showAlert(Alert.AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public void initialize(URL url, ResourceBundle resource) {
		// Initialization code if needed
	}
}
