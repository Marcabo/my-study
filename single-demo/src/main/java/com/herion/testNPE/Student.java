package com.herion.testNPE;

/**
 * 学生类
 *
 * @auther wubo25320
 * @create 2020-09-16 19:15
 */
public class Student {

    private String id;

    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
