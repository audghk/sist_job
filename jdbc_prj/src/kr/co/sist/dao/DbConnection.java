package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton pattern을 사용한 DBMS Connection관리 클래스
 */
public class DbConnection {
	private static DbConnection dbCon;
	
	private DbConnection() {
	}//DbConnection
	
	public static DbConnection getInstance() {
		if(dbCon ==null) {//최초 호출이거나, 사용 중에 객체가 죽었다면 
			dbCon = new DbConnection();
		}//end if
		return dbCon;
	}//getInstance
	
	
	public Connection getConnection(String url, String id, String pass) throws SQLException{
		Connection con=null;
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.Connection 얻기
		con=DriverManager.getConnection(url,id,pass);
		
		return con;
	}//getConnection
	
	
	
	/**
	 * 로컬DBMS에 연동하여 Connection을 반환하는 일을 함
	 * 
	 * @param id
	 * @param pass
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String id, String pass) throws SQLException{
		Connection con=null;
		
		//1.드라이버 로딩           아 자기소개~~~ 박시현 현아~~ 온니 거울봐용 넘나 예뻐용 뀨잇뀨잇
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		//2.Connection 얻기
		con=DriverManager.getConnection(url,id,pass);
		
		return con;
	}//getConnection
	
	
	
	/**
	 * 연결을 종료하는 일
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void dbClose(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		try {
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
		}finally {
			if(con !=null) {con.close();}
		}//end finally, con은 반드시 실행되게.
	}
}//class