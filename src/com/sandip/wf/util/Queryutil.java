 package com.sandip.wf.util;

public class Queryutil {
public static final String SAVE_WORKER="insert into worker(worker_name,work_category,gender,phone,address,wages)values(?,?,?,?,?,?)";
public  static final String UPDATE_WORKER="update worker set worker_name=?,work_category=?, gender=?,phone=?,address=?,wages=? where id=?";
public  static final String LIST_WORKER="select * from worker";
public  static final String GET_WORKER_BY_ID="select * from worker where id=?";
public  static final String GET_WORKER_BY_WORKCATEGORY="select * from worker where work_category=?";
public  static final String GET_WORKER_BY_ADDRESS="select * from worker where address=?";
public  static final String DELETE_WORKER="delete from worker where id=?";
public static final String BY_CATEGORY_ADDRESS="select * from worker where work_category=? AND address=?";

public static final String CREATE_USER = "INSERT INTO userinfo (first_name,last_name, email, dob, username, password) VALUES (?,?,?,?,?,?)";
public static final String GET_ALL_USER = "SELECT * from userinfo";
public static final String DELETE_USER = "DELETE from userinfo where user_id=?";
public static final String UPDATE_USER = "UPDATE userinfo SET first_name=?,last_name=?,email=?, dob=?, password=? where user_id=?";
public static final String GET_USER_BY_ID = "select * from userinfo where user_id=?";
public static final String GET_USER_BY_USERNAME_AND_PASSWORD = "select user_id,username, password from users where username=? and password=?";
public static final String GET_BY_EMAIL = "select * from userinfo where email=?";
public static final String GET_PASSWORD_BY_PASSWORD = "select * from userinfo where password=?";

	
}
