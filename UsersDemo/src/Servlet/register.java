package Servlet;

import bean.UserInfo;
import dao.UserInfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String verify = req.getParameter("verify");
        String sessionVerify = (String)req.getSession().getAttribute("verify");
        if (verify != sessionVerify) {

            System.out.println("验证码错误");
            return;
        } else {

            System.out.println("验证码正确");
        }

        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        UserInfo userInfo = UserInfoDao.registerUserInfo(new UserInfo(phone,password));

        if (userInfo == null) {

            System.out.println("注册失败！");
        } else {

            req.setAttribute("user",userInfo);

            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
