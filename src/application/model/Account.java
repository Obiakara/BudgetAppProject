package application.model;

public class Account {
	private String bankName;
	private String accHolderName;
	private String accType;
	private String accNumber;
	private String routingNumber;
	
	
	public Account(String bankName, String accHolderName, String accType, String accNumber, String routingNumber) {
		this.bankName = bankName;
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.accNumber = accNumber;
		this.routingNumber = routingNumber;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getAccHolderName() {
		return accHolderName;
	}


	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}


	public String getAccType() {
		return accType;
	}


	public void setAccType(String accType) {
		this.accType = accType;
	}


	public String getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}


	public String getRoutingNumber() {
		return routingNumber;
	}


	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	
	

}
