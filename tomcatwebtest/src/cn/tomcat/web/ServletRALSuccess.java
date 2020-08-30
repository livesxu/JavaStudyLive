package cn.tomcat.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ral/success")
public class ServletRALSuccess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        设置编码
        resp.setContentType("text/html;charset=utf-8;");
        String tip = (String)req.getAttribute("pagetip");

//        输出
        resp.getWriter().write(tip);
    }
}
