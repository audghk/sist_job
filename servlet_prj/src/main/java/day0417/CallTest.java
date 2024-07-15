package day0417;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CallTest
 */
@SuppressWarnings("serial")
public class CallTest extends HttpServlet {

  // 2.요청 방식을 처리할 수 있는 method Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 3. 응답방식 설정()
    response.setContentType("text/html;charset=UTF-8");
    // 4. 출력스트림 얻기
    PrintWriter out = response.getWriter();
    // 5.응답내용 만들기
    out.write("<!DOCTYPE html>\r\n");
    out.write("<html>\r\n");
    out.write("<head>\r\n");
    out.write("<meta charset=\"UTF-8\">\r\n");
    out.write("<title>Insert title here</title>\r\n");
    out.write("</head>\r\n");
    out.write("<body>\r\n");
    out.write("<div><h1>GET방식의 요청에 대한 응답</h1></div>\r\n");
    out.write("<div><a href='javascript:history.back()'>뒤로</a></div>\r\n");
    out.write("</body>\r\n");
    out.write("</html>");
  }// doGet

  // 2.요청 방식을 처리할 수 있는 method Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 3. 응답방식 설정()
    response.setContentType("text/html;charset=UTF-8");
    // 4. 출력스트림 얻기
    PrintWriter out = response.getWriter();
    // 5.응답내용 만들기
    out.write("<!DOCTYPE html>\r\n");
    out.write("<html>\r\n");
    out.write("<head>\r\n");
    out.write("<meta charset=\"UTF-8\">\r\n");
    out.write("<title>Insert title here</title>\r\n");
    out.write("</head>\r\n");
    out.write("<body>\r\n");
    out.write("<div><h1 style='color:#FF0000'>POST방식의 요청에 대한 응답</h1></div>\r\n");
    out.write("<div><a href='javascript:history.back()'>뒤로</a></div>\r\n");
    out.write("</body>\r\n");
    out.write("</html>");
  }// doPost

}
