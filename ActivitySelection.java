/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activityselection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author purushottam
 */
public class ActivitySelection {

    /**
     * @param args the command line arguments
     */
    public static Comparator<Activity> sort_by_finishtime = new Comparator<Activity>(){
        @Override
        public int compare(Activity t, Activity t1) {
            return(t.finish-t1.finish);
        }    
        
    };
    
    public static class Activity{
       private int start;
       private int finish;
       Activity(int start,int finish){
           this.start = start;
           this.finish = finish;
       }
    }
    
   static void max_activity_selection(Activity []activity,int n){
        int i = 0;
        System.out.println("Activity selected are :- ");
        System.out.println("( "+activity[i].start+","+activity[i].finish+" )");
        for(int j =1;j<n;j++){
            if(activity[j].start>=activity[i].finish){
              System.out.println("( "+activity[j].start+","+activity[j].finish+" )"); 
              i = j;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter the number of Activity ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter Start time and Finish time of the activity ");
        Activity []activity = new Activity[n];
        for(int i =0;i<n;i++)
        {
            activity[i] = new Activity(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(activity,sort_by_finishtime);
        max_activity_selection(activity,n);
        
    }
    
}
