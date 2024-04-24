package com.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DataDao;
import com.example.model.FamilyData;

public class getPserSonByGid extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getPserSonByGid() {
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
	 
 		List<FamilyData> list = null;
		PrintWriter out = response.getWriter();
 		try {
			
			list = dao.queryFamilyGid(id)
					;
 			String json = "{\"result\":\"SUCCESS\",\"code\":200,\"data\":[";
			String s = "";
			for (int i = 0; i < list.size(); i++) {
              
				if (i == list.size() - 1) {
					json = json + "{ " + "\"gid\":" + "\""+ list.get(i).getGid()
							 
							+ "\",\"surname\":" + "\"" + list.get(i).getSurname()
							+ "\",\"genealogy_name\":" + "\"" + list.get(i).getGenealogy_name()
							+ "\",\"gender\":" + "\"" + list.get(i).getGender()
							+ "\",\"ad_birth\":" + "\"" + list.get(i).getAd_birth()
							+ "\",\"ad_death\":" + "\"" + list.get(i).getAd_death()
							+ "\",\"spouse\":" + "\"" + list.get(i).getSpouse()
							+ "\",\"father_id\":" + "\"" + list.get(i).getFather_id()
							+ "\",\"mother_id\":" + "\"" + list.get(i).getMother_id()
							+ "\",\"generation\":" + "\"" + list.get(i).getGeneration()
							+ "\",\"rank\":" + "\"" + list.get(i).getRank()
							+ "\",\"prefix_name\":" + "\"" + list.get(i).getPrefix_name()
							+ "\",\"title_name\":" + "\"" + list.get(i).getTitle_name()
							+ "\",\"common_name\":" + "\"" + list.get(i).getCommon_name()
							+ "\",\"line_name\":" + "\"" + list.get(i).getLine_name()
							+ "\",\"ce_birth\":" + "\"" + list.get(i).getCe_birth()
							+ "\",\"ce_death\":" + "\"" + list.get(i).getCe_death()
							+ "\",\"alive_flag\":" + "\"" + list.get(i).getAlive_flag()
							+ "\",\"show_flag\":" + "\"" + list.get(i).getShow_flag()
							+ "\",\"biography\":" + "\"" + list.get(i).getBiography()
							+ "\",\"epitaph\":" + "\"" + list.get(i).getEpitaph()
							
							+ "\",\"birth_place\":" + "\"" + list.get(i).getBirth_place()
							+ "\",\"death_place\":" + "\"" + list.get(i).getDeath_place()
							+ "\",\"create_by\":" + "\"" + list.get(i).getCreate_by()
							+ "\",\"create_time\":" + "\"" + list.get(i).getCreate_time()
							+ "\",\"update_by\":" + "\"" + list.get(i).getUpdate_by()
							+ "\",\"update_time\":" + "\"" + list.get(i).getUpdate_time()
							
							+ "\",\"del_flag\":" + "\"" + list.get(i).getDel_flag()
						 
						  
							+"\",\"id\":" + "\"" + list.get(i).getId()
                          
							+ "" + "\"}]}";

				} else {
					json = json + "{ " + "\"gid\":" + "\""+ list.get(i).getGid()
 						 
							+ "\",\"surname\":" + "\"" + list.get(i).getSurname()
							+ "\",\"genealogy_name\":" + "\"" + list.get(i).getGenealogy_name()
							+ "\",\"gender\":" + "\"" + list.get(i).getGender()
							+ "\",\"ad_birth\":" + "\"" + list.get(i).getAd_birth()
							+ "\",\"ad_death\":" + "\"" + list.get(i).getAd_death()
							+ "\",\"spouse\":" + "\"" + list.get(i).getSpouse()
							+ "\",\"father_id\":" + "\"" + list.get(i).getFather_id()
							+ "\",\"mother_id\":" + "\"" + list.get(i).getMother_id()
							+ "\",\"generation\":" + "\"" + list.get(i).getGeneration()
							+ "\",\"rank\":" + "\"" + list.get(i).getRank()
							+ "\",\"prefix_name\":" + "\"" + list.get(i).getPrefix_name()
							+ "\",\"title_name\":" + "\"" + list.get(i).getTitle_name()
							+ "\",\"common_name\":" + "\"" + list.get(i).getCommon_name()
							+ "\",\"line_name\":" + "\"" + list.get(i).getLine_name()
							+ "\",\"ce_birth\":" + "\"" + list.get(i).getCe_birth()
							+ "\",\"ce_death\":" + "\"" + list.get(i).getCe_death()
							+ "\",\"alive_flag\":" + "\"" + list.get(i).getAlive_flag()
							+ "\",\"show_flag\":" + "\"" + list.get(i).getShow_flag()
							+ "\",\"biography\":" + "\"" + list.get(i).getBiography()
							+ "\",\"epitaph\":" + "\"" + list.get(i).getEpitaph()
							
							+ "\",\"birth_place\":" + "\"" + list.get(i).getBirth_place()
							+ "\",\"death_place\":" + "\"" + list.get(i).getDeath_place()
							+ "\",\"create_by\":" + "\"" + list.get(i).getCreate_by()
							+ "\",\"create_time\":" + "\"" + list.get(i).getCreate_time()
							+ "\",\"update_by\":" + "\"" + list.get(i).getUpdate_by()
							+ "\",\"update_time\":" + "\"" + list.get(i).getUpdate_time()
							
							+ "\",\"del_flag\":" + "\"" + list.get(i).getDel_flag()
						 
						 
							+"\",\"id\":" + "\"" + list.get(i).getId()
	                       
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
