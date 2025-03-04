package day0530;

import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.EmpDomain;

public class ExamMapper6DAO {

  private static ExamMapper6DAO em6DAO = null;

  private ExamMapper6DAO() {

  }// ExamMapper4DAO

  public static ExamMapper6DAO getInstance() {
    if (em6DAO == null) {

      em6DAO = new ExamMapper6DAO();

    } // end if

    return em6DAO;
  }// getInstance

  public List<EmpDomain> dynamicChoose(int num) throws PersistenceException {
    List<EmpDomain> list = null;

    // 1. MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(false);
    // 2. 쿼리 수행 후 결과 얻기
    list = ss.selectList("kr.co.sist.exam6.dynamicChoose", num);
    // 3. MyBatis Handler 닫기
    mbDAO.closeHandler(ss);
    return list;
  }// dynamicIf2


  public static void main(String[] args) {
    ExamMapper6DAO.getInstance().dynamicChoose(3);
  }

}// class
