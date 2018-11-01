package application.controller;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBankController implements Initializable{
	
	@FXML private Label bankNameLabel;
	@FXML private Label accHoldNameLabel;
	@FXML private Label accTypeLabel;
	@FXML private Label accNumberLabel;
	@FXML private Label routNumbLabel;
	
	@FXML private TextField bankNameTxtField;
	@FXML private TextField accHoldNameTxtField;
	@FXML private TextField accNumberTxtField;
	@FXML private TextField routNumbTxtField;
	
	@FXML private ComboBox<String> accTypeComboBox;
	@FXML private Button skipButton;
	@FXML private Button addBankButton;
	
	
	@FXML
	public void onClickAddBank(ActionEvent event) {
		
		BudgetShop budgetShop = new BudgetShop();
		ArrayList<User> users = new ArrayList<User>();
		
		String bankName = bankNameTxtField.getText();
		String accHolderName = accHoldNameTxtField.getText();
		String accType = accTypeComboBox.getValue();
		String accNumber = accNumberTxtField.getText();
		String routingNumber = routNumbTxtField.getText();

		Account account = new Account(bankName, accHolderName, accType, accNumber, routingNumber);
//		User user = new User(username, password, firstName, lastName, email, secureQuestion, secureAnswer, null);
//		users.add(user);
//		budgetShop.setUsers(users);
//		budgetShop.saveUser();
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/addBank.fxml") );
//		
//		Parent root = (Parent) loader.load();
//		Scene scene2View = new Scene(root);
//
//		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//		
//		window.setScene(scene2View);
//		window.show();
//		
	}
	
	@FXML
	public void onClickSkipButton(ActionEvent event) throws IOException {
		BudgetShop budgetShop = new BudgetShop();
		budgetShop.saveUser();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/HomePage.fxml") );
		
		Parent root = (Parent) loader.load();
		Scene scene2View = new Scene(root);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene2View);
		window.show();
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		accTypeComboBox.getItems().clear();
		accTypeComboBox.getItems().addAll( "Checking Account", "Savings Account");
		accTypeComboBox.setValue("Select an account type");
		
	}

}
