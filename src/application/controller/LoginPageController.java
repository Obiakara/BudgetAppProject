package application.controller;

import java.io.IOException;
import java.util.Optional;

import application.model.BudgetShop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {
	
	@FXML private Label usernameLabel;
	@FXML private Label passwordLabel;
	
	@FXML private CheckBox rememberMeCheck;
	
	@FXML private TextField usernameTxtField;
	@FXML private PasswordField passwordTxtField;
	
	@FXML private Button backToHomeButton;
	@FXML private Button loginButton;
	
	
	@FXML
	public void onClickBackToHomeButton( ActionEvent event ) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/welcomePage.fxml") );
		
		Parent root = (Parent) loader.load();
		Scene scene2View = new Scene(root);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene2View);
		window.show();
		System.out.println("HOme");
		
	}
	
	@FXML
		public void onClickLoginButton( ActionEvent event ) throws IOException {
		
		BudgetShop budgetShop = new BudgetShop();
		String userName = usernameTxtField.getText();
		String password = passwordTxtField.getText();
		
		if (budgetShop.validateUserID(userName, password) == true){
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/HomePage.fxml") );
			
			Parent root = (Parent) loader.load();
			
			//WandShopController wandShopController = loader.<WandShopController>getController();
			Scene scene2View = new Scene(root);
			//wandShopController.loadData(wandShop);

			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(scene2View);
			window.show();
			System.out.println("login");
			
			
		}
/**
 * The following block of code alerts the user that he/she doesnt belong in the dataBase and gives them an option to
 * create a new user Account
 */
			else {
				Alert alert = new Alert(AlertType.CONFIRMATION);
			      alert.setTitle("Create Account");
			      alert.setHeaderText("Invalid username and password combination");
			      alert.setContentText("Would you like to create an account with the username and password entered?");

			      Optional<ButtonType> option = alert.showAndWait();
			 
			      if (option.get() == ButtonType.OK) {
			    	  
			    	  FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CreateUser.fxml") );
						
						Parent root = (Parent) loader.load();
						Scene scene2View = new Scene(root);
						
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
						
						window.setScene(scene2View);
						window.show();
			      } else if (option.get() == ButtonType.CANCEL) {
			    	  alert.close();

			      }
			}
		
	}
	

}
