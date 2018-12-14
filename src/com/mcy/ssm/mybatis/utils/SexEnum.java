package com.mcy.ssm.mybatis.utils;

import org.junit.jupiter.api.Test;

public enum SexEnum {
    MALE(1, "男"),FEMALE(0, "女");

    private int id;
    private String name;

    SexEnum(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public SexEnum getSexById(int id)
    {
        for (SexEnum sexEnum : SexEnum.values())
        {
            if (sexEnum.getId() == id)
            {
                return sexEnum;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        SexEnum sexEnum = SexEnum.valueOf("MALE");
        System.out.println(sexEnum.getName());
    }

}
