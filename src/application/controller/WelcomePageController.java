package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomePageController {
	
	@FXML private Button signUpButton;
	@FXML private Button loginButton;
	
	
	@FXML
	public void onClickSignUpButton( ActionEvent event ) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CreateUser.fxml") );
		
		Parent root = (Parent) loader.load();
		Scene scene2View = new Scene(root);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene2View);
		window.show();
		
	}

	
	public void onClickLoginButton( ActionEvent event ) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/loginPage.fxml") );
		
		Parent root = (Parent) loader.load();
		//WandShopController wandShopController = loader.<WandShopController>getController();
		Scene scene2View = new Scene(root);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene2View);
		window.show();
		
	}
}
