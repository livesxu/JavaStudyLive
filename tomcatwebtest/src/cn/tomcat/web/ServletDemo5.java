package cn.tomcat.web;

import sun.misc.BASE64Encoder;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet("/demo5")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //字符流
//        resp.getWriter().write("123");

//字节流
        //获取文件名称
        String filename = req.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        //找到图片img文件下路径
        String filepath = servletContext.getRealPath("/img/" + filename);

        //字节流关联图片
        FileInputStream fileInputStream = new FileInputStream(filepath);

        //获取文件类型
        String mimeType = servletContext.getMimeType(filename);
        //设置响应头content-type
        resp.setContentType(mimeType);
        //设置打开方式
        resp.setHeader("content-disposition","attachment;filename=" + filename);

        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[10*1024];

        int len = 0;

        while ((len = fileInputStream.read(buff)) != -1) {

            outputStream.write(buff,0,len);
        }

        fileInputStream.close();
    }

    public static String getFileName (String agent,String filename) {
        try {
            if (agent.contains("MSIE")) {//IE
                filename = URLEncoder.encode(filename,"utf-8");
                filename = filename.replace("+"," ");
            } else if (agent.toLowerCase().contains("firefox")){//火狐
                BASE64Encoder base64Encoder = new BASE64Encoder();
                filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
            } else {
                filename = URLEncoder.encode(filename,"utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }

        return filename;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo5执行了。。。");

        Object username = req.getAttribute("username");

        System.out.println(username.toString());

        //设置状态码302,设置响应头location
//        resp.setStatus(302);
//        resp.setHeader("location","/test/demo5");
//        resp.setContentType("text/html;charset=utf-8");
//        resp.setHeader("content-type","text/html;charset=utf-8");

//        this.getServletContext()
         ServletContext context = req.getServletContext();

         //全局数据，使用谨慎
//         context.setAttribute("one","全局共享数据");
//         context.getAttribute("one");
//         context.removeAttribute("one");

        //web目录下资源
        String filePath = context.getRealPath("/a.txt");
        File file = new File(filePath);

        //WEB-INF目录下的资源
        context.getRealPath("/WEB-INF/b.txt");

        //src目录下的资源访问
        context.getRealPath("/WEB-INF/classes/c.txt");

    }
}


