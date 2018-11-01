package application.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Account;
import application.model.BudgetShop;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class CreateUserController implements Initializable{
	
	@FXML Label usernameLabel;
	@FXML Label passwordLabel;
	@FXML Label emailLabel;
	@FXML Label lastNameLabel;
	@FXML Label firstNameLabel;
	@FXML Label securityQuestionLabel;
	@FXML Label securityAnswerLabel;
	@FXML Label reTypePasswordLabel;
	
	@FXML TextField firstNameTxtField;
	@FXML TextField lastNameTxtField;
	@FXML TextField usernameTxtField;
	@FXML TextField emailTxtField;
	@FXML TextField secureAnswerTxtField;
	@FXML PasswordField passwordTxtField;
	@FXML PasswordField confirmPasswordTxtField;
	
	@FXML ComboBox<String> secureQuestionComboBox;
	@FXML CheckBox tAndCsCheckBox;
	
	@FXML Button homeButton; 
	@FXML Button createAccountButton; 
	
	//private Bubb
	
	
	@FXML
	public void onClickTandCs( ActionEvent event ) {
		System.out.println("T and c clicked");
	}
	
	@FXML
	public void onClickHomeButton( ActionEvent event ) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/welcomePage.fxml") );
		
		Parent root = (Parent) loader.load();
		Scene scene2View = new Scene(root);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene2View);
		window.show();
	}
	
	@FXML
	public void onClickCreateAccount( ActionEvent event) throws IOException {
		
		BudgetShop budgetShop = new BudgetShop();
		ArrayList<User> users = new ArrayList<User>();
		
		String firstName = firstNameTxtField.getText();
		String lastName = lastNameTxtField.getText();
		String username = usernameTxtField.getText();
		String email = emailTxtField.getText();
		String secureAnswer = secureAnswerTxtField.getText();
		String password = passwordTxtField.getText();
		String confirmPassword = confirmPasswordTxtField.getText();
		String secureQuestion = secureQuestionComboBox.getValue();
		
		
		User user = new User(username, password, firstName, lastName, email, secureQuestion, secureAnswer, null);
		users.add(user);
		budgetShop.setUsers(users);
		budgetShop.saveUser();
		//check if the form fields have the right values before proceeding to the next screen
		if( validateFields() == true) { 
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/addBank.fxml") );
			
			Parent root = (Parent) loader.load();
			Scene scene2View = new Scene(root);

			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(scene2View);
			window.show();
		}
		else
			System.out.println("Error in fields");
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		secureQuestionComboBox.getItems().clear();
		secureQuestionComboBox.getItems().addAll( "Select a security Question", "In what city were you born?","What high school did you attend?",
				"What is the name of your first school?", "What is your mother's maiden name?", "What street did you grow up on?",
				"What is your father's middle name?", "What is the name of your first grade teacher?" );
		secureQuestionComboBox.setValue("Select a security Question");
		
		final Tooltip usernameToolTip = new Tooltip();
		usernameToolTip.setText("username must not be more than 8 characters and must contain alphabets only without spaces");
		usernameTxtField.setTooltip(usernameToolTip);
		
		final Tooltip passwordToolTip = new Tooltip();
		passwordToolTip.setText("password must be atleast 6 or more characters");
		passwordTxtField.setTooltip(passwordToolTip);
		
		final Tooltip confirmPasswordToolTip = new Tooltip();
		confirmPasswordToolTip.setText("password must match");
		confirmPasswordTxtField.setTooltip(passwordToolTip);	
	}
	
	public boolean validateFields() {
		
		 final String EMAIL_PATTERN = 
			    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

			 if(firstNameTxtField.getText() == null || firstNameTxtField.getText().trim().length() < 1) {
				 firstNameTxtField.setStyle("-fx-border-color: red");}
			 
				 else if(lastNameTxtField.getText() == null || firstNameTxtField.getText().trim().length() < 1) {
					 lastNameTxtField.setStyle("-fx-border-color: red"); 
				 }
				 
				 else if (usernameTxtField.getText().matches("\\d+") || usernameTxtField.getText().trim().length() < 8 
						|| usernameTxtField.getText() == null )//check for spaces too
					 {
					 usernameTxtField.setStyle(("-fx-border-color: red"));
					 }	
				
				 else if(passwordTxtField.getText().length() < 6 || passwordTxtField.getText() == null) {
					 passwordTxtField.setStyle(("-fx-border-color: red"));
					
				}
				
				 else if(secureQuestionComboBox.getValue().equals("Select a security Question")) {
					secureQuestionComboBox.setStyle(("-fx-border-color: red"));
				}
				
				 else if(secureAnswerTxtField.getText() == null) {
					secureAnswerTxtField.setStyle("-fx-border-color: red");
					
				}
					
				 else if(! (confirmPasswordTxtField.getText().equals(passwordTxtField.getText()) )){
					confirmPasswordTxtField.setStyle(("-fx-border-color: red"));
					
				}
				 else if( !emailTxtField.getText().matches(EMAIL_PATTERN) || emailTxtField.getText().trim().length() ==0 ) {
					emailTxtField.setStyle(("-fx-border-color: red"));
					
					}
				 else if(!tAndCsCheckBox.isSelected() ){
					tAndCsCheckBox.setStyle("-fx-border-color: red");
					
				 }
				 return false;
//			 }// end of first if
//			return true;
	}

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



