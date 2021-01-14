package servlet;

import domain.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;

//用户注册初始化Servlet
public class InitServlet extends javax.servlet.http.HttpServlet {
    @Override
    public void init() throws ServletException {
        List<User> list=new ArrayList<User>();
        this.getServletContext().setAttribute("list",list);
    }
}
