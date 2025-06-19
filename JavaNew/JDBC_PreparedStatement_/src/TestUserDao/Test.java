package TestUserDao;

import java.util.ArrayList;

import DAO.UserDAO;
import DAO.UserDAO_PreparedStatement;
import Model.User;

public class Test {

	
	public static void main(String[] args) {
		
//		User u1 = new User("u1", "u123", "UUU");
//		UserDAO.getInstance().insert(u1);
//		for(int i=1;i<=10;i++) {
//			User u = new User("U"+i, "U123", "UUU");
//			UserDAO.getInstance().insert(u);
//		}
		System.out.println("----------------------");
//		Cach lay thong tin User binh thuong 
//		User u_find = new User("u10", "u123", "UUU");
//		User u_result  = UserDAO_PreparedStatement.getInstance().selectById(u_find);
//		System.out.println(u_result);
		
		// Cach Hacker lay thong tin
		User u_find = new User("x\' or 1=1; -- ","u123" , "UUU");
		User user_result = new UserDAO_PreparedStatement().getInstance().selectById(u_find);
		System.out.println(user_result);
	
	}
}
