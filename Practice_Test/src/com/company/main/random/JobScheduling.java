/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author purushottam
 */
public class JobScheduling {
    
    public static class Job{
        String id;
        int deadline;
        int profit;
        Job(String id,int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
}
    
    public static Comparator<Job> sortByprofit = new Comparator<Job>(){
        @Override
        public int compare(Job t, Job t1) {
            return t1.profit-t.profit;
        }
        
    };
    
    public static void print_scheduledjob(Job []job ,int n){
        String []result = new String[n];
        boolean []slot = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j = ((int)Math.min(n,job[i].deadline))-1;j>=0;j--){
                if(!slot[j]){
                    result[j] = job[i].id;
                    slot[j]=true;
                    break;
                }
            }
        }
        for(String a : result){
            System.out.println(a);
        }       
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the number of Job :- ");
            int n = sc.nextInt();
            Job []job = new Job[n];
            for(int i =0;i<n;i++){
                job[i] = new Job(sc.next(),sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(job,sortByprofit);
            System.out.println("Job after sorting by profit :-");
            for(Job j: job){
                System.out.println(j.id+" "+j.deadline+" "+j.profit);
            }
            print_scheduledjob(job,n);
            
        }
    }
    
}
