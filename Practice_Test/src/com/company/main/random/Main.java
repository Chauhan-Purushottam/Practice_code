package com.company.main.random;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void print(int[][] nums){
        System.out.println(nums.length);
        for(int i = 0; i < nums.length; i++){
            for(int j =0; j < nums[i].length; j++){
                System.out.println(i + " + " + j + " = " + nums[i][j]);
            }
        }
        nums[4][9] = 20;
    }
    public static void main(String[] args) {
//        ArrayList<Integer> test = new ArrayList<>();
//        for(String s : args){
//            System.out.println(s);
//        }
//        test.add(5);
//        test.add(6);
//        test.add(2);
//        test.add(7);
//        test.add(3);
//        test.add(9);
//        System.out.println(test.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1.intValue() == o2.intValue())
//                    return 0;
//                else if(o1 >= o2){
//                    return 1;
//                }else {
//                    return -1;
//                }
//            }
//        }));
        int [][] nums = new int[5][10];
        for(int i = 0 ; i< 5; i++){
            for(int j = 0; j< 10; j++){
                nums[i][j] = i + j;
            }
        }
        print(nums);
    }
}
