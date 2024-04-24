package com.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DataDao;
import com.example.model.BookData;
import com.example.model.FamilyData;

public class getBook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getBook() {
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
		out.println("<!DOCTYPE HTML PUBLIC\"-//W3C//DTD HTML 4.01 Transitional//EN\">");
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
	 * The doPost method of the servlet. <br>
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
		DataDao dao = new DataDao();
		String id = request.getParameter("id");
	 
 		List<BookData> list = null;
		PrintWriter out = response.getWriter();
 		try {
			
			list = dao.queryBook(id);
					;
 			String json = "{\"result\":\"SUCCESS\",\"code\":200,\"data\":[";
			String s = "";
			for (int i = 0; i < list.size(); i++) {
              
				if (i == list.size() - 1) {
					json = json + "{ " + "\"id\":" + "\""+ list.get(i).getGid()
							 
							+ "\",\"name\":" + "\"" + list.get(i).getName()
							+ "\",\"theme\":" + "\"" + list.get(i).getTheme()
							+ "\",\"hall_name\":" + "\"" + list.get(i).getHall_name()
							+ "\",\"tag_name\":" + "\"" + list.get(i).getTag_name()
							+ "\",\"location\":" + "\"" + list.get(i).getLocation()
							+ "\",\"create_by\":" + "\"" + list.get(i).getCreate_by()
							+ "\",\"del_flag\":" + "\"" + list.get(i).getDel_flag()
							 
						  
                          
							+ "" + "\"}]}";

				} else {
					json = json + "{ " + "\"id\":" + "\""+ list.get(i).getGid()
 						 
							+ "\",\"name\":" + "\"" + list.get(i).getName()
							+ "\",\"theme\":" + "\"" + list.get(i).getTheme()
							+ "\",\"hall_name\":" + "\"" + list.get(i).getHall_name()
							+ "\",\"tag_name\":" + "\"" + list.get(i).getTag_name()
							+ "\",\"location\":" + "\"" + list.get(i).getLocation()
							+ "\",\"create_by\":" + "\"" + list.get(i).getCreate_by()
							+ "\",\"del_flag\":" + "\"" + list.get(i).getDel_flag()
	                       
							+ "\"},";

				}

			}
			out.write(json);
		    System.err.println(""+json);
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
