package com.mcy.ssm.mybatis.main;

import com.mcy.ssm.mybatis.entity.Role;
import com.mcy.ssm.mybatis.entity.User;
import com.mcy.ssm.mybatis.mapper.RoleMapper;
import com.mcy.ssm.mybatis.mapper.UserMapper;
import com.mcy.ssm.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    @Test
    public void testRole() {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roles = roleMapper.findRoles2("MCY");
            if (roles != null)
            {
                for (Role role :
                        roles) {
                    System.out.println(role.getNote());
                }
//                roleMapper.insertRole(role);
            }
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
            if (sqlSession != null)
            sqlSession.rollback();
        }
        finally {
            if (sqlSession != null)
            {
                sqlSession.close();
            }
        }

    }
    @Test
    public void testUser()
    {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1L);
            System.out.println(user.getSex().getName());
            sqlSession.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (sqlSession != null)
                sqlSession.rollback();
        }
        finally {
            if (sqlSession != null)
                sqlSession.close();
        }


    }
}
