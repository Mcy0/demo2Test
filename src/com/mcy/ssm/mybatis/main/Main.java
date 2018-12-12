package com.mcy.ssm.mybatis.main;

import com.mcy.ssm.mybatis.entity.Role;
import com.mcy.ssm.mybatis.mapper.RoleMapper;
import com.mcy.ssm.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            if (role != null)
            {
                log.info(role.getRoleName());
                roleMapper.insertRole(role);
            }
            sqlSession.commit();
        }catch (Exception e)
        {
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
}
