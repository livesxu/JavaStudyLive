package cn.tomcat.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //get tomcat 8 将get乱码问题解决了
        //post中文会乱码，在获取参数之前设置request的编码(应该跟页面编码保持一致)
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("username");

        System.out.println(name);

        Map<String,String[]> maps = req.getParameterMap();
        Set<String> keys = maps.keySet();
        for (String key : keys) {

            String[] values = maps.get(key);

            for (String value :values) {

                System.out.println(value);
            }

            System.out.println("-----------");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

//        String name = req.getParameter("username");
//
//        System.out.println(name);
        this.doPost(req,resp);
    }
}
