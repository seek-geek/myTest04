package com.itheima.utils;

import com.itheima.domain.Person;
import com.itheima.domain.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author：pengzhilin
 * @Date: 2020/6/14 9:24
 */
public class Utils {

    // 定义一个静态的id变量,用来给学生对象的id赋值
    public static int id ;// 100个对象 id=100 程序停止再启动
    public static int tid ;// 100个对象 id=100 程序停止再启动

    static {
        id = 0;// 以后可以读取文件中记录的id值,赋为初始值
        tid = 0;
    }


    // 根据生日计算年龄的方法
    public static int birthdayToAge(String birthday){
        // 思路:
        // 1. 获取当前日期对象
        Date nowDate = new Date();

        // 2. 创建日期格式化对象,指定日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 3. 调用parse()解析方法对字符串生日解析为Date类型的生日
        Date birthdayDate = null;
        try {
            birthdayDate = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 4.比较出生日期是否在当前日期之后,如果是,直接返回 -1;
        if (birthdayDate.after(nowDate)) {
            return -1;
        }
        // 5.获取当前时间的日历对象
        Calendar cal = Calendar.getInstance();

        // 6.获取当前时间的年,月,日
        int nowYear = cal.get(Calendar.YEAR);
        int nowMonth = cal.get(Calendar.MONTH);
        int nowDay = cal.get(Calendar.DAY_OF_MONTH);

        // 7.通过日历对象调用setTime(Date date)方法,设置日历对象的时间为出生日期的时间
        cal.setTime(birthdayDate);

        // 8.通过设置之后的日历对象获取生日的年,月,日
        int birthdayYear = cal.get(Calendar.YEAR);
        int birthdayMonth = cal.get(Calendar.MONTH);
        int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);

        // 9.使用当前时间的年 - 生日的年 得到一个初步的年龄
        int age = nowYear - birthdayYear;

        // 10.如果当前时间的月 小于 生日的月份,那么初步年龄-1
        if (nowMonth < birthdayMonth){
            age--;
        }

        // 11.如果当前时间的月 等于生日的月份,但当前时间的日 小于 生日的日,那么初步年龄-1
        if (nowMonth == birthdayMonth){
            if (nowDay < birthdayDay){
                age--;
            }
        }
        // 10.直接返回年龄
        return age;
    }

    // 打印Person对象
    public static void printPerson(Person p){
        System.out.println(p.getId()+"\t\t"+p.getName()+
                "\t\t"+p.getSex()+"\t\t"+p.getBirthday()+
                "\t\t"+p.getAge()+"\t\t"+p.show());
    }

    // 打印集合所有元素
    public static void printArrayList(ArrayList list){
        System.out.println("**************************************************************************");
        System.out.println("编号\t\t姓名\t\t性别\t\t生日\t\t\t\t年龄\t\t描述");
        // 循环遍历集合
        for (int i = 0; i < list.size(); i++) {
            // 获取集合元素
            Person p = (Person) list.get(i);
            // 打印对象
            printPerson(p);
        }
        System.out.println("**************************************************************************");
    }
}
