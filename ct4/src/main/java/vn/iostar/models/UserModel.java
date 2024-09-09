package vn.iostar.models;

import java.io.Serializable;

public class UserModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String usernam;
	private String email;
	private String password;
	private String fullname;
	private String images;
	public UserModel() {
		super();
	}
	public UserModel(int id, String usernam, String email, String password, String fullname, String images) {
		super();
		this.id = id;
		this.usernam = usernam;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsernam() {
		return usernam;
	}
	public void setUsernam(String usernam) {
		this.usernam = usernam;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", usernam=" + usernam + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", images=" + images + "]";
	}
	
	
	
	
}
