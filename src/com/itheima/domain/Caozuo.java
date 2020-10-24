package com.itheima.domain;

import com.itheima.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caozuo<T extends Person>{
    private ArrayList<T> datas = new ArrayList<>();
    private void addStudent(Class<T> claz, Scanner sc) {
        // 输入学生信息
        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入性别:");
        String sex = sc.next();
        System.out.println("请输入出生日期:");
        String birthday = sc.next();

        // 创建学生对象
        T stu = null;
        try {
            stu = claz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 把输入的信息赋值给学生对象的属性
        //Utils.id++;// 在这里或者Student类的构造代码块中+1,都行
        stu.setId(Utils.id);
        stu.setName(name);
        stu.setSex(sex);
        stu.setBirthday(birthday);
        stu.setAge(Utils.birthdayToAge(birthday));

        // 把学生对象添加到集合中
        datas.add(stu);

        // 打印提示信息
        System.out.println("添加学生成功");
    }

    // 查询学生
    private void selectStudent() {
        System.out.println("【查询结果：】");
        // 如果没有学生,就显示提示信息
        if (datas.size() == 0) {
            System.out.println("没有数据！");
            return;
        }
        // 如果有学生,就显示所有学生信息
        Utils.printArrayList(datas);
    }

    // 修改学生
    private void updateStudent( Scanner sc) {
        // 获取用户输入的要修改的学生编号
        System.out.println("请输入要修改的学生编号:");
        int id = sc.nextInt();

        // 循环遍历stuList集合
        for (int i = 0; i < datas.size(); i++) {
            // 在循环中,获取遍历出来的学生对象
            T stu = datas.get(i);
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
    private void deleteStudent(Scanner sc) {
        // 获取用户输入的要删除的学生编号
        System.out.println("请输入要删除的学生编号:");
//        int id = sc.nextInt();
        String idStr = sc.next();
        String[] split = idStr.split(",");
        int[] ids = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ids[i] = Integer.valueOf(split[i]);
        }
        ArrayList<T> deleteStudentList = new ArrayList<>();

        for (int k = 0; k < ids.length; k++) {
            int id = ids[k];
            // 循环遍历stuList集合
            for (int i = 0; i < datas.size(); i++) {
                // 在循环中,获取遍历出来的学生对象
                T stu = datas.get(i);
                // 判断遍历出来的学生对象的id和要删除的学生id是否一致
                if (stu.getId() == id) {
                    deleteStudentList.add(stu);
                }
            }
        }

        for (int i = 0; i < deleteStudentList.size(); i++) {
            T stu = deleteStudentList.get(i);
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
                T student = deleteStudentList.get(i);
                datas.remove(student);
            }
            System.out.println("【删除成功】");
        }

        if ("n".equalsIgnoreCase(next)) {
            System.out.println("【删除操作取消】");
        }
        return;// 删除完后,直接结束方法
    }
}
