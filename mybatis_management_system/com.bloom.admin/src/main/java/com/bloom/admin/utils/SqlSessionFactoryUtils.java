package com.bloom.admin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactory初始化
 * 获取SqlSessionFactory
 * 关闭session
 */
public class SqlSessionFactoryUtils {
    private static String RESOURCE="com.bloom.admin-config.xml";//配置文件路径
    private static SqlSessionFactory sqlSessionFactory;//SqlSessionFactory对象
    //web项目将获取到的SqlSession对象存放在ThreadLocal中进行管理
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();

    //初始化SqlSessionFactory的方法：
    public static void initSqlSessionFactory() throws IOException {
        InputStream is= Resources.getResourceAsStream(RESOURCE);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        System.out.println("initsqlsessionfactory is done");
    }
    //获取SqlSessionFactory工厂对象的方法，和关闭session的方法
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    public static void close(){
        SqlSession session=threadLocal.get();
        if(session!=null){
            session.close();
            threadLocal.set(null);
        }
    }
}
