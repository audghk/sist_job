package kr.co.sist.day0320;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	
	private static LoginDAO lDAO;
	
	private LoginDAO() {
	}//LoginDAO
	
	public static LoginDAO getInstance() throws SQLException {
		if(lDAO == null) {
			lDAO = new LoginDAO();
		}//end if
		return lDAO;
	}//getInstance
	
	//로그인 코드를 Statement로 구현
	
	public LoginResultVO selectLogin(LoginVO lVO) throws SQLException {
		LoginResultVO lrVO = null;
		
		//1.드라이버 연결
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
		//2.Connection 얻기
		String id ="scott";
		String pass = "tiger";
		con = dbCon.getConnection(id, pass);
		
		//3.쿼리문 생성 객체 얻기
		stmt = con.createStatement();

		StringBuilder selectData = new StringBuilder();
		selectData
		.append("	select name,input_date	")
		.append("	from test_login	")
		.append("	where id='"+lVO.getId()+"' and pass='"+lVO.getPass()+"'");
		//4.쿼리문 수행 후 결과 얻기
		
		rs = stmt.executeQuery(selectData.toString());
		
		if(rs.next()) {
			lrVO = new LoginResultVO(rs.getString("name"), rs.getDate("input_date"));
		}//end if
		
		}finally {
		//5.연결 끊기
			dbCon.dbClose(rs, stmt, con);
		}//end finally
		
		return lrVO;
	}//selectLogin
	
	//PreparedStatement를 사용하면 SQLInjection이 방어된다.
	public LoginResultVO selectPreparedLogin(LoginVO lVO) throws SQLException {
		LoginResultVO lrVO = null;
		
		//1.드라이버 연결
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//2.Connection 얻기
		String id ="scott";
		String pass = "tiger";
		con = dbCon.getConnection(id, pass);
		
		//3.쿼리문 생성 객체 얻기

		StringBuilder selectData = new StringBuilder();
		selectData
		.append("	select name,input_date	")
		.append("	from test_login			")
		.append("	where id=? and pass=?	");
		pstmt = con.prepareStatement(selectData.toString());
		
		
		//4.
		pstmt.setString(1, lVO.getId());
		pstmt.setString(2, lVO.getPass());
		
		//5.쿼리문 수행 후 결과 얻기
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			lrVO = new LoginResultVO(rs.getString("name"), rs.getDate("input_date"));
		}//end if
		
		}finally {
		//5.연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return lrVO;
	}//selectLogin
	
//	public static void main(String[] args) throws SQLException {
//		System.out.println(LoginDAO.getInstance().selectLogin(new LoginVO("kim","1234")));
//	}
	
}
