package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetShop {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}




	public boolean validateUserID( String username, String password ) throws FileNotFoundException {
		
		File file = new File( "C:\\Users\\obiak\\Documents\\fall 2018\\application Programming\\JavaFX "
				+ "Workspace\\app project\\src\\files\\userFile.csv" );
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			String [] token = line.split(",");
			String name = token[0];
			String pass = token[1];
			
			if(name.equals(username) && pass.equals(password)) {
				scan.close();
				return true;
			}
		
		}
		scan.close();
		
		return false;
	}
	
public void saveUser() {
		
		BufferedWriter writer;
		
		try {
			
		StringBuilder output = new StringBuilder();
		
		for( int i=0; i < this.getUsers().size(); i++) {
			
			if(this.getUsers().get(i).getAccount() == null) {
				
				output.append("\n");
				output.append(this.getUsers().get(i).getUsername());
				output.append(",");
				output.append(this.getUsers().get(i).getPassword());
				output.append(",");
				output.append(this.getUsers().get(i).getFirstName());
				output.append(",");
				output.append(this.getUsers().get(i).getLastName());
				output.append(",");
				output.append(this.getUsers().get(i).getEmail());
				output.append(",");
				output.append(this.getUsers().get(i).getSecurityQuestion());
				output.append(",");
				output.append(this.getUsers().get(i).getSecurityAnswer());
				
			}
			else {
				output.append("\n");
				output.append(this.getUsers().get(i).getUsername());
				output.append(",");
				output.append(this.getUsers().get(i).getPassword());
				output.append(",");
				output.append(this.getUsers().get(i).getFirstName());
				output.append(",");
				output.append(this.getUsers().get(i).getLastName());
				output.append(",");
				output.append(this.getUsers().get(i).getEmail());
				output.append(",");
				output.append(this.getUsers().get(i).getSecurityQuestion());
				output.append(",");
				output.append(this.getUsers().get(i).getSecurityAnswer());
				output.append(",");
				output.append(this.getUsers().get(i).getAccount().getAccHolderName());
				output.append(",");
				output.append(this.getUsers().get(i).getAccount().getAccNumber());
				output.append(",");
				output.append(this.getUsers().get(i).getAccount().getAccType());
				output.append(",");
				output.append(this.getUsers().get(i).getAccount().getBankName());
				output.append(",");
				output.append(this.getUsers().get(i).getAccount().getRoutingNumber());
			}
		}
		writer = new BufferedWriter( new FileWriter("C:\\Users\\obiak\\Documents\\fall 2018\\application"
				+ " Programming\\JavaFX Workspace\\app project\\src\\files\\userFile.csv", true)); 
        writer.write(output.toString()); 
        writer.close();
        
		}catch(IOException io) {
			System.out.println(io.getMessage());
		}
	}
	
}
