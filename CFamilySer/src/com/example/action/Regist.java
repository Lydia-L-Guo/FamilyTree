package com.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DataDao;
import com.example.model.FamilyData;
import com.example.model.UserData;

public class Regist extends HttpServlet {

 
	public Regist() {
		super();
	}

 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 
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

		boolean isHas = false;

		for (int i = 0; i < list.size(); i++) {
			if (username.equals(list.get(i).getUsername())) {
				isHas = true;
			}

		}
		// 返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (!isHas) {
			UserData bean = new UserData();
			bean.setUsername(username);
			bean.setPassword(password);

			try {
			
				 FamilyData da=new FamilyData();
				 da.setCommon_name(""+username);
				 da.setGeneration(1);
				
 				 dao.addFamilyUserData(da);
 				 
 				 int max=dao.queryFamilyMax();
  				 dao.addUserData(bean,max);
  				 
  				
  				
 			 	 dao.addBook(username+"族谱", "", "", "", "", username, System.currentTimeMillis());
 			     int gid=	dao.queryBookMax();
 			     
 			     dao.updateFamilyGid(max+"", gid);
 				
				 out.print("true");

				System.out.println("注册成功"+username+ max+" --"+gid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.print("false" + username + password + "-----------------");
		}

		out.flush();
		out.close();
	}

	 
	public void init() throws ServletException {
		// Put your code here
	}

}
