package com.company.main.stack;


import java.util.Scanner;
import java.util.Stack;

/**
 * The span of the stock's price today is defined as the maximum number of
 * consecutive days (starting from today and going backwards) for
 * which the price of the stock was less than or equal to today's price.
 * Input - [100, 80, 60, 70, 60, 75, 85]
 * Output - [1, 1, 1, 2, 1, 4, 6]
 */

public class StockSpan {
    public static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int[] stockSpan(int[] nums){
        int length = nums.length;
        int[] res = new int[length];
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i<length; i++){
            if(stack.empty()){
                res[i] = -1;
            }else if(nums[i] < stack.peek().value){
                res[i] = stack.peek().index;
            }else{
                while(!stack.empty() && nums[i] >= stack.peek().value){
                    stack.pop();
                }
                if(stack.empty()){
                    res[i] = -1;
                }
                else {
                    res[i] = stack.peek().index;
                }
            }
            stack.push(new Pair(nums[i], i));
        }
        for(int i =0; i< length ; i++){
            res[i] = i - res[i];
        }
        return res;
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
        int[] res = stockSpan(nums);
        System.out.println("stock span for the above input is ");
        System.out.print("[ ");
        for(int a : res){
            System.out.print(a + " ");
        }
        System.out.print("]");
    }


}
