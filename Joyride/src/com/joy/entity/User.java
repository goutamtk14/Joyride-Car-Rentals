package com.joy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long mobile;
	private String email;
	private String password;
	private int dob;
	private long dlnumber;
	private int dlvalidity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public long getDlnumber() {
		return dlnumber;
	}
	public void setDlnumber(long dlnumber) {
		this.dlnumber = dlnumber;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public int getDlvalidity() {
		return dlvalidity;
	}
	public void setDlvalidity(int dlvalidity) {
		this.dlvalidity = dlvalidity;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}

}
