package com.company.main.stack;

import java.util.Scanner;


public class RainWaterTrapping {
    public static int[] maxLeftArray(int[] nums){
        int length = nums.length;
        int[] maxl = new int[length];
        if(length >= 1){
            maxl[0] = nums[0];
            for(int i =1; i<length; i++){
                maxl[i] = Math.max(maxl[i-1], nums[i]);
            }
        }
        return maxl;
    }
    public static int[] maxRightArray(int[] nums){
        int length = nums.length;
        int[] maxr = new int[length];
        if(length >= 1){
            maxr[length-1] = nums[length-1];
            for(int i =length-2; i >= 0; i--){
                maxr[i] = Math.max(maxr[i+1], nums[i]);
            }
        }
        return maxr;
    }

    public static int rainWaterTrapped(int[] nums){
        int[] maxl = maxLeftArray(nums);
        int[] maxr = maxRightArray(nums);
        int[] watertapped = new int[nums.length];
        for(int i =0 ; i< nums.length ; i++){
            watertapped[i] = Math.min(maxl[i], maxr[i]) - nums[i];
        }
        System.out.println("max left of each element is ");
        System.out.print("[ ");
        for(int a : maxl){
            System.out.print(a + " ");
        }
        System.out.print("]\n");
        System.out.println("max right of each element is ");
        System.out.print("[ ");
        for(int a : maxr){
            System.out.print(a + " ");
        }
        System.out.print("]\n");
        System.out.println("water trapped in each building ");
        System.out.print("[ ");
        for(int a : watertapped){
            System.out.print(a + " ");
        }
        System.out.print("]\n");
        int totalWaterTrapped = 0;
        for(int a: watertapped){
            totalWaterTrapped += a;
        }
        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element");
        int size = sc.nextInt();
        int[] nums = new int[size];
        int index = 0;
        while (index < size){
            nums[index++] = sc.nextInt();
        }
        System.out.print("Maximum Area is " + rainWaterTrapped(nums) + "\n");
    }

}
