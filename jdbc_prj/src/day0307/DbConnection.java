package day0307;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private static DbConnection dbCon;
	
	private DbConnection() {
	}//DbConnection
	
	public static DbConnection getInstance() {
		if(dbCon == null) {
			dbCon = new DbConnection();
		}//end if
		
		return dbCon;
	}//getInstance
	
	public Connection getConnection(String id,String pass) throws SQLException {
		Connection con = null;
		//1.드라이버 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//2.Connection 얻기
		con = DriverManager.getConnection(url,id,pass);
		
		return con;
	}//getConnection
	
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }//end if
        if (stmt != null) {
        	stmt.close();
        }//end if
        if (conn != null) {
            conn.close();
        }//end if
    }//dbClose
	
}
