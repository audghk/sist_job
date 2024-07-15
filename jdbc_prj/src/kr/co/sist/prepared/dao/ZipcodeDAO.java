package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.vo.ZipcodeVO;


public class ZipcodeDAO {
	private static ZipcodeDAO zDAO;
	
	private ZipcodeDAO() {
		
	}
	
	public static ZipcodeDAO getInstance() {
		if (zDAO == null) {
			zDAO = new ZipcodeDAO();
		}
		return zDAO;
	}
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> zVOList = new ArrayList<ZipcodeVO>();
		
		// 1. 드라이버 로딩
		DbConnection dbConn = DbConnection.getInstance();
		
		// 2. 커넥션 객체 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String id = "scott";
			String pass = "tiger";
			conn = dbConn.getConnection(id,pass);
			
			// 3. 쿼리문 생성
			StringBuilder selectZipcodes = new StringBuilder();
			selectZipcodes.append("select zipcode, sido, gugun, dong, nvl(bunji, ' ') bunji ")
			.append("from zipcode ")
			.append("where dong like ?||'%'	");
			pstmt = conn.prepareStatement(selectZipcodes.toString());
			
			// 4. 바인드 변수 지정
			pstmt.setString(1, dong);
			
			// 5. 쿼리 실행 및 결과 확인
			rs = pstmt.executeQuery();
			
			ZipcodeVO zVO = null;
			while (rs.next()) { // 조회된 결과에서 다음 레코드가 존재하는지 확인
				zVO = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"),
						rs.getString("gugun"), rs.getString("dong"),
						rs.getString("bunji"));
				zVOList.add(zVO);
			}
		} finally {
			// 6. 연결 끊기
			dbConn.dbClose(rs, pstmt, conn);
		}
		
		return zVOList;
	}
	
	public List<ZipcodeVO> selectStatemetZipcode(String dong) throws SQLException {
		List<ZipcodeVO> zVOList = new ArrayList<ZipcodeVO>();
		
		// 1. 드라이버 로딩
		DbConnection dbConn = DbConnection.getInstance();
		
		// 2. 커넥션 객체 생성
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String id = "scott";
			String pass = "tiger";
			con = dbConn.getConnection(id,pass);
			
			// 3. 쿼리문 생성
			stmt = con.createStatement();
			
			// 4. 바인드 변수 지정
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append("select zipcode, sido, gugun, dong, nvl(bunji, ' ') bunji ")
			.append("from zipcode ")
			.append("where dong like '"+dong+"%'	");
			
			// 5. 쿼리 실행 및 결과 확인
			rs = stmt.executeQuery(selectZipcode.toString());
			
			ZipcodeVO zVO = null;
			while (rs.next()) { // 조회된 결과에서 다음 레코드가 존재하는지 확인
				zVO = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"),
						rs.getString("gugun"), rs.getString("dong"),
						rs.getString("bunji"));
				zVOList.add(zVO);
			}
		} finally {
			// 6. 연결 끊기
			dbConn.dbClose(rs, stmt, con);
		}
		
		return zVOList;
	}
	
//	public static void main(String[] args) { //단일 테스트용
//		ZipcodeDAO zDAO = ZipcodeDAO.getInstance();
//		try {
//			System.out.println(zDAO.selectZipcode("역삼1동"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
