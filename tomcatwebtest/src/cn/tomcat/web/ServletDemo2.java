package cn.tomcat.web;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/demo2","/d2"})
public class ServletDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("do get....");
//        1.获取请求方式
        String method = req.getMethod();
        System.out.println(method);
//        2.获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
//        3.获取servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
//        4.获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
//        5.获取请求的URI
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
//        6.获取请求的URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
//        7.获取协议及版本
        String protocol = req.getProtocol();
        System.out.println(protocol);
//        8.获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
//        9.获取请求头中的某个值 user-agent  referer
        String userAgent = req.getHeader("user-agent");
        System.out.println(userAgent);
//        10.获取所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + " --> " + value);
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求消息体
        System.out.println("do post....");

//        获取字节流
        BufferedReader bufferedReader = req.getReader();

//        读取数据
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {

            System.out.println(line);
        }
    }
}
