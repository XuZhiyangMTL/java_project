package com.bloom.admin.servlet;

import com.bloom.admin.dao.UsersDAO;
import com.bloom.entity.admin.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {
    private UsersDAO usersDAO=new UsersDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        Users user= usersDAO.findById(Integer.parseInt(id));//parseInt强制类型转换为整型
        request.setAttribute("user",user);
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
