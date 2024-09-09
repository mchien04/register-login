package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBConnectMySQL;
import vn.iostar.dao.IUserDAO;
import vn.iostar.models.UserModel;

public class UserDaoImpl<ps> extends DBConnectMySQL implements IUserDAO	{

	private static IUserDAO userDao;
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String sql="select * from users";
		
		List<UserModel> list = new ArrayList<>(); //Tạo 1 List để truyền dữ liệu

		try {
			conn = super.getDatabaseConnection(); //kết nói database 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*Next từng DÒNG tới cuối bàng*/) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"), 
								rs.getString("password"), 
								rs.getString("email"), 
								rs.getString("fullname"),
								rs.getString("images")
								)
						); //Add vào
			}
		return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	
	@Override
	public UserModel findByID(int id) {
	    String sql = "SELECT * FROM users WHERE id = ?";
	    UserModel user = null;
	    
	    try {
	        conn = super.getDatabaseConnection(); 
	        ps = conn.prepareStatement(sql); 
	        
	        ps.setInt(1, id); 
	        
	        rs = ps.executeQuery(); 
	        
	        if (rs.next()) {
	            user = new UserModel(
	                rs.getInt("id"),
	                rs.getString("username"),
	                rs.getString("password"),
	                rs.getString("email"),
	                rs.getString("fullname"),
	                rs.getString("images")
	            );
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    
	    return user; 
	}

	
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id, username, email, password, images, fullname) VALUES (?,?, ?, ?, ?, ?)";
		try {
			
			conn = super.getDatabaseConnection(); //kết nối database
			
			ps= conn.prepareStatement(sql);//ném câu sql vào cho thực thi
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsernam());
			ps.setString(3, user.getEmail());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getImages());
			ps.setString(6, user.getFullname());
			ps.executeUpdate();
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public boolean register(int id, String username, String password, String email, String fullname, String images) {
		// TODO Auto-generated method stub
        UserModel existingUser = findByID(id);
        if (existingUser != null) {
            return false;
        }

        UserModel newUser = new UserModel(id, username, password, email, fullname, images);
        insert(newUser);
        return true;
	}


	@Override
	public UserModel login(int id, String password) {
		 String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
	        UserModel user = null;

	        try {
	            conn = super.getDatabaseConnection();
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.setString(2, password);

	            rs = ps.executeQuery();

	            if (rs.next()) {
	                user = new UserModel(
	                    rs.getInt("id"),
	                    rs.getString("username"),
	                    rs.getString("password"),
	                    rs.getString("email"),
	                    rs.getString("fullname"),
	                    rs.getString("images")
	                );
	            } else {
	                System.out.println("Tài khoản không tồn tại hoặc mật khẩu không chính xác.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return user;
	    }

	

	public static void main(String[] args){
	/*    UserDaoImpl<?> userDao = new UserDaoImpl<Object>();

	    UserModel user = userDao.findByID(4);

	    if (user != null) {
	        System.out.println("User found: " + user);
	    } else {
	        System.out.println("User not found.");
	    }
			*/
	
	/*	
		UserDaoImpl userDao = new UserDaoImpl();
        boolean registered = userDao.register(4, "newuser", "password123", "newuser@example.com", "New User", "newuser.jpg");
        if (registered) {
            System.out.println("Đăng ký thành công.");
        } else {
            System.out.println("Tài khoản đã tồn tại.");
        }
	*/	
        
		  UserDaoImpl<?> userDao = new UserDaoImpl<Object>();

	            UserModel user = userDao.login(1, "123");
	            if (user != null) {
	                System.out.println("Đăng nhập thành công: " + user);
	            } else {
	                System.out.println("Đăng nhập thất bại.");
	            }


	}
		
}

	
