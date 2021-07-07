package com.company.main.array;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Given N shops on a number line positioned from 1 to N
 * M customer visit the shops from l to r inclusive
 * Find the 3 most popular shops (most popular shops are the shops where maximum customer has visit)
 *
 * Input :
 * First line t (number of testcases)
 * 2nd Line N, M (number of shops and customer)
 * next M line (l, r)
 * */
class Shops implements Comparable<Shops> {
    int customerVisitCount;
    int shopNumber;

    Shops(int shopNumber, int customerVisitCount){
        this.shopNumber = shopNumber;
        this.customerVisitCount = customerVisitCount;
    }
    @Override
    public int compareTo(@NotNull Shops o) {
        if(customerVisitCount - o.customerVisitCount == 0){
            return shopNumber - o.shopNumber;
        }else{
            return customerVisitCount - o.customerVisitCount ;
        }

    }
}
public class MostPopularShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while(testCase-- > 0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int []arr = new int[N];
            for(int i = 0; i< M; i++){
                int l = sc.nextInt();
                int r = sc.nextInt();
                arr[l-1] += 1;
                if(r < N){
                    arr[r] -= 1;
                }
            }
            for(int i =1; i< N; i++){
                arr[i] += arr[i-1];
            }
            PriorityQueue<Shops> pq = new PriorityQueue<>();

            for(int i =0; i< N; i++){
                System.out.println("***************************************************************");
                if(pq.size() < 3){
                    pq.add(new Shops(i, arr[i]));
                }else{
                    System.out.println("------------------------------------------------------------");
                    assert pq.peek() != null;
                    System.out.println("peek ->" + pq.peek().customerVisitCount);
                    assert pq.peek() != null;
                    if(pq.peek().customerVisitCount < arr[i]){
                        System.out.println("Pq value -> " + pq.peek().shopNumber);
                        pq.poll();
                        pq.add(new Shops(i, arr[i]));
                    }
                }
                for(Shops s : pq){
                    System.out.println(s.shopNumber + "----> " + s.customerVisitCount);
                }

            }
            while(pq.size() > 0){
                System.out.println(pq.peek().shopNumber);
                pq.remove();
            }
        }
    }

}
