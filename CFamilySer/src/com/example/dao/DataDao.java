package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
import com.example.model.BookData;
import com.example.model.Constant;
import com.example.model.FamilyData;
import com.example.model.UserData;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DataDao {
 

	public List<FamilyData> queryFamilyUser(String id) throws SQLException {
		List<FamilyData> list = new ArrayList<FamilyData>();
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from individual");

			while (re.next()) {

				String usera=re.getInt("id")+"";  
				if (usera.equals(id)) {
					
					FamilyData	mMyFamilyData=new FamilyData();
					mMyFamilyData.setAd_birth( (re.getString("ad_birth")));
					mMyFamilyData.setAd_death( (re.getString("ad_death")));
					mMyFamilyData.setAlive_flag(re.getString("alive_flag"));
					mMyFamilyData.setBiography( re.getString("biography"));
					mMyFamilyData.setBirth_place( re.getString("birth_place"));
					mMyFamilyData.setCe_birth( re.getString("ce_birth"));
					mMyFamilyData.setCe_death( re.getString("ce_death"));
					mMyFamilyData.setCommon_name( re.getString("common_name"));
					mMyFamilyData.setDeath_place( re.getString("death_place"));
					mMyFamilyData.setEpitaph( re.getString("epitaph"));
					mMyFamilyData.setFather_id( re.getString("father_id"));
					mMyFamilyData.setGender( re.getString("gender"));
					mMyFamilyData.setGenealogy_name( re.getString("genealogy_name"));
					mMyFamilyData.setGeneration( ( re.getInt("generation")));
					mMyFamilyData.setGid(  (re.getInt("gid")));
					mMyFamilyData.setLine_name( re.getString("line_name"));
					mMyFamilyData.setMother_id( re.getString("mother_id"));
					mMyFamilyData.setPrefix_name( re.getString("prefix_name"));
					mMyFamilyData.setRank( re.getString("ranks"));
					mMyFamilyData.setShow_flag( re.getString("show_flag"));
					mMyFamilyData.setSpouse( re.getString("spouse"));
					mMyFamilyData.setSurname( re.getString("surname"));
					mMyFamilyData.setTitle_name( re.getString("title_name"));
			 
					mMyFamilyData.setId(re.getInt("id") );
					list.add(mMyFamilyData);
			 
				}

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				re = null;
			}
		}

	}

	
	
	

	public int queryFamilyMax( ) throws SQLException {
		 int max=0;
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from individual");

			while (re.next()) {

				max=re.getInt("id") ;  
				 

			}
			return max;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

		} 

	}

	
	
	
	
	
	
	
	
	
	
	public List<FamilyData> queryFamilyGid(String gid) throws SQLException {
		List<FamilyData> list = new ArrayList<FamilyData>();
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from individual");

			while (re.next()) {

				String usera=re.getInt("gid")+"";  
				if (usera.equals(gid)) {
					
					FamilyData	mMyFamilyData=new FamilyData();
					mMyFamilyData.setAd_birth( (re.getString("ad_birth")));
					mMyFamilyData.setAd_death( (re.getString("ad_death")));
					mMyFamilyData.setAlive_flag(re.getString("alive_flag"));
					mMyFamilyData.setBiography( re.getString("biography"));
					mMyFamilyData.setBirth_place( re.getString("birth_place"));
					mMyFamilyData.setCe_birth( re.getString("ce_birth"));
					mMyFamilyData.setCe_death( re.getString("ce_death"));
					mMyFamilyData.setCommon_name( re.getString("common_name"));
					mMyFamilyData.setDeath_place( re.getString("death_place"));
					mMyFamilyData.setEpitaph( re.getString("epitaph"));
					mMyFamilyData.setFather_id( re.getString("father_id"));
					mMyFamilyData.setGender( re.getString("gender"));
					mMyFamilyData.setGenealogy_name( re.getString("genealogy_name"));
					mMyFamilyData.setGeneration( ( re.getInt("generation")));
					mMyFamilyData.setGid(  (re.getInt("gid")));
					mMyFamilyData.setLine_name( re.getString("line_name"));
					mMyFamilyData.setMother_id( re.getString("mother_id"));
					mMyFamilyData.setPrefix_name( re.getString("prefix_name"));
					mMyFamilyData.setRank( re.getString("ranks"));
					mMyFamilyData.setShow_flag( re.getString("show_flag"));
					mMyFamilyData.setSpouse( re.getString("spouse"));
					mMyFamilyData.setSurname( re.getString("surname"));
					mMyFamilyData.setTitle_name( re.getString("title_name"));
			 
					mMyFamilyData.setId(re.getInt("id") );
					list.add(mMyFamilyData);
			 
				}

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				re = null;
			}
		}

	}

	public void deleteFamilyData(String id) throws SQLException {
		// É¾³ý
		Connection conn = LoginDao.getConnection();
		String sql = "delete from individual where id=?";
		try {

			int ids = Integer.parseInt(id);
			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);
			ptmt.setInt(1, ids);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void addFamilyUserData(FamilyData data ) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = LoginDao.getConnection();
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();

			String sql = "" + "insert into individual"
					+ "(gid,surname,genealogy_name,gender,ad_birth,ad_death,spouse,father_id,mother_id,generation,ranks,prefix_name,common_name,line_name,ce_birth,ce_death,alive_flag,show_flag,biography,epitaph,birth_place,death_place,create_by,create_time,update_by,update_time,del_flag)" + "values("
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt.setInt(1, data.getGid());
			ptmt.setString(2, data.getSurname());
			ptmt.setString(3,data.getGenealogy_name());
			ptmt.setString(4,data.getGender());
			ptmt.setString(5,data.getAd_birth());
			ptmt.setString(6,data.getAd_death());
			ptmt.setString(7,data.getSpouse());
			ptmt.setString(8,data.getFather_id());
			ptmt.setString(9,data.getMother_id());
			ptmt.setInt(10,data.getGeneration());
			ptmt.setString(11,data.getRank());
			ptmt.setString(12,data.getPrefix_name());
			 
		
			ptmt.setString(13,data.getCommon_name());
			ptmt.setString(14,data.getLine_name());
			//ptmt.setString(13,data.getTitle_name());
			ptmt.setString(15,data.getCe_birth());
			ptmt.setString(16,data.getCe_death());
			ptmt.setString(17,data.getAlive_flag());
			ptmt.setString(18,data.getShow_flag());
			ptmt.setString(19,data.getBiography());
			ptmt.setString(20,data.getEpitaph());
			ptmt.setString(21,data.getBirth_place());
			ptmt.setString(22,data.getDeath_place());
			ptmt.setString(23,data.getCreate_by());
			ptmt.setLong(24,data.getCreate_time());
			ptmt.setString(25,data.getUpdate_by());
			ptmt.setLong(26,data.getUpdate_time());
			ptmt.setString(27,data.getDel_flag());
			
			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	 /**
	  * ¸üÐÂ×åÆ×
	  * @param id
	  * @param data
	  */
	public void updateFamilyGid(String id,int gid) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			int ids = Integer.parseInt(id);
			 
			updateInt(gid,"gid", ids, conn);
 
 
			
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}


	public void updateFamilyUserData(String id,FamilyData data) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			int ids = Integer.parseInt(id);
			update(data.getSurname(),"surname", ids, conn);
			update(data.getGenealogy_name(),"genealogy_name", ids, conn);
			update(data.getGender(),"gender", ids, conn);
			update(data.getAd_birth(),"ad_birth", ids, conn);
			update(data.getAd_death(),"ad_death", ids, conn);
			update(data.getSpouse(),"spouse", ids, conn);
//			update(data.getFather_id(),"father_id", ids, conn);
//			update(data.getMother_id(),"mother_id", ids, conn);
			//updateInt(data.getGeneration(),"generation", ids, conn);
			update(data.getRank(),"ranks", ids, conn);
			update(data.getPrefix_name(),"prefix_name", ids, conn);
			update(data.getCommon_name(),"common_name", ids, conn);
			update(data.getLine_name(),"line_name", ids, conn);
			update(data.getCe_birth(),"ce_birth", ids, conn);
			update(data.getCe_death(),"ce_death", ids, conn);
			
			update(data.getAlive_flag(),"alive_flag", ids, conn);
			update(data.getShow_flag(),"show_flag", ids, conn);
			update(data.getBiography(),"biography", ids, conn);
			update(data.getEpitaph(),"epitaph", ids, conn);
			update(data.getBirth_place(),"birth_place", ids, conn);
			update(data.getDeath_place(),"death_place", ids, conn);
//			update(data.getAlive_flag(),"create_by", ids, conn);
//			update(data.getAlive_flag(),"create_time", ids, conn);
//			update(data.getAlive_flag(),"update_by", ids, conn);
//			update(data.getAlive_flag(),"update_time", ids, conn);
//			update(data.getAlive_flag(),"del_flag", ids, conn);
 
			
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	
	private void update(String content,String str,int ids,Connection conn) {
	 
		String sql = "";
			sql = "update individual set "+str+" = ? where id= ?";
		 try {
			PreparedStatement ptmt = (PreparedStatement) conn
				.prepareStatement(sql);

		   ptmt.setInt(2, ids);
	
			ptmt.setString(1, content);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	private void updateLong(long content,String str,int ids,Connection conn) {
		 
		String sql = "";
			sql = "update individual set "+str+" = ? where id= ?";
		 try {
			PreparedStatement ptmt = (PreparedStatement) conn
				.prepareStatement(sql);

		   ptmt.setInt(2, ids);
	
			ptmt.setLong(1, content);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	private void updateInt(int content,String str,int ids,Connection conn) {
		 
		String sql = "";
			sql = "update individual set "+str+" = ? where id= ?";
		 try {
			PreparedStatement ptmt = (PreparedStatement) conn
				.prepareStatement(sql);

		   ptmt.setInt(2, ids);
	
			ptmt.setInt(1, content);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void addBook(String name,String theme,String hall_name,String tag_name,String location,String create_by,long create_time
			
			
			) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = LoginDao.getConnection();
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();

			String sql = "" + "insert into genealogy"
					+ "(name,theme,hall_name,tag_name,location,create_by,create_time,update_by,update_time,del_flag,description,cate)" +
					"values(" + "?,?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt.setString(1, name);
			ptmt.setString(2, theme);
			ptmt.setString(3, hall_name);
			ptmt.setString(4, tag_name);
			ptmt.setString(5, location);
			ptmt.setString(6, create_by);
			ptmt.setString(7, Constant.TimeFormat(create_time));
			ptmt.setString(8, "");
			ptmt.setString(9, Constant.TimeFormat(create_time));
			ptmt.setString(10, "");
			ptmt.setString(11,  "");
			ptmt.setString(12,  "");
			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void updateBook(String id, String name,String theme,String hall_name,String tag_name,String location) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			int ids = Integer.parseInt(id);
			updateBos(name, "name", ids, conn);
			updateBos(theme, "theme", ids, conn);
			updateBos(hall_name, "hall_name", ids, conn);
			updateBos(tag_name, "tag_name", ids, conn);
			updateBos(location, "location", ids, conn);
 			
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	private void updateBos(String content,String str,int ids,Connection conn) {
		 
		String sql = "";
			sql = "update genealogy set "+str+" = ? where id= ?";
		 try {
			PreparedStatement ptmt = (PreparedStatement) conn
				.prepareStatement(sql);

		   ptmt.setInt(2, ids);
	
			ptmt.setString(1, content);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	 }
	
	
	

	public int queryBookMax( ) throws SQLException {
		 int max=0;
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from genealogy");

			while (re.next()) {

				max=re.getInt("gid") ;  
				 

			}
			return max;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

		} 

	}

	

	public List<BookData> queryBook(String gid)
			throws SQLException {

		List<BookData> list = new ArrayList<BookData>();
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from genealogy");

			while (re.next()) {
				String usera = re.getInt("gid")+"";
				if (   gid.equals(usera)) {
 					BookData bean = new BookData();
					bean.setCate(re.getString("cate"));
					bean.setCreate_by(re.getString("create_by"));
					bean.setCreate_time(re.getLong("create_time"));
					bean.setDel_flag(re.getString("del_flag"));
					bean.setDescription(re.getString("description"));
					bean.setGid(re.getInt("gid"));
					bean.setHall_name(re.getString("(hall_name"));
					bean.setLocation(re.getString("location"));
					bean.setName(re.getString("name"));
					bean.setTag_name(re.getString("tag_name"));
					bean.setTheme(re.getString("theme"));
					bean.setUpdate_time(re.getLong("update_time"));
				 
					 
				 
					list.add(bean);
				}

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				re = null;
			}
		}

	}

	 

	public void deleteBook(String id) throws SQLException {
		// É¾³ý
		Connection conn = LoginDao.getConnection();
		String sql = "delete from genealogy where id=?";
		try {
			int ids = Integer.parseInt(id);
			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);
			ptmt.setInt(1, ids);
			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

		}

	}

	
	
	
	public void deleteUser(String id) throws SQLException {
		//
		Connection conn = LoginDao.getConnection();
		String sql = "delete from userlist where id=?";
		try {

			int ids = Integer.parseInt(id);
			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);
			ptmt.setInt(1, ids);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void updatePassword(String user, String password) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			String sql = "";

			sql = "update userlist set password = ? where name= ?";

			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);

			ptmt.setString(2, user);
			ptmt.setString(1, password);

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void updateUser(String user, String info) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			String sql = "";

			sql = "update userlist set info = ? where name= ?";

			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);

			ptmt.setString(2, user);
			ptmt.setString(1, info);

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	public void updateUserInid(String user, String id) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			int ids=Integer.parseInt(id);
			
			String sql = "";

			sql = "update userlist set inId = ? where name= ?";

			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);

			ptmt.setString(2, user);
			ptmt.setInt(1, ids);

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void addDocData(String title , String author, String format,String path,String description,String content,int gid) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = LoginDao.getConnection();
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();

			String sql = "" + "insert into Doc"
					+ "(title,author,format,path,description,content,gid)" + "values(" + "?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt.setString(1, title);
			ptmt.setString(2, author);
			ptmt.setString(3, format);
			
			ptmt.setString(4, path);
			ptmt.setString(5, description);
			ptmt.setString(6, content);
			ptmt.setInt(7, gid);
		  
			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
 
	public void deleteDoc(String id) throws SQLException {
		// É¾³ýÍÆ¼ö
		Connection conn = LoginDao.getConnection();
		String sql = "delete from Doc where id=?";
		try {
			int ids = Integer.parseInt(id);
			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);
			ptmt.setInt(1, ids);
			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

		}

	}
	
	
	public void updateDoc(String id, String content) {

		try {

			Connection conn = LoginDao.getConnection();

			PreparedStatement ps;
			String sql = "";

			sql = "update Doc set content = ? where id= ?";

			PreparedStatement ptmt = (PreparedStatement) conn
					.prepareStatement(sql);

			ptmt.setInt(2, Integer.parseInt(id));
			ptmt.setString(1, content);

			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void addUserData(UserData bean,int inId) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = LoginDao.getConnection();
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();

			String sql = "" + "insert into userlist" + "(name,password,inId)"
					+ "values(" + "?,?,?)";
			java.sql.PreparedStatement ptmt = conn.prepareStatement(sql);

			ptmt.setString(1, bean.getUsername());
			ptmt.setString(2, bean.getPassword());
			String dates = System.currentTimeMillis() + "";
			//ptmt.setString(3, dates);
			ptmt.setInt(3, inId);

			ptmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	 
	public List<UserData> queryUsers() throws SQLException {

		List<UserData> list = new ArrayList<UserData>();
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from userlist");

			while (re.next()) {

				UserData bean = new UserData();
				bean.setUsername(re.getString("name"));
				bean.setPassword(re.getString("password"));
				bean.setId(re.getInt("id") + "");
				bean.setPath(re.getInt("inId")+"");
				 
				list.add(bean);

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				re = null;
			}
		}

	}

	public List<UserData> queryUsers(String key) throws SQLException {

		List<UserData> list = new ArrayList<UserData>();
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from userlist");

			while (re.next()) {

				UserData bean = new UserData();
				bean.setUsername(re.getString("name"));
				bean.setPassword(re.getString("password"));
				bean.setId(re.getInt("id") + "");
				 
			 
				if (bean.getUsername().equals(key)) {
					list.add(bean);
				}

			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				re = null;
			}
		}

	}
	
 
	
	
	public String queryUsersInfo(String user) throws SQLException {

	    String info=null;
		Connection conn = LoginDao.getConnection();
		Statement stmt = null;
		ResultSet re = null;
		try {
			stmt = (Statement) conn.createStatement();

			re = stmt.executeQuery("select * from userlist");

			while (re.next()) {

			 
				 String name=(re.getString("name"));
				  if (user!=null&&user.equals(name)) {
					 info=re.getString("info");
				}

			}
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			if (re != null) {
				try {
					re.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				re = null;
			}
		}

	}

	 
	

}
