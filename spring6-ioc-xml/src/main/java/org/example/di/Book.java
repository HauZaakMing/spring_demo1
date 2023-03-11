package org.example.di;

public class Book {
    private String name;
    private String author;

    private String otherString;



    public void setOtherString(String otherString) {
        this.otherString = otherString;
    }

    public Book() {
        System.out.println("执行无参构造器");
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", otherString='" + otherString + '\'' +
                '}';
    }

    public Book(String name, String author) {
        System.out.println("执行有参构造器");
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
