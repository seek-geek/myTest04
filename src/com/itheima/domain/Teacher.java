package com.itheima.domain;

/**
 * @Author：pengzhilin
 * @Date: 2020/6/14 9:22
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
