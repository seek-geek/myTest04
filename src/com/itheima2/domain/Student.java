package com.itheima2.domain;

import com.itheima2.domain.Person;
import com.itheima2.utils.Utils;

/**
 * @Author：pengzhilin
 * @Date: 2020/8/13 9:53
 */
public class Student extends Person {

    {
        Utils.sid++;
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
