package com.herion.testNPE;

/**
 * 测试类
 *
 * @auther wubo25320
 * @create 2020-09-18 11:36
 */
public class DeclearClass {

    public static void main(String[] args) {
        int ASM6 = 6 << 16 | 0 << 8;
        System.out.println(ASM6);
    }
}
