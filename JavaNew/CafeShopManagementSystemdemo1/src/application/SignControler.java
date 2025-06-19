package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SignControler implements Initializable {


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
    private Button side_createBtn;

    @FXML
    private Button side_alreadyHave;
    
    @FXML
    private AnchorPane side_form;

    @FXML
    private TextField su_answer;

    @FXML
    private PasswordField su_password;

    @FXML
    private ComboBox<?> su_question;
    
    @FXML
    private Button su_signupBtn;

    @FXML
    private AnchorPane su_sigupForm;

    @FXML
    private TextField su_userName;
    
    
    private Connection connect;
    private PreparedStatement prepared;
    private ResultSet result;
    
    private String[] questionList = {"What is your favorite color?","What is your favorite food?","What is your birth date?"};
	
    public void regLquestionList() {
    	List<String> listQ = new ArrayList<>();
    	
    	for(String data : questionList) {
    		listQ.add(data);
    	}
    	
    	ObservableList listData = FXCollections.observableArrayList(listQ);
    	System.out.println(listData);
    	su_question.setItems(listData);
    }
    public void switchForm(ActionEvent event) {
    	
    	TranslateTransition slider = new TranslateTransition();
    	
    	if(event.getSource()==side_createBtn) {
    		slider.setNode(side_form);
    		slider.setToX(300);
    		slider.setDuration(Duration.seconds(.5));
    		System.out.println("hi");
    		slider.setOnFinished((ActionEvent e)->{
    			side_alreadyHave.setVisible(true);
    			side_createBtn.setVisible(false);
    			
    			regLquestionList();
    		});
    		
    		slider.play();
    	} else if(event.getSource() == side_alreadyHave) {
    		slider.setNode(side_form);
    		slider.setToX(0);
    		slider.setDuration(Duration.seconds(.5));
    		
    		slider.setOnFinished((ActionEvent e)->{
    			side_alreadyHave.setVisible(false);
    			side_createBtn.setVisible(true);
    		});
    		
    		slider.play();
    	}
    	
    }
	
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
		
		
	}

}
