package com.dev.factory;

import com.dev.dao.jdbcImpl;
import com.user.dao.userInfoDao;

public class UserInfoDAOFactory {
private final static String DATABASE = "jdbc";
private UserInfoDAOFactory(){}

private static final userInfoDao ref= getDAO();

private static userInfoDao getDAO(){
	jdbcImpl db=null;
	if(DATABASE.equals("jdbc")){
		db=new jdbcImpl();
	}else if(DATABASE.equals("HIBERNATE")){
		db=new jdbcImpl();
	}
	return db;
}
public static userInfoDao getDatabase(){
	return ref;
	}
}

