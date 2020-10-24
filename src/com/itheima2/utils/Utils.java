package com.itheima2.utils;

import com.itheima2.domain.Person;
import com.itheima2.domain.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author：pengzhilin
 * @Date: 2020/8/13 9:56
 */
public class Utils {
    // 0.定义一个静态变量,用来记录学生的编号,初始值为0
    public static int sid ;
    // 0.定义一个静态变量,用来记录老师的编号,初始值为0
    public static int tid ;

    static {
        // 赋初始值---读文件中的数据,赋初始值
        sid = 0;
        tid = 0;
    }

    /**
     * 根据出生日期计算年龄
     * @param birthday
     * @return
     */
    public static int getAge(String birthday){
        // 1.判断传入的birthday是否为null,如果为null,直接返回-1(作为标识)
        if (birthday == null){
            return -1;
        }
        // 2.创建日期格式化对象,指定日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 3.把字符串类型的日期,转换为Date类型的日期
        Date birthdayDate = null;
        try {
            birthdayDate = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 4.判断出生日期是否在当前日期之前,如果不在当前日期之前,就返回-1(作为标识)
        Date nowDate = new Date();
        if (nowDate.before(birthdayDate)){
            return -1;
        }

        // 5.获取当前时间的日历对象
        Calendar cal = Calendar.getInstance();

        // 6.获取当前时间的年,月,日
        int nowYear = cal.get(Calendar.YEAR);
        int nowMonth = cal.get(Calendar.MONTH);
        int nowDay = cal.get(Calendar.DAY_OF_MONTH);

        // 7.使用日历对象调用setTime(Date date)方法,设置日历对象表示的时间为出生日期的时间
        cal.setTime(birthdayDate);

        // 8.获取出生日期的年月日
        int birthdayYear = cal.get(Calendar.YEAR);
        int birthdayMonth = cal.get(Calendar.MONTH);
        int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);

        // 9.计算初步的年龄: 当前时间的年  -  出生日期的年
        int age = nowYear - birthdayYear;

        // 10.判断月份: 如果月份没到,初步年龄-1
        if (nowMonth < birthdayMonth){
            age--;
        }
        // 11.如果月份到了,日子没到,初步年龄-1
        if (nowMonth == birthdayMonth){
            if (nowDay < birthdayDay){
                age--;
            }
        }
        // 12.返回初步年龄
        return age;
    }

    /**
     * 按照指定规则打印集合中所有的元素
     * @param list
     */
    public static void printArrayList(ArrayList list){
        System.out.println("************************************************************");
        System.out.println("编号\t\t姓名\t\t性别\t\t出生日期\t\t\t年龄\t\t描述");
        // 遍历集合中的元素
        for (int i = 0; i < list.size(); i++) {
            // 如果参数传入的是存储学生对象的集合,取出来的是学生对象
            // 如果参数传入的是存储老师对象的集合,取出来的是老师对象
            Person p = (Person) list.get(i);
            printPerson(p);
        }
        System.out.println("************************************************************");
    }

    /**
     * 按照指定的格式打印对象
     * @param p
     */
    public static void printPerson(Person p){
        System.out.println(p.getId()+"\t\t"+
                p.getName()+"\t\t"+
                p.getSex()+"\t\t"+
                p.getBirthday()+"\t\t"+
                p.getAge()+"\t\t"+
                p.show()
        );
    }

}
