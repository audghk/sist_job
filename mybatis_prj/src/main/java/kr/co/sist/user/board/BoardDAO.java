package kr.co.sist.user.board;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import kr.co.sist.dao.MyBatisDAO;

public class BoardDAO {

  private static BoardDAO bDAO;
  private String[] columnNames;

  private BoardDAO() {
    columnNames = new String[] {"title", "content", "id"};
  }

  public static BoardDAO getInstance() {
    if (bDAO == null) {
      bDAO = new BoardDAO();
    } // end if
    return bDAO;
  }// getInstance

  /**
   * 총 레코드의 수
   * 
   * @param sVO
   * @return
   * @throws SQLException
   */
  public int selectTotalCount(SearchVO sVO) throws PersistenceException {
    int totalCnt = 0;

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(false);
    // 2.쿼리문 실행
    totalCnt = ss.selectOne("kr.co.sist.board.selectTotalCount", sVO);
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

    return totalCnt;
  }

  public List<BoardDomain> selectBoard(SearchVO sVO) throws PersistenceException {
    List<BoardDomain> list = null;

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(false);
    // 2.쿼리문 실행
    list = ss.selectList("kr.co.sist.board.selectBoardList", sVO);
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

    return list;
  }

  public void insertBoard(BoardVO bVO) throws PersistenceException {

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(true);// auto commit
    // 2.쿼리문 실행
    ss.insert("kr.co.sist.board.insertBoard", bVO);
    // int t = ss.insert("kr.co.sist.board.insertBoard", bVO);
    // int t2 = ss.insert("kr.co.sist.board.insertBoard", bVO);
    // if (t == 1 && t2 == 1) {
    // ss.commit();
    // } else {
    // ss.rollback();
    // }
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

  }// insertBoard

  public BoardDomain selectDetailBoard(int seq) throws PersistenceException {

    BoardDomain bd = null;

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(false);
    // 2.쿼리문 실행
    bd = ss.selectOne("kr.co.sist.board.selectDetailBoard", seq);// 글을 조회
    // ss.update("kr.co.sist.board.updateCnt", seq);// 조회수 증가
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

    return bd;
  }// selectDetailBoard

  public int updateCnt(int seq) throws PersistenceException {
    int cnt = 0;

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(true);
    // 2.쿼리문 실행
    cnt = ss.update("kr.co.sist.board.updateCnt", seq);// 조회수 증가
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

    return cnt;
  }

  public int updateBoard(BoardVO bVO) throws PersistenceException {

    int cnt = 0;

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(true);
    // 2.쿼리문 실행
    cnt = ss.update("kr.co.sist.board.updateBoard", bVO);
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

    return cnt;

  }// updateBoard

  public int deleteBoard(BoardVO bVO) throws PersistenceException {

    int cnt = 0;

    // 1.MyBatis Handler 얻기
    MyBatisDAO mbDAO = MyBatisDAO.getInstance();
    SqlSession ss = mbDAO.getMyBatisHandler(true);
    // 2.쿼리문 실행
    cnt = ss.delete("kr.co.sist.board.deleteBoard", bVO);
    // 3.MyBatis Handler 닫기
    mbDAO.closeHandler(ss);

    return cnt;

  }// deleteBoard


  public static void main(String[] args) {
    // SearchVO sVO = new SearchVO();
    // sVO.setField("1");
    // sVO.setKeyword("g");
    // sVO.setStartNum(1);
    // sVO.setEndNum(10);
    // BoardDAO.getInstance().selectTotalCount(sVO);
    // BoardDAO.getInstance().selectBoard(sVO);
    // BoardVO bVO = new BoardVO(0, 530, "마이바티스로 추가", "세상 편함 생산성 오짐", "kim", null);
    // BoardDAO.getInstance().insertBoard(bVO);

    // BoardDAO.getInstance().selectDetailBoard(88);
    BoardDAO.getInstance().updateCnt(88);
  }

}
