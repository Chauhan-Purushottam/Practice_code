package com.company.main.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumAreaInBinaryMatrix {

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
        int[] res = new int[length];
        Stack<Pair> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            if (stack.empty()) {
                res[i] = length;
            } else if (nums[i] > stack.peek().value) {
                res[i] = stack.peek().index;
            } else {
                while (!stack.empty() && stack.peek().value >= nums[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    res[i] = length;
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

    public static int maxAreaInBinaryMatrix(int[][] nums){
        int rows = nums.length;
        int columns = rows> 0 ? nums[0].length : 0;
        int[] matrix_val = new int[columns];
        System.out.println("number of rows " + rows + "\n number of columns " + columns);
        int maxArea = Integer.MIN_VALUE;
        for(int i =0; i< rows; i++){
            for(int j = 0; j< columns; j++){
                matrix_val[j] = nums[i][j] == 1 ? (matrix_val[j] + 1) : 0;
            }
            int area = maximunAreaHistogram(matrix_val);
            System.out.println("Max area for " + i + "th row is "+ area);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    /**
     *          0 1 1 0
     *          1 1 1 1       ans  = 8
     *          1 1 1 1
     *          1 1 0 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row of matrix");
        int rows = sc.nextInt();
        System.out.println("Enter the columns of matrix");
        int columns = sc.nextInt();
        int[][] nums = new int[rows][columns];
        for(int i =0; i< rows; i++){
            for(int j= 0; j< columns; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.print("Maximum Area is " + maxAreaInBinaryMatrix(nums) + "\n");
    }
}
