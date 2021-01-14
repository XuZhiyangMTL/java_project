package servlet;

import domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //用来保存数据的Map集合
            Map<String,String> map=new HashMap<String,String>();
            //1.创建一个磁盘文件项工厂对象
            DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
            //2.创建一个核心解析类
            ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
            //3.解析request请求，返回的是List集合，List集合中存放的是FileItem对象
            List<FileItem> list=servletFileUpload.parseRequest(request);
            //保存兴趣爱好数据的集合
            List<String> hobbyList=new ArrayList<String>();
            //4.遍历集合，获得每个FileItem，判断是表单项还是文件上传项
            String url=null;
            for(FileItem fileItem:list) {
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    //接收复选框的值
                    if ("hobby".equals(name)) {
                        String hobbyValue = fileItem.getString("UTF-8");
                        hobbyList.add(hobbyValue);
                        hobbyValue = hobbyList.toString().substring(1, hobbyList.toString().length() - 1);
                        map.put(name, hobbyValue);
                    } else {
                        //把非多选数据存入map集合之中
                        map.put(name, value);
                    }
                } else {
                    //upload file
                    //获得上传文件的文件名
                    String fileName = fileItem.getName();
                    if (fileName != null && !"".equals(fileName)) {
                        System.out.println(fileName);
                        //获得唯一文件名作为储存在服务器上的文件的文件名
                        String uuidFileName = UploadUtils.getUUIDFileName(fileName);
                        //获得上传的数据
                        InputStream is = fileItem.getInputStream();
                        //获得上传的路径
                        String path = this.getServletContext().getRealPath("/upload");
                        //讲输入流对接输出流
                        url = path + "\\" + uuidFileName;
                        OutputStream os = new FileOutputStream(url);
                        int len = 0;
                        byte[] b = new byte[1024];
                        while ((len = is.read(b)) != -1) {
                            os.write(b, 0, len);
                        }
                        is.close();
                        os.close();
                    }
                }
            }
            System.out.println(map);
            //封装数据到user中
            List<User> userList= (List<User>) this.getServletContext().getAttribute("list");
            //校验用户名:
            for(User u:userList){
                if(u.getUsername().equals(map.get("username"))){
                    request.setAttribute("msg","用户名已经存在");
                    request.getRequestDispatcher("/regist.jsp").forward(request,response);
                    return;
                }
            }
            User user=new User();
            user.setUsername(map.get("username"));
            user.setPassword(map.get("password"));
            user.setNickname(map.get("nickname"));
            user.setSex(map.get("sex"));
            user.setHobby(map.get("hobby"));
            user.setPath(url);
            userList.add(user);
            this.getServletContext().setAttribute("list",userList);
            //注册成功跳转到登陆页面
            request.getSession().setAttribute("username",user.getUsername());
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
