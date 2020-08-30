package cn.tomcat.web;

import cn.tomcat.web.bean.RalUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

@WebServlet("/ral/register")
public class ServletRALRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        //BeanUtils 使用
//        Map map = req.getParameterMap();
//        RalUser ralUser = new RalUser();
//        try {
//            BeanUtils.populate(ralUser,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        int user = Integer.parseInt(req.getParameter("user"));
        String password = req.getParameter("password");

        try {
            Connection connection = JDBCRALUtils.getConnection();

            String sqlString = "insert raluser(user,password) values (?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setInt(1,user);
            preparedStatement.setString(2, password);

            int count = preparedStatement.executeUpdate();

            if (count > 0) {

                System.out.println("注册成功");
                req.setAttribute("pagetip","注册成功");
                req.getRequestDispatcher("success").forward(req,resp);
            } else {

                System.out.println("注册失败");
                req.setAttribute("pagetip","注册失败");

                //转发
                req.getRequestDispatcher("fail").forward(req,resp);
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }
}
