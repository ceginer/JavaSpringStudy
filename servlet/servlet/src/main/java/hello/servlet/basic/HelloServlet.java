package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
// name이나 urlpattrens 은 겹치면 안됨
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // ctrl + o 버튼
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);

        System.out.println("HelloServlet.service");
        // soutv 로 단축키 이용
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 만약 http 직접 파싱하면 너무 귀찮고 힘듬
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 메시지 - HttpServletResponse 즉,response 에 찍어주기
        // 아래 2개는 http content-type에 들어가는 것
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // write 하면 http 메시지 body 에 내용 들어감
        response.getWriter().write("hello"+ username);

    }
}
