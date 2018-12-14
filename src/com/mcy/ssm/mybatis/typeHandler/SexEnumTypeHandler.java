package com.mcy.ssm.mybatis.typeHandler;

import com.mcy.ssm.mybatis.utils.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexEnumTypeHandler implements TypeHandler<SexEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public SexEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
