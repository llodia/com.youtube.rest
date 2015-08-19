package com.youtube.db;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PostgresDb 
{
	private static DataSource ds=null;// using datasource you need only to know the JNDI name
	// for Driver manager you need to know all the details (host, port, username, password, driver class)
	private static Context ctext = null;
	private static String host=null;
	private  String url= null;
	private String user=null;
	private String password= null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static Integer port;
	private static Connection c=null;
	private static JSONObject obj = null;
	
	
	
public PostgresDb()
{
		
}


public String getUrl()
{
	this.url="jdbc:postgresql://localhost:5432/powaaim";
	return url;
}


public String getUser()
{
	this.user="postgres";
	return user;
}

public String getPass()
{
	this.password="Daouda70";
	return password;
}




public static void main(String[]args) throws SQLException, ClassNotFoundException, JSONException
{
	PostgresDb db = new PostgresDb();
   // db.setUrl("jdbc:postgresql://localhost:5432/powaaim");
	
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	st = c.createStatement();
	rs = st.executeQuery("SELECT id, name, externalshopid from shop where name='David_3'") ;
	System.out.println("id"+" "+"name"+ " " +"externalshopid");
	c.close();
    obj = new JSONObject();
	
		while(rs.next())
		{	
	    int id = rs.getInt("id");
		String externaId = rs.getString("externalshopid");
	    String name= rs.getString("name");
		//System.out.println(id+ " " + " "+ name + " " +" "+ externaId);
		System.out.println();
		obj.put("id", id);
		obj.put("name", name);
		obj.put("externalshopid",externaId);
		System.out.print(obj);
}
}
}

   




