package com.company.main.array;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * write a program which return the list of string with number 1 to n with following constraint
 * for multiple of 3 store "Fizz"
 * for multiple of 5 store "Buzz
 * for multiple of both 3 and 5 store "Fizz Buzz"
 */
public class FizzBuzzTest {
    public static ArrayList<String> fizzBuzzTest(int n){
        ArrayList<String> ans = new ArrayList<>();
        for(int i =1; i<= n; i++){
            if(i % 15 == 0){
                ans.add("Fizz Buzz");
            }else if(i % 5 == 0){
                ans.add("Buzz");
            }else if(i % 3 == 0){
                ans.add("Fizz");
            }else{
                ans.add(String.valueOf(i));
            }
        }
    return ans;
    }
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Value in the Array are");
        ArrayList<String> result = fizzBuzzTest(num);
        for (String s : result){
            System.out.println(s);
        }
    }
}
