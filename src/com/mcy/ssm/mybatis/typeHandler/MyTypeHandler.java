package com.mcy.ssm.mybatis.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARBINARY)
public class MyTypeHandler implements TypeHandler<String> {
    private static Logger log = Logger.getLogger(MyTypeHandler.class);
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        log.info("设置string参数【" + s + "】");
        preparedStatement.setString(i, s);
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        log.info("读取string参数1【" + result + "】");
        return result;
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        log.info("读取string参数2【" + result + "】");
        return result;
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        log.info("读取string参数3【" + result + "】");
        return result;
    }
}
