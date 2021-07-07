package com.company.main.array;


import java.util.HashSet;
import java.util.Scanner;

public class PairSum {
    private static Object IllegalArgumentException = new IllegalArgumentException();

    public static class Pair {
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static Pair pairSum(int[] arr, int sum) throws Throwable {
        int length = arr.length;
        HashSet<Integer> hset = new HashSet<>();
        if(length == 1){
            System.out.println("No pair formed");
            throw (Throwable) IllegalArgumentException;
        }
        for (int j : arr) {
            int diff = sum - j;
            if (hset.contains(diff)) {
                return new Pair(diff, j);
            }
            hset.add(j);
        }
        return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void main(String[] args) throws Throwable {
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Enter number");
        int[] arr = new int[num];
        for(int i =0 ; i< num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the sum value");
        int sum = sc.nextInt();
        System.out.print("Pair whose sum is " + sum + " is " );
        Pair p = pairSum(arr, sum);
        System.out.println("{ " + p.first + ", " + p.second + " }");
    }
}


