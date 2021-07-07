package com.company.main.random;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> res = new ArrayList<>(A);
        for(int index = 0; index < A; index ++){
            res.add(0);
        }
        for(ArrayList<Integer> i : B){
            int first = i.get(0);
            int last = i.get(1);
            int amt = i.get(2);
            for(int j = first-1; j< last; j++){
                int val = res.get(j);
                res.set(j, ( val + amt));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  arr = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(10);
        ArrayList<Integer> l1 = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(10);
        ArrayList<Integer> l2 = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(10);
        arr.add(l);
        ArrayList<Integer> res = solve(5, arr);
        for(int i : res){
            System.out.println(i);
        }


    }
}
