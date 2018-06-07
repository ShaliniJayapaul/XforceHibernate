package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.dto.userInfo;

public interface userInfoDao {
	
	boolean CreateProfile(userInfo user);
	boolean DeleteUser(String userId, String password);
	userInfo SearchStudentById(String userId);
	//userInfo login(int id,String password);
	//boolean updatePassword(int user,String oldpass,String newpass,String confpass);
	boolean UpdatePassword();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public static userInfo login(int id,String password){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from xforce.user_info where userId=? and password=?";
		userInfo user=new userInfo();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/xforce?user=root&password=hemu");
		pstmt=con.prepareStatement(qry);
		pstmt.setInt(1, id);
		
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
			int userid=rs.getInt("userId");
			user.setId(userid);
			
			String fname=rs.getString("firstName");
			user.setFirstName(fname);
			String lname=rs.getString("lastName");
			user.setLastName(lname);
			String email=rs.getString("email");
			user.setEmail(email);
			String Password=rs.getString("password");
			user.setPassword(Password);
			
		
		
		
		return user;
		}
		else
			return null;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
		}*/

}
