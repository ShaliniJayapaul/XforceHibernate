package com.dev.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class jdbcImpl implements userInfoDao{

	@Override
	public boolean CreateProfile(com.user.dto.userInfo user) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String dUrl="jdbc:mysql://localhost:3306?user=root&password=hemu";
		String qry="insert into xforce.user_info values(?,?,?,?,?)";
		Scanner sc=new Scanner(System.in);
	//	System.out.println("enter user id");
	//	int id=sc.nextInt();
		System.out.println("enter first name");
		String fn=sc.next();
		System.out.println("enter last name");
		String ln=sc.next();
		System.out.println("enter email");
		String email=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dUrl);
			pstmt=con.prepareStatement(qry);
			//pstmt.setInt(1,id);
			pstmt.setString(2,fn);
			pstmt.setString(3,ln);
			pstmt.setString(4,email);
			pstmt.setString(5,password);
			int s=pstmt.executeUpdate();
		if(s>0)
			System.out.println("profile created successfully");
		else
			System.out.println("profile creation failed");
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try{
					con.close();
					System.out.println("costly resources closed");
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		
	}
		return false;
	}


	@Override
	public boolean DeleteUser(String userId, String password) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String qry="delete from xforce.user_info where userId=? and password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user id");
		int id=sc.nextInt();
		System.out.println("enter the password");
		String pwd=sc.next();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=hemu");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, pwd);
		
				int x=pstmt.executeUpdate();
				
				if(x<2)
					System.out.println("profile deleted successfully");
				else
					System.out.println("profile deletion failed");
		
				
			
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try{
					con.close();
					System.out.println("costly resources closed");
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		
	

	}

		
		return false;
	}


	@Override
	public com.user.dto.userInfo SearchStudentById(String userId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from xforce.user_info where userId=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user id");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=hemu");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			com.dev.dao.userInfo user=new userInfo();
		if(rs.next()){
			String fn=rs.getString(2);
			String ln=rs.getString(3);
			String email=rs.getString(4);
			String password=rs.getString(5);
			
user.setFirstName(fn);
user.setLastName(ln);
user.setEmail(email);
user.setPassword(password);
		}
		return user;
			
		//	System.out.println(fn+" "+ln+" "+email);
	//	}else{
		//	System.out.println("invalid userid");
			
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try{
					con.close();
					System.out.println("costly resources closed");
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		
	}
		return null;

		
	}

	@Override
	public boolean UpdatePassword() {
		Connection con=null;
		PreparedStatement pstmt=null;

		String qry="update xforce.user_info set password=? where userId=? and password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user id");
		int id=sc.nextInt();
		System.out.println("enter old password");
		String oldpass=sc.next();
		
		System.out.println("enter new password");
		String newpass=sc.next();
		System.out.println("retype new password");
		String newpass1=sc.next();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=hemu");
			
			if(newpass.equals(newpass1))
			{
				pstmt=con.prepareStatement(qry);
				pstmt.setString(1, newpass);
				pstmt.setInt(2, id);
				pstmt.setString(3, oldpass);
				int passres=pstmt.executeUpdate();
				if(passres>0)
				{
					System.out.println("updated");
				}
				else
					throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try{
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try{
					con.close();
					System.out.println("costly resources closed");
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		
	}

	
		return false;
	}

	
}