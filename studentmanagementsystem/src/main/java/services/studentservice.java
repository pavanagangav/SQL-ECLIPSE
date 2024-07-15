package services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.student;

public class studentservice {
	private Connection conn;
	

	public studentservice(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean addstudent(student s) {
		boolean f = false;

		try {
			String sql = "insert into student(rollnumber,Name,Email,Branch,Section) values(?,?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, s.getRollnumber());
			pmst.setString(2, s.getName());
			pmst.setString(3, s.getEmail());
			pmst.setString(4, s.getBranch());
			pmst.setString(5, s.getSectio());
			int i = pmst.executeUpdate();
			if (i > 0) {
				f = true;
			}
			conn.close();
			pmst.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
