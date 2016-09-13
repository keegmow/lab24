package com.kmowers.lab24;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String fullname;
	
	public User (){};
//	public User (String username, String password, String email, String fullname) {
//		setUsername(username);
//		setPassword(password);
//		setEmail(email);
//		setFullname(fullname);
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
//		MessageDigest md = null;
//		try {
//			md = MessageDigest.getInstance("MD5");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		byte[] passByte = null;
//		try {
//			passByte = password.getBytes("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		byte [] passDigest = md.digest(passByte);
//		
//		this.password = passDigest.toString();
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
