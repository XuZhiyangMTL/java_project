package com.bloom.admin.dao;

import com.bloom.admin.utils.SqlSessionFactoryUtils;
import com.bloom.entity.admin.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UsersDAO {
    private SqlSession sqlSession;
    //查询数据的方法：
    private List<Users> list;
    private Users user;

    private SqlSession getSession(){
        sqlSession=SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    public List<Users> findAll() {
        try {
            list = getSession().selectList("findUsers");//findAll配置在usersMapper.xml中
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }
    //根据编号查询单个用户
    public Users findById(Integer id) {
        try {
            user = getSession().selectOne("findUsers", new Users(id));
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    //增加一个新用户数据到数据库
    public Users addUser(Users user){
        try{
            //返回值是insert执行过程中影响的行数
            getSession().insert("addUser",user);
            //添加到数据库后要提交一下数据更新
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return user;
    }

    //用于修改用户资料的方法
    public Users updateUsers(Users user){
        try{
            getSession().update("updateUser", user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
        return user;
    }
    //根据id进行删除
    public void delUsers(Integer id){
        try{
            getSession().delete("delUser",id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
}
