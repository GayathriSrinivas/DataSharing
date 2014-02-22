package com.cmpe.datasharing;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable{

	private String fname;
	private String lname;
	private String address;
	private String details;
	
	/*Empty Constructor*/
	public Customer(){
		
	}
	
	/*Constructor*/
	public Customer(String fname,String lname,String address,String details){
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.details = details;
	}
	
	/*Getter*/
	
	public String getFname(){
		return fname;
	}
	
	public String getLname(){
		return lname;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getDetails(){
		return details;
	}

	public void setFname(String string) {
		this.fname = string;
	}

	public void setLname(String string) {
		this.lname = string;	
	}

	public void setAddress(String string) {
		this.address = string;
	}

	public void setDetails(String string) {
		this.details = string;
	}
}
