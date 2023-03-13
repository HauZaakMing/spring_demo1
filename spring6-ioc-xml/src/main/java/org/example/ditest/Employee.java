package org.example.ditest;

import java.util.Arrays;

public class Employee {

    private Department dept;
    private String name;
    private int age;

    private String[] hobby;

    public Employee() {
        System.out.println("开始创建机器人小猪");
    }

    public Employee(Department dept, String name) {
        System.out.println("有参构造，启动！");
        this.dept = dept;
        this.name = name;
    }

    public void initmethod(){
        System.out.println("调用初始化方法");
    }

    public void destroyMethod(){
        System.out.println(this.name+"被干掉了");
    }

    //    @Override
//    public String toString() {
//        return "Employee{" +
//                "dept=" + dept +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", hobby=" + Arrays.toString(hobby) +
//                '}';
//    }



    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void work(){
        System.out.println(name+"今年"+age+"岁，"+"开始工作"+"=================");
    }

    public void show(){
        dept.info();
        System.out.println(name+"是"+dept.getDname()+"的人");
    }
}
