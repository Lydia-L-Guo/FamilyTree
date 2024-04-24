package com.example.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DataDao;

public class addBook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addBook() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 *  创建族谱
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
 
		 String id=request.getParameter("id");//我的信息的id
		 
		DataDao dao=new DataDao();
		
	  	 PrintWriter out = response.getWriter();
 		 String create_by=request.getParameter("user");
		 String location=request.getParameter("location");
		 String tag_name=request.getParameter("tag_name");
		 String hall_name=request.getParameter("hall_name");
		 String theme=request.getParameter("theme");
		 String name=request.getParameter("name");
		  
		try {

			dao.addBook(name, theme, hall_name, tag_name, location, create_by, System.currentTimeMillis());
			int max=dao.queryBookMax();
 			dao.updateFamilyGid(id, max);
			 
			out.write(true + "");

			out.flush();
		} catch (Exception e) {
			out.print("false");
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
