package com.herion.xiaohaosuanfa.theintersectionoftwoarrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 350
 *
 *
 * @auther wubo25320
 * @create 2020-08-21 16:58
 */
public class 两个数组的交集 {

    public static void main(String[] args) {
        两个数组的交集 两个数组的交集 = new 两个数组的交集();
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};

        两个数组的交集.method2(arr1, arr2);
    }

    public void method1(int[] nums1, int[] nums2) {
        List result = new ArrayList<Integer>();
        List skip = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                if (skip.contains(nums2[j])) {
                    continue;
                }

                if (nums2[j] == nums1[i]) {
                    result.add(nums1[i]);
                    skip.add(nums2[j]);
                    break;
                }
            }
        }

        result.forEach(ac -> System.out.println(ac));
    }

    public void method2(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        int index1=0,index2 = 0;
        while (index1<nums1.length-1 || index2<nums2.length-1) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                result.add(num1);
                index1++;
                index2++;
            } else if (num1 > num2) {
                index2++;
            } else if (num1 < num2) {
                index1++;
            }
        }

        result.forEach(ac -> System.out.println(ac));
    }

}
