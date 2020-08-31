package cn.tomcat.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/cookiedemo2")
public class CookieDemo2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        String lastTimeKey = "lastTime";
        String lastTimeValue = null;
        for (Cookie cookie : cookies) {

            String name = cookie.getName();
            String value = cookie.getValue();

            if (name.equals(lastTimeKey)) {

                lastTimeValue = value;

                break;
            }
        }

        //解决中文乱码问题
//        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        if (lastTimeValue != null) {

//            编解码可以防止一些合法字符的问题 比如 空格
            resp.getWriter().write("欢迎登录，您上次登录时间为 " + URLDecoder.decode(lastTimeValue,"utf-8"));
        } else {

            resp.getWriter().write("欢迎您首次登录！");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastTimeValue = localDateTime.format(dateTimeFormatter);

        resp.addCookie(new Cookie(lastTimeKey, URLEncoder.encode(lastTimeValue,"utf-8")));



        Cookie cookie = new Cookie("msg","hello-world");
//        cookie.setMaxAge(100);//正数：将cookie数据写到硬盘文件中，持久化存储，存活时间 example:100秒
//        cookie.setMaxAge(0);//删除cookie
//        cookie.setMaxAge(-1);//负数：默认 关闭浏览器则清空
//        cookie.setPath("/");//设置共享范围，因为默认cookie只在当前的虚拟目录下共享
//        cookie.setDomain(".baidu.com");//设置一级域名相同 cookie可以在多个服务直接共享

        resp.addCookie(cookie);

//      cookie的特点和作用：
//        1.cookie存放在客户端浏览器
//        2.对于大小有限制(一般<4kb)，以及同一个域名下cookie的数量也有限制(一般<20)
//        作用：
//            1.用于存放少量不太敏感的数据
//            2.不登录情况下，对客户端的身份校验

    }
}
