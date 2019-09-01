package com.habibi;

public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.setId("habibi");
        student.setName("mohammad");
        student.setMark(100, 0);

        System.out.println(student.getId() + " " + student.name() + " ");
    }


}
