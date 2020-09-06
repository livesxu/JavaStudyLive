package cn.tomcat.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("过滤器创建了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("过滤器执行了");
        //demo演示屏蔽敏感词，屏蔽 "笨蛋"
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletRequest p_req = (HttpServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("getParameter") && args != null) {

                    String str = (String)method.invoke(request,args);

                    if (str != null && str.contains("笨蛋")) {

                        str = str.replace("笨蛋","***");
                    }
                    return str;
                }

                return method.invoke(request,args);
            }
        });
        System.out.println("过滤器执行了");
        //资源执行
        filterChain.doFilter(p_req,servletResponse);
        System.out.println("过滤器执行了");
    }

    @Override
    public void destroy() {

        System.out.println("过滤器销毁了");
    }
}
