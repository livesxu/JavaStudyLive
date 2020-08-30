package cn.tomcat.web;

import cn.tomcat.web.bean.RalUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ral/login")
public class ServletRALLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        int user = Integer.parseInt(req.getParameter("user"));
        String password = req.getParameter("password");

        List<RalUser> users = JDBCRALUtils.getJdbcTemplate().query("select * from raluser where user=? and password=?;", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {

                preparedStatement.setInt(1,user);
                preparedStatement.setString(2,password);
            }
        },new BeanPropertyRowMapper<RalUser>(RalUser.class));

        System.out.println(users);
        if (users.size() > 0) {
            RalUser users1 = users.get(0);
            req.setAttribute("pagetip","登录成功 " + users1.getUser());
            req.getRequestDispatcher("success").forward(req,resp);
        } else {
            req.setAttribute("pagetip","登录失败");
            req.getRequestDispatcher("fail").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }
}
