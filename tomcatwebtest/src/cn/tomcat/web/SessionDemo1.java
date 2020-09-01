package cn.tomcat.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //session的实现是基于cookie的JSESSIONID查找内存中存储的对象
        HttpSession session = req.getSession();

        String o = (String)session.getAttribute("go");

        System.out.println(o);

        session.setAttribute("go","123");

//        session.removeAttribute("go");

//        如何保证浏览器关闭之后依然拿到指定的session
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60*24);//一天有效
        resp.addCookie(cookie);

//        session会在服务器关闭时销毁
//        session调用invalidate()自毁
//        session默认失效时间30分钟 可以在配置文件中修改session-timeout

        //tomcat在服务器关闭时会将session钝化(服务器正常关闭之前会将数据序列化到硬盘上)，启动后会活化(将session文件转化为内存中的session对象)

    }
}
