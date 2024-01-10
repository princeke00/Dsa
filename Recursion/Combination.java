package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static List< List < Integer > > combSum(int []ARR, int B) {
        // Write your code here.

        List<List<Integer>> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        combination(ARR,B,list1,list2,0);
        return list1;
    }

    public static void combination(int[] arr,int b,List<List<Integer>> list1, List<Integer> list2,int idx){
        // base case
        if(idx==arr.length){
            if(b==0){
                list1.add(new ArrayList<>(list2));
                // return;
            }
            return;
        }
        if(arr[idx]<=b){      
            list2.add(arr[idx]);
            combination(arr,b-arr[idx],list1,list2,idx);
            list2.remove(list2.size()-1);
        }
        combination(arr,b,list1,list2,idx+1);


    }

    public static void main(String[] args) {
        int []arr={4,17,12,5};
        System.out.println(combSum(arr, 9));
    }
}
