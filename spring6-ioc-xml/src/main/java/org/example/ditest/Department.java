package org.example.ditest;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private List<Employee> empList;

    private String Dname;

    public void info(){
        System.out.println("部门"+Dname+"参上");
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public void empInfo(){
        for (Employee e :
                empList) {
            System.out.println(e.getName());
        }
    }
}
