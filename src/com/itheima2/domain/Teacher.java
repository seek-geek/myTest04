package com.itheima2.domain;

import com.itheima.domain.Person;

/**
 * @Author：pengzhilin
 * @Date: 2020/8/13 9:54
 */
public class Teacher extends Person {

    public Teacher() {
    }

    public Teacher(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    @Override
    public String getType() {
        return "老师";
    }

    @Override
    public String getWork() {
        return "教Java...";
    }
}
