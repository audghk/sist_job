package kr.co.sist.day0320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton 패턴을 사용한 DBNS커넥션 관리 클래스
 */
public class DbConnection {
	private static DbConnection dbCon;
	
	private DbConnection() {
		
	}
	
	public static DbConnection getInstance() {
		if(dbCon == null) { //최초호출이거나, 사용중 객체가 죽었다면 if를 탄다
			dbCon = new DbConnection();
		}
		
		return dbCon;
	}//getInstance
	
	/**
	 * Connection을 반환하는 method
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String url, String id, String pass)throws SQLException{
		Connection con = null;
		
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		//2. Connection 얻기
		con = DriverManager.getConnection(url,id,pass);
		
		return con;
	}
	
	/**
	 * 로컬 DBMS에 연동하여 Connection을 
	 * @param id
	 * @param pass
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String id, String pass)throws SQLException{
		Connection con = null;
		
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		//2. Connection 얻기
		con = DriverManager.getConnection(url,id,pass);
		
		return con;
	}
		
	/**
	 * 연결을 종료하는 메서드 
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void dbClose(ResultSet rs, Statement stmt, Connection con)throws SQLException{
		try {
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
		}finally {
			if(con != null) {con.close();}			
		}
	}
	
	
}//class
