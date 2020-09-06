package Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verifyImage")
public class verifyImage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        int width = 100;
        int height = 50;
        //创建一个对象，在内存中的图片
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //设置图片背景色
        Graphics graphics = bufferedImage.getGraphics();//画笔对象
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width,height);

        //画边框
        graphics.setColor(Color.red);
        graphics.drawRect(0,0,width-1,height-1);

        graphics.setColor(Color.blue);
        String ss = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        char[] p = new char[4];
        for (int i = 0; i < 4; i++) {

            char c = ss.charAt((int)(Math.floor(Math.random()*ss.length())));
            //画字符
            graphics.drawString(String.valueOf(c),width/4/2 + width/4*i,height/2);

            p[i] = c;
        }
        //将验证码的值存在session里面
        req.getSession().setAttribute("verify",String.valueOf(p));

        Random random = new Random();
        for (int i = 0;i < 10; i++) {

            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            //画干扰线
            graphics.drawLine(x1,x2,y1,y2);
        }

        //图片输出
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
