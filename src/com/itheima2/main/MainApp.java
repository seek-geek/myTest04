package com.itheima2.main;

import com.itheima2.domain.Person;
import com.itheima2.domain.Student;
import com.itheima2.domain.Teacher;
import com.itheima2.utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：pengzhilin
 * @Date: 2020/8/13 10:43
 */
public class MainApp {
    // ctrl+shift+ -  收缩代码
    public static void main(String[] args) {
        // 定义一个集合,用来存储所有的学生对象
        ArrayList<Student> stuList = new ArrayList<>();

        // 定义一个集合,用来存储所有的老师对象
        ArrayList<Teacher> teaList = new ArrayList<>();

        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);

        // 一级菜单需要循环生成--死循环  ctrl+alt+t
        while (true) {
            System.out.println("1.学生信息管理系统   2.教师信息管理系统   3.系统退出");
            System.out.println();
            System.out.println("请输入要功能序号:");
            int op = sc.nextInt();
            // 根据用户输入的功能序号,进入对应的功能
            switch (op) {
                case 1:
                    // 进入学生信息管理系统
                    studentManager(stuList, sc);
                    break;
                case 2:
                    // 进入教室信息管理系统
                    teacherManager(teaList, sc);
                    break;
                case 3:
                    // 系统退出
                    System.out.println("感谢使用,欢迎下次再来,拜拜!");
                    System.exit(0);
                default:
                    System.out.println("您输入有误,请重新输入!");
                    break;
            }
        }
    }

    /**
     * 二级菜单学生信息管理
     *
     * @param stuList
     * @param sc
     */
    private static void studentManager(ArrayList<Student> stuList, Scanner sc) {
        // 死循环
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("【学生信息管理：】");
            System.out.println("1.添加学生  2.查询学生  3.修改学生  4.删除学生  5.返回");
            System.out.println();
            System.out.println("请输入功能序号:");
            int op = sc.nextInt();
            // 判断
            switch (op) {
                case 1:
                    // 添加学生
                    addStudent(stuList, sc);
                    break;
                case 2:
                    // 查询学生
                    selectStudent(stuList, sc);
                    break;
                case 3:
                    // 修改学生
                    updateStudent(stuList, sc);
                    break;
                case 4:
                    // 删除学生
                    deleteStudent(stuList, sc);
                    break;
                case 5:
                    // 返回到一级菜单
                    return;// 结束学生信息管理的方法
                default:
                    System.out.println("您输入有误,请重新输入!");
                    break;
            }
        }
    }

    /**
     * 删除学生信息
     *
     * @param stuList
     * @param sc
     */
    private static void deleteStudent(ArrayList<Student> stuList, Scanner sc) {

    }

    /**
     * 修改学生信息
     *
     * @param stuList
     * @param sc
     */
    private static void updateStudent(ArrayList<Student> stuList, Scanner sc) {
        // 1.输入要修改的学生的编号
        System.out.println("请输入要修改的学生ID:");
        int sid = sc.nextInt();

        // 2.判断该学生的编号释放存在

        // 2.1 循环遍历stuList集合
        for (int i = 0; i < stuList.size(); i++) {
            // 2.2 在循环中,获取遍历出来的学生对象
            Student stu = stuList.get(i);
            // 2.3 判断该学生的编号是否存在
            if (stu.getId() == sid) {
                // 存在,就修改(保留原值的功能),修改完了,就结束方法
                System.out.println("【查询结果】要修改的学生信息：");
                System.out.println("************************************************************");
                System.out.println("编号\t\t姓名\t\t性别\t\t出生日期\t\t\t年龄\t\t描述");
                Utils.printPerson(stu);
                System.out.println("************************************************************");

                // 修改
                System.out.println("请输入新姓名（保留原值输入0）：");
                String name = sc.next();
                System.out.println("请输入新性别（保留原值输入0）：");
                String sex = sc.next();
                System.out.println("请输入新出生日期（保留原值输入0）：");
                String birthday = sc.next();

                if (!"0".equals(name)) {
                    // 要修改
                    stu.setName(name);
                }

                if (!"0".equals(sex)) {
                    // 要修改
                    stu.setSex(sex);
                }

                if (!"0".equals(birthday)) {
                    // 要修改
                    stu.setBirthday(birthday);
                    stu.setAge(Utils.getAge(birthday));
                }

                System.out.println("【成功】学生信息修改成功！");
                return;
            }
        }


        // 程序来到这里,说明没有找到要修改的学生ID
        System.out.println("【错误】学生ID:" + sid + "没有找到");

    }

    /**
     * 查询学生信息
     *
     * @param stuList
     * @param sc
     */
    private static void selectStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("【查询结果：】");
        // 如果没有学生信息，就显示没有学生信息
        if (stuList.size() == 0) {
            System.out.println("没有学生信息！");
            return;// 结束方法
        }
        // 如果有，就直接显示
        Utils.printArrayList(stuList);
    }

    /**
     * 添加学生信息
     *
     * @param stuList
     * @param sc
     */
    private static void addStudent(ArrayList<Student> stuList, Scanner sc) {
        // 输入学生信息
        System.out.println("请输入学员姓名:");
        String name = sc.next();
        System.out.println("请输入性别:");
        String sex = sc.next();
        System.out.println("请输入出生日期(yyyy-MM-dd):");
        String birthday = sc.next();

        // 创建学生对象,设置学生信息
        Student stu = new Student();
        stu.setId(Utils.sid);
        stu.setName(name);
        stu.setSex(sex);
        stu.setBirthday(birthday);
        stu.setAge(Utils.getAge(birthday));

        // 添加学生到集合中
        stuList.add(stu);
        System.out.println("【成功】学生信息添加成功！");
    }

    /**
     * 二级菜单 教师信息管理
     *
     * @param teaList
     * @param sc
     */
    private static void teacherManager(ArrayList<Teacher> teaList, Scanner sc) {

    }


    // 测试工具类中打印集合和打印Person对象的方法
    private static void method02() {
        // 创建集合,限制集合中元素的类型为Student类型
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student(1, "张三", "男", "1999-01-01", 21);
        Student stu2 = new Student(2, "李四", "男", "1999-01-01", 21);
        Student stu3 = new Student(3, "王五", "男", "1999-01-01", 21);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        Utils.printArrayList(list);

        //Utils.printPerson(stu1);


        // 创建集合,限制集合中元素的类型为Student类型
        //ArrayList<Teacher> list2 = new ArrayList<>();
        //Utils.printArrayList(list2);

        // 泛型没有多态
        //ArrayList<Person> list3 = new ArrayList<Student>();// 编译报错
        //ArrayList list3 = new ArrayList<Student>();
    }

    /**
     * 测试根据出生日期计算年龄的方法
     */
    private static void method01() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入出生日期,格式为yyyy-MM-dd:");
            String birthday = sc.next();
            System.out.println(Utils.getAge(birthday));
        }
    }
}
