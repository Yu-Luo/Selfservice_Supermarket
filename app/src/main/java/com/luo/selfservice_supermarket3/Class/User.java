package com.luo.selfservice_supermarket3.Class;

import java.io.Serializable;

public class User implements Serializable{
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String phoneNumber) {
		this.account = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public static String getPHONENUMBER() {
		return PHONENUMBER;
	}
	public static void setPHONENUMBER(String pHONENUMBER) {
		PHONENUMBER = pHONENUMBER;
	}
	public static String getPASSWORD() {
		return PASSWORD;
	}
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public static String getUSERNAME() {
		return USERNAME;
	}
	public static void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	private int id;
    private String account;
    private String password;
    private String userName;
    private String emailAddress;

    public static String PHONENUMBER = "account";
    public static String PASSWORD = "passWord";
    public static String USERNAME = "userName";

    public User(String phoneNumber,String password,String userName){
        this.account = phoneNumber;
        this.password = password;
        this.userName = userName;
    }
    
    
}