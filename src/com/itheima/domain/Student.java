package com.itheima.domain;

import com.itheima.utils.Utils;

/**
 * @Author：pengzhilin
 * @Date: 2020/6/14 9:22
 */
public class Student extends Person {
    {
        Utils.id++;
    }
    public Student() {
    }

    public Student(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    @Override
    public String getType() {
        return "学生";
    }

    @Override
    public String getWork() {
        return "学Java...";
    }


}
