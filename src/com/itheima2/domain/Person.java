package com.itheima2.domain;

/**
 * @Author：pengzhilin
 * @Date: 2020/8/13 9:49
 */
public abstract class Person {
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 年龄
     */
    private int age;

    // 构造方法
    public Person() {
    }

    public Person(int id, String name, String sex, String birthday, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
    }

    // set\get方法
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // 成员方法
    /**
     * 通用模板
     * @return
     */
    public String show(){
        return "我是一名:"+getType()+",我的工作是:"+getWork();
    }

    /**
     * 填充模板
     * @return 类型
     */
    public abstract String getType();

    /**
     * 填充模板
     * @return 工作
     */
    public abstract String getWork();


}
