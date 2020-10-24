package com.itheima.main;

import com.itheima.domain.Student;
import com.itheima.domain.Teacher;
import com.itheima.utils.Utils;
import com.itheima2.domain.Person;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：pengzhilin
 * @Date: 2020/6/14 9:24
 */
public class MainApp {
    public static void main(String[] args) {

        // 创建一个ArrayList集合,用来存储所有的学生对象
        ArrayList<Student> stuList = new ArrayList<>();

        // 创建一个ArrayList集合,用来存储所有的老师对象
        ArrayList<Teacher> teaList = new ArrayList<>();

        // 创建Scanner对象,获取用户输入的选择项
        Scanner sc = new Scanner(System.in);

        // 制作主菜单(一级菜单)
        while (true) {
            System.out.println("1. 学生信息管理   2. 教师信息管理   3. 系统退出");

            System.out.println("请选择菜单:");
            int op = sc.nextInt();
            // 根据用户输入的选项,进入对应的系统
            switch (op) {
                case 1:
                    // 进入学生信息管理
                    studentManage(stuList, sc);
                    break;
                case 2:
                    // 进入教师信息管理
                    teacherMange(teaList, sc);
                    break;
                case 3:
                    // 系统退出
                    System.out.println("谢谢您,欢迎下次使用!");
                    System.exit(0);
                default:
                    System.out.println("你输入有误,请重新输入!");
                    break;
            }
        }

    }

    // 学生信息管理
    private static void studentManage(ArrayList<Student> stuList, Scanner sc) {
        // 制作二级菜单
        while (true) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("【学生信息管理】");
            System.out.println("1.添加学生  2.查询学生  3.修改学生  4.删除学生  5.返回");
            System.out.println();
            System.out.println("请输入功能序号:");
            int op = sc.nextInt();
            // 根据选择的功能序号,进入对应的功能模块
            switch (op) {
                case 1:
                    // 添加学生
                    addStudent(stuList, sc);
                    break;
                case 2:
                    // 查询学生
                    selectStudent(stuList);
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
                    // 返回;
                    return;
                default:
                    System.out.println("您输入有误,请重新输入!");
                    break;
            }
        }
    }

    // 添加学生
    private static void addStudent(ArrayList<Student> stuList, Scanner sc) {
        // 输入学生信息
        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入性别:");
        String sex = sc.next();
        System.out.println("请输入出生日期:");
        String birthday = sc.next();

        // 创建学生对象
        Student stu = new Student();

        // 把输入的信息赋值给学生对象的属性
        //Utils.id++;// 在这里或者Student类的构造代码块中+1,都行
        stu.setId(Utils.id);
        stu.setName(name);
        stu.setSex(sex);
        stu.setBirthday(birthday);
        stu.setAge(Utils.birthdayToAge(birthday));

        // 把学生对象添加到集合中
        stuList.add(stu);

        // 打印提示信息
        System.out.println("添加学生成功");
    }

    // 查询学生
    private static void selectStudent(ArrayList<Student> stuList) {
        System.out.println("【查询结果：】");
        // 如果没有学生,就显示提示信息
        if (stuList.size() == 0) {
            System.out.println("没有数据！");
            return;
        }
        // 如果有学生,就显示所有学生信息
        Utils.printArrayList(stuList);
    }

    // 修改学生
    private static void updateStudent(ArrayList<Student> stuList, Scanner sc) {
        // 获取用户输入的要修改的学生编号
        System.out.println("请输入要修改的学生编号:");
        int id = sc.nextInt();

        // 循环遍历stuList集合
        for (int i = 0; i < stuList.size(); i++) {
            // 在循环中,获取遍历出来的学生对象
            Student stu = stuList.get(i);
            // 在循环中,判断遍历出来的学生对象的id和输入的id是否一致,如果一致,就修改,否则就提示错误信息
            if (stu.getId() == id) {
                // 修改
                // 输入要修改的信息
                System.out.println("请输入新的姓名，保留原值请输入0:");
                String name = sc.next();
                System.out.println("请输入新的性别,保留原值请输入0:");
                String sex = sc.next();
                System.out.println("请输入新的出生日期,保留原值请输入0:");
                String birthday = sc.next();

                // 判断输入的信息
                if (!"0".equals(name)) {
                    stu.setName(name);// 修改姓名
                }

                if (!"0".equals(sex)) {
                    stu.setSex(sex);// 修改性别
                }

                if (!"0".equals(birthday)) {
                    stu.setBirthday(birthday);// 修改出生日期
                    stu.setAge(Utils.birthdayToAge(birthday));// 修改年龄
                }

                System.out.println("恭喜您,修改成功!");
                return;// 改完了直接结束方法
            }
        }

        // 能来到这里,说明没有找到
        System.out.println("【错误】ID:" + id + "不存在,修改失败!");

    }

    // 删除学生
    private static void deleteStudent(ArrayList<Student> stuList, Scanner sc) {
        // 获取用户输入的要删除的学生编号
        System.out.println("请输入要删除的学生编号:");
//        int id = sc.nextInt();
        String idStr = sc.next();
        String[] split = idStr.split(",");
        int[] ids = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ids[i] = Integer.valueOf(split[i]);
        }
        ArrayList<Student> deleteStudentList = new ArrayList<>();

        for (int k = 0; k < ids.length; k++) {
            int id = ids[k];
            // 循环遍历stuList集合
            for (int i = 0; i < stuList.size(); i++) {
                // 在循环中,获取遍历出来的学生对象
                Student stu = stuList.get(i);
                // 判断遍历出来的学生对象的id和要删除的学生id是否一致
                if (stu.getId() == id) {
                    deleteStudentList.add(stu);
                }
            }
        }

        for (int i = 0; i < deleteStudentList.size(); i++) {
            Student stu = deleteStudentList.get(i);
            // 删除
            // 打印要删除的学生信息
            if (i == 0) {
                System.out.println("**************************************************************************");
                System.out.println("【您要删除的学生信息如下：】");
                System.out.println("编号\t\t姓名\t\t性别\t\t生日\t\t\t\t年龄\t\t描述");
            }
            Utils.printPerson(stu);
            if (i == deleteStudentList.size() - 1) {
                System.out.println("**************************************************************************");
            }
            // 让用户确认是否删除
        }
        System.out.println("【确认】您确定要删除这些学生信息吗?（y/n）");
        String next = sc.next();

        // 根据用户的选择,进行操作
        if ("y".equalsIgnoreCase(next)) {
            // 删除
//                stuList.remove(i);
            for (int i = 0; i < deleteStudentList.size(); i++) {
                Student student = deleteStudentList.get(i);
                stuList.remove(student);
            }
            System.out.println("【删除成功】");
        }

        if ("n".equalsIgnoreCase(next)) {
            System.out.println("【删除操作取消】");
        }
        return;// 删除完后,直接结束方法
    }

// 来到这里,说明要删除的学生编号不存在
//        System.out.println("【错误】ID:"++"不存在,删除失败!");

    // 教师信息管理
    private static void teacherMange(ArrayList<Teacher> teaList, Scanner sc) {

    }

    // 测试工具类方法的代码
    private static void method01() {
        Student stu = new Student(1, "李四", "女", "1999-03-03", Utils.birthdayToAge("1999-03-03"));
        Teacher tea = new Teacher(1, "李四", "女", "1999-03-03", Utils.birthdayToAge("1999-03-03"));
        // 测试打印Person对象
        Utils.printPerson(stu);
        Utils.printPerson(tea);

        // 测试打印集合所有元素
        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(stu);
        Utils.printArrayList(list1);

        System.out.println("=======================");

        ArrayList<Teacher> list2 = new ArrayList<>();
        list2.add(tea);
        Utils.printArrayList(list2);
    }
}
