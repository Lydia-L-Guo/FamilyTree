package com.example.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DataDao;
import com.example.model.Constant;
import com.example.model.FamilyData;

public class addPerson extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addPerson() {
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
		FamilyData	mMyFamilyData=new FamilyData();
		mMyFamilyData.setAd_birth(  (request.getParameter ("ad_birth")));
		mMyFamilyData.setAd_death(  (request.getParameter ("ad_death")));
		mMyFamilyData.setAlive_flag(request.getParameter ("alive_flag"));
		mMyFamilyData.setBiography( request.getParameter ("biography"));
		mMyFamilyData.setBirth_place( request.getParameter ("birth_place"));
		mMyFamilyData.setCe_birth( request.getParameter ("ce_birth"));
		mMyFamilyData.setCe_death( request.getParameter ("ce_death"));
		mMyFamilyData.setCommon_name( request.getParameter ("common_name"));
		mMyFamilyData.setDeath_place( request.getParameter ("death_place"));
		mMyFamilyData.setEpitaph( request.getParameter ("epitaph"));
		mMyFamilyData.setFather_id( request.getParameter ("father_id"));
		mMyFamilyData.setGender( request.getParameter ("gender"));
		mMyFamilyData.setGenealogy_name( request.getParameter ("genealogy_name"));
		mMyFamilyData.setGeneration( Constant.getInt(request.getParameter ("generation")));
		mMyFamilyData.setGid( Constant.getInt(request.getParameter ("gid")));
		mMyFamilyData.setLine_name( request.getParameter ("line_name"));
		mMyFamilyData.setMother_id( request.getParameter ("mother_id"));
		mMyFamilyData.setPrefix_name( request.getParameter ("prefix_name"));
		mMyFamilyData.setRank( request.getParameter ("rank"));
		mMyFamilyData.setShow_flag( request.getParameter ("show_flag"));
		mMyFamilyData.setSpouse( request.getParameter ("spouse"));
		mMyFamilyData.setSurname( request.getParameter ("surname"));
		mMyFamilyData.setTitle_name( request.getParameter ("title_name"));
		 
		
		
		DataDao dao=new DataDao();
		
		PrintWriter out = response.getWriter();
	 
		try {

			dao.addFamilyUserData( mMyFamilyData);
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
