package com.habibi;

public class Student {

    private String name;
    private String id;
    private int mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark1, int mark2) {
        this.mark = mark1 + mark2;
    }
}
