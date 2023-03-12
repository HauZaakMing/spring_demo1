package org.example.ditest;

public class Employee {

    private Department dept;
    private String name;
    private int age;

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
        System.out.println(name+"今年"+age+"岁，"+"开始工作");
    }

    public void show(){
        dept.info();
        System.out.println(name+"是"+dept.getDname()+"的人");
    }
}
