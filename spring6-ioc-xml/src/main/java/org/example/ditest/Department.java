package org.example.ditest;

public class Department {

    private String Dname;

    public void info(){
        System.out.println("部门"+Dname+"参上");
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }
}
