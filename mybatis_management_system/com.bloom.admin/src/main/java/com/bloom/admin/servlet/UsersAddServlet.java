package com.bloom.admin.servlet;

import com.bloom.admin.dao.UsersDAO;
import com.bloom.entity.admin.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addusers")
public class UsersAddServlet extends HttpServlet {
    private UsersDAO usersDAO=new UsersDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要添加的用户数据
        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        String nickname=request.getParameter("nickname");
        String age=request.getParameter("age");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        //2.根据用户数据创建一个用户对象
        Users user=new Users(username,userpass,nickname,Integer.parseInt(age),gender,email,phone,new Date(),new Date(),new Date(),0);
        //3.将用户对象添加到数据库中
        user=usersDAO.addUser(user);
        //4.查看刚新增的用户数据
        response.sendRedirect("/com_bloom_admin_war_exploded/detail?id=" + user.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
