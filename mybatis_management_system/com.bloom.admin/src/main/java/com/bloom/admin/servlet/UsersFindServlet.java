package com.bloom.admin.servlet;

import com.bloom.admin.dao.UsersDAO;
import com.bloom.entity.admin.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/servlet")//当访问index路径时，调用该servlet，servlet执行完操作后在转发给index.jsp
public class UsersFindServlet extends HttpServlet {
    private UsersDAO usersDao=new UsersDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> list= usersDao.findAll();//完成查询操作
        req.setAttribute("usersList",list);//将list保存在req请求对象中
        req.getRequestDispatcher("index.jsp").forward(req,resp);//请求转发到页面完成数据展示
    }
}
