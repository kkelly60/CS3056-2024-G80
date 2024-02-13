package model;

import java.util.Date;
//import java.text.SimpleDateFormat;

//import controller.AccountController;

public class Account {
	String account_number;
	String username_of_account_holder;
	String account_type; //"Standard" or "Saving"
	Date account_opening_data;
	
	public Account(String account_number, String username_of_account_holder, String account_type,
			Date account_opening_data) {
		super();
		this.account_number = account_number;
		this.username_of_account_holder = username_of_account_holder;
		this.account_type = account_type;
		this.account_opening_data = account_opening_data;
	}
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getUsername_of_account_holder() {
		return username_of_account_holder;
	}
	public void setUsername_of_account_holder(String username_of_account_holder) {
		this.username_of_account_holder = username_of_account_holder;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public Date getAccount_opening_data() {
		return account_opening_data;
	}
	public void setAccount_opening_data(Date account_opening_data) {
		this.account_opening_data = account_opening_data;
	}

}
