package servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        List<User> list= (List<User>) this.getServletContext().getAttribute("list");
        for(User user:list){
            if(username.equals(user.getUsername())){
                if(password.equals(user.getPassword())){
                    //判断复选框是否勾选
                    if("true".equals(request.getParameter("remember"))){
                        //记忆用户名
                        Cookie cookie = new Cookie("username", user.getUsername());
                        //设置有效路径，访问该路径下的所有资源都会带cookie
                        cookie.setPath("/MVC servlet,jsp,javaBeam login");
                        //设置有效时间
                        cookie.setMaxAge(60 * 60 * 24);
                        //将cookie回写到浏览器
                        response.addCookie(cookie);
                    }
                    request.getSession().setAttribute("user",user);
                    response.sendRedirect("/MVC_servlet_jsp_javaBeam_login_war_exploded/success.jsp");
                    return;
                }
            }
        }
        request.setAttribute("msg","用户名或密码错误");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
