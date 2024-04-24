package com.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.IndirectionException;

import com.example.dao.DataDao;
import com.example.model.UserData;
 

public class Login extends HttpServlet {

 
	public Login() {
		super();
	}

	 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		String password = request.getParameter("password");
		System.out.println(username + "--" + password);

	 
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		String password = request.getParameter("password");

		System.out.println(username + "--" + password);

		DataDao dao = new DataDao();
		List<UserData> list = null;
	 
		try {
			list = dao.queryUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean isLogin = false;
        String inId="0";
		for (int i = 0; i < list.size(); i++) {
			if (username.equals(list.get(i).getUsername())
					&& password.equals(list.get(i).getPassword())) {
				isLogin = true;
				inId=list.get(i).getPath();
			  
			}

		}
		//
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
 	
		if (isLogin) {
			System.out.print("Login Succss" + username);
		    out.print(inId + "");

		} else {
			System.out.print("Login Failed");
		    out.print(  "false");
		}

	
 		out.flush();
		out.close();
	}

	 
	public void init() throws ServletException {
		// Put your code here
	}

}
