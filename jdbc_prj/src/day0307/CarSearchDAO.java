package day0307;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarSearchDAO {
	private static CarSearchDAO csDAO;
	
	private CarSearchDAO() {
	}//HomeworkDAO
	
	public static CarSearchDAO getInstance() {
		if(csDAO == null) {
			csDAO = new CarSearchDAO();
		}//end if
		
		return csDAO;
	}//getInstance
	
	public List<CarVO> selectCarList(String maker) throws SQLException {
		List<CarVO> list = new ArrayList<CarVO>();
		
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//1.드라이버 연결
		try {
		String id = "scott";
		String pass = "tiger";
		
		//2.Connection 얻기
		con = dbCon.getConnection(id, pass);
		
		//3.쿼리문 생성 객체 얻기
		StringBuilder selectCar = new StringBuilder();
		selectCar
		.append("	select country,maker,model,car_year,price,car_option	")
		.append("	from(select cc.country,cc.maker,cmo.model,cmo.car_year,cmo.price,cmo.car_option,	")
		.append("		row_number() over(order by hiredate desc) rnum	")
		.append("		from	car_country cc, car_maker cma, car_model cmo	")
		.append("		where (cma.maker(+)=cc.maker and cmo.model(+)=cma.model) and cc.maker = ?)	")
		.append("	where rnum between 1 and 10	");
		
		pstmt = con.prepareStatement(selectCar.toString());
		
		//4.바인드 변수 값 설정
		pstmt.setString(1,maker);
		
		//5.쿼리문 수행 후 결과 얻기
		rs = pstmt.executeQuery();
		
		CarVO cVO = null;
		while(rs.next()) {
			cVO = new CarVO(rs.getString("country"),rs.getString("maker"),rs.getString("model"),rs.getString("car_year"),rs.getString("car_option"),rs.getInt("price"));
			
			list.add(cVO);
		}//end while
		
		}finally {
		//6.연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return list;
	}//selectCarList
	
//	public static void main(String[] args) throws SQLException {
//		System.out.println(CarSearchDAO.getInstance().selectCarList("현대"));
//	}//main
	
}//class
