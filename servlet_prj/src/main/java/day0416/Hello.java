package day0416;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet을 상속받는다.
@SuppressWarnings("serial")
public class Hello extends HttpServlet {
  // 2. 요청 방식을 처리할 수 있는 method를 Overriding
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("request : " + request);
    System.out.println("response : " + response);
    // 3. 응답방식 설정 (MIME-types 설정 : servers/web.xml 참조)
    response.setContentType("text/html;charset=UTF-8");

    // 4. 접속자에게 응답할 수 있도록 출력 스트림 얻기
    PrintWriter out = response.getWriter();

    // 5. 응답할 내용을 만들어서 출력
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>Servelet 연습</title>");
    out.println("</head>");
    out.println("<body>");
    String name = "ㅇㅁㅇ";
    out.println("<marquee>" + name + "</marquee>");
    out.println("<div>Hello World!</div>");
    out.println("</body>");
    out.println("</html>");
  }

}
