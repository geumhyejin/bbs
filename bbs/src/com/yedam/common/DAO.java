package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	Connection conn;
	private String driver = "oracle.jdbc.ddriver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "bbs";
	private String passwd ="bbs";

	try
	{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, passwd);
	}catch(
	ClassNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{

	}
}
}
