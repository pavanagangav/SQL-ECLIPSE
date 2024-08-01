package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.login;

public class loginservice {

	private Connection conn;

	public loginservice(Connection conn) {
		super();
		this.conn = conn;
	}
	//Posting of data
	public boolean addingstudent(login log) {
		boolean f=false;
		try {
			
			String sql="insert into student(name,email,password) values(?,?,?)";
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, log.getName());
			pmst.setString(2, log.getEmail());
			pmst.setString(3, log.getPassword());
		int i=pmst.executeUpdate();
		if(i>0)
		{
			f=true;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	//fetching to data
public List<login> fetchall(){
	List<login> ll =new ArrayList<login>();
	login lo=null;
	try {
		String sql="select * from student";
		PreparedStatement pmst=conn.prepareStatement(sql);
		ResultSet rs=pmst.executeQuery();
		while (rs.next()) {
		lo=new login();
		lo.setId(rs.getInt(1));
		lo.setName(rs.getString(2));
		lo.setEmail(rs.getString(3));
		lo.setPassword(rs.getString(4));
		ll.add(lo);
		
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ll;
}

//fetch by id
public login getbyid(int id) {
	login lo=null;
	try {
		
		String sql="select * from login where id = ?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setInt(1, id);
		 ResultSet rs=	pmst.executeQuery();
		 while (rs.next()) {
			 lo=new login();
			 lo.setId(rs.getInt(1));
			 lo.setName(rs.getString(2));
			 lo.setEmail(rs.getString(3));
			 lo.setPassword(rs.getString(4));
			 
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lo;
	
	
}

//delete by id
public boolean deletebyid(int id) {
	boolean f=false;
	try {
		String sql="delete from  student where id = ?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setInt(1, id);
		int i=pmst.executeUpdate();
		if(i>0) {
			f=true;
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return f;
}

//delete by email
public boolean deletebyemail(String email) {
	boolean f=false;
	try {
		String sql="delete from  student where email = ?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setString(1, email);
		int i=pmst.executeUpdate();
		if(i>0) {
			f=true;
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return f;
}

//update
public boolean update(login lo) {
	boolean f=false;
	try {
		String sql="update student set name = ?, email = ?, password = ? where id = ?";
		PreparedStatement pmst =conn.prepareStatement(sql);
		pmst.setString(1, lo.getName());
		pmst.setString(2, lo.getEmail());
		pmst.setString(3, lo.getPassword());
		pmst.setInt(4, lo.getId());
		int i=pmst.executeUpdate();
		if(i>0) {
			f=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
	
}
}
