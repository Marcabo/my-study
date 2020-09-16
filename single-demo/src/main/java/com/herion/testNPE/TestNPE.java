package com.herion.testNPE;

/**
 * @auther wubo25320
 * @create 2020-09-16 19:16
 */
public class TestNPE {

    public static void main(String[] args) {
        Student student = new Student("12", null);
        System.out.println(student.getName());
    }
}
