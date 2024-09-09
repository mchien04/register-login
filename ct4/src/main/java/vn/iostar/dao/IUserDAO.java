package vn.iostar.dao;

import java.util.List;

import vn.iostar.models.UserModel;

public interface IUserDAO {
	
	List<UserModel> findAll();
	
	UserModel findByID(int id);
	
	void insert(UserModel user); 
	
    boolean register(int id, String username, String password, String email, String fullname, String images);
    
    UserModel login(int id, String password);
}
