package com.company.main.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumAreaHistogram {
    public static class Pair {
        int index;
        int value;


        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static int[] nearestSmallerLeftIndex(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty()) {
                res[i] = -1;
            } else if (nums[i] > stack.peek().value) {
                res[i] = stack.peek().index;
            } else {
                while (!stack.empty() && stack.peek().value >= nums[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek().index;
                }
            }
            stack.push(new Pair(i, nums[i]));
        }
        return res;
    }

    public static int[] nearestSmallerRightIndex(int[] nums) {
        int length = nums.length;
        int pseudoIndex = length;
        int[] res = new int[length];
        Stack<Pair> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            if (stack.empty()) {
                res[i] = pseudoIndex;
            } else if (nums[i] > stack.peek().value) {
                res[i] = stack.peek().index;
            } else {
                while (!stack.empty() && stack.peek().value >= nums[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    res[i] = pseudoIndex;
                } else {
                    res[i] = stack.peek().index;
                }
            }
            stack.push(new Pair(i, nums[i]));
        }
        return res;
    }

    public static int maximunAreaHistogram(int[] nums){
        int[] nearestGreaterLeftIndex = nearestSmallerLeftIndex(nums);
        int[] nearestGreaterRightIndex = nearestSmallerRightIndex(nums);
        System.out.println("Nearest Smaller Left Index ");
        System.out.print("[ ");
        for(int a : nearestGreaterLeftIndex){
            System.out.print(a + " ");
        }
        System.out.print("]\n");
        System.out.println("Nearest Smaller Right Index ");
        System.out.print("[ ");
        for(int a : nearestGreaterRightIndex){
            System.out.print(a + " ");
        }
        System.out.print("]\n");
        int[] area = new int[nums.length];
        for(int i =0; i< nums.length; i++){
            int histogramWidth = nearestGreaterRightIndex[i] - nearestGreaterLeftIndex[i] - 1;
            area[i] = histogramWidth * nums[i];
        }
        System.out.println("Area for each histogram bar is ");
        System.out.print("[ ");
        for(int a : area){
            System.out.print(a + " ");
        }
        System.out.print("]\n");
        int maxArea = Integer.MIN_VALUE;
        for(int a: area){
            if(a > maxArea){
                maxArea = a;
            }
        }
        return maxArea;
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
        System.out.print("Maximum Area is " + maximunAreaHistogram(nums) + "\n");
    }
}
