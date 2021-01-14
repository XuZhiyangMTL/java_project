package com.bloom.admin.servlet;

import com.bloom.entity.admin.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import com.bloom.admin.dao.UsersDAO;
@WebServlet("/updateusers")

public class UsersUpdateServlet extends HttpServlet {

    private UsersDAO usersDAO=new UsersDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户要更新的数据
        String id=request.getParameter("id");
        String nickname=request.getParameter("nickname");
        String age=request.getParameter("age");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String remark=request.getParameter("remark");
        //2.创建用户变量
        Users user=new Users(Integer.parseInt(id),nickname,Integer.parseInt(age),gender,email,phone,new Date(),remark);
        //3.提交更新
        usersDAO.updateUsers(user);
        //4.查看更新后的用户数据
        response.sendRedirect("/com_bloom_admin_war_exploded/detail?id=" + user.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
