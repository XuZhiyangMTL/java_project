package com.bloom.admin.listener;

import com.bloom.admin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
//添加监听器配置，才能在容器启动和销毁的时候监听到对应的操作过程
@WebListener
public class InitSqlSessionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器加载中");
        //初始化SqlSessionFactory对象
        try {
            SqlSessionFactoryUtils.initSqlSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁中");
        //关闭SqlSession对象
        SqlSessionFactoryUtils.close();
    }
}
