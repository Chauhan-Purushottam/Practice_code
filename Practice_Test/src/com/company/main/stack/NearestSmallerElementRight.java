package com.company.main.stack;


import java.util.Scanner;
import java.util.Stack;


public class NearestSmallerElementRight {
    /** This method accept the input as array of integer and find the neares
     * smaller element to the right of each element and return the value for
     * each element
     * @param nums input array of integer
     * @return array of integer having the nearest element of each element in the given array
     */
    public static int[] nearestSmallerElementRight(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            if (stack.empty()) {
                res[i] = -1;
            } else if (nums[i] > stack.peek()) {
                res[i] = stack.peek();
            } else {
                while (!stack.empty() && stack.peek() >= nums[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element");
        int size = sc.nextInt();
        int[] nums = new int[size];
        int index = 0;
        while (index < size) {
            nums[index++] = sc.nextInt();
        }
        int[] res = nearestSmallerElementRight(nums);
        for (int a : res) {
            System.out.println(a);
        }
    }
}
