package com.bloom.admin.servlet;

import com.bloom.admin.dao.UsersDAO;
import com.bloom.entity.admin.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deluser")
public class UsersDelServlet extends HttpServlet {
    private UsersDAO usersDAO=new UsersDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String id=request.getParameter("id");
        String type=request.getParameter("type");
        //执行删除或者锁定
        if("lock".equals(type)){
            Users user=new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(1);
            usersDAO.updateUsers(user);//update使用动态语句，只对UserStatus进行更改，其他数据不动
        }else if("del".equals(type)){
            usersDAO.delUsers(Integer.parseInt(id));
        }else if("unlock".equals(type)){
            Users user=new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(0);
            usersDAO.updateUsers(user);
        }
        //跳转到首页
        response.sendRedirect("/com_bloom_admin_war_exploded/servlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
