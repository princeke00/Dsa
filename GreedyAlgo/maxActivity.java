package GreedyAlgo;
import java.util.*;

public class maxActivity {

    // find the maximum actitvies tha can be performed
    // given that activites are sorted onth basis of end time
    // approch is greedy alog. ie to perform as many task.
    public static void main(String[] args) {
        // int[] start= {1,3,0,5,8,5};
        // int[] end  = {2,4,6,7,9,9};
        int[] start= {0,1,3,5,5,8};
        int[] end  = {6,2,4,7,9,9};


        // given that activites sorted on start time. sort them according to end time. 
        int [][]activites=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activites[i][0]=i;
            activites[i][1]=start[i];
            activites[i][2]=end[i];
        }

        Arrays.sort(activites,Comparator.comparingDouble(o->o[2]));
        
        // maxJob(start,end);
        System.out.println();
        maxJobUnsorted(activites, end);
    }

    // 
    public static void maxJob(int[] start, int[] end){
        ArrayList<Integer> al = new ArrayList<>();
        int max=1;
        al.add(0);
        int lastEnd=end[0];
        for(int i=1;i<end.length;i++){
            if(start[i]>= lastEnd){
                al.add(i);
                lastEnd=end[i];
            }
        }

        System.out.println("total no task performed is"+max);
        for(int i=0;i<al.size();i++){
            System.out.print("A"+al.get(i)+" ");
        }
    }

    public static void maxJobUnsorted(int [][]activites,int[] end){
        ArrayList<Integer> al = new ArrayList<>();
        int max=1;
        al.add(activites[0][0]);
        int lastEnd=activites[0][2];
        for(int i=1;i<activites.length;i++){
            if(activites[i][1]>= lastEnd){
                max++;
                al.add(activites[i][0]);
                lastEnd=activites[i][2];
            }
        }

        System.out.println("total no task performed is"+max);
        for(int i=0;i<al.size();i++){
            System.out.print("A"+al.get(i)+" ");
        }
    }
}

