package Servlet;

import bean.UserInfo;
import dao.UserInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        UserInfo userInfo = new UserInfo(phone,password);

        UserInfo userInfoResult = UserInfoDao.loginUserInfo(userInfo);

        if (userInfoResult == null) {

            System.out.println("帐号或者密码错误!");
        } else {

            req.setAttribute("user",userInfoResult);

            System.out.println("登录成功");

            Cookie cookie = new Cookie("phone",userInfoResult.getPhone());
            resp.addCookie(cookie);

            //保持同一个会话session
            HttpSession session = req.getSession();
            String sessionId = session.getId();
            Cookie cookieS = new Cookie("JSESSIONID",sessionId);
            resp.addCookie(cookieS);

            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
