package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArraySumK {
    // count the number of subarray whose sum is equal to k.

    public static void main(String[] args) {
        int arr[] = {10,2,2,20,10};
        int k=10;

        // logic
        // sum(j)-sum(i)=sum(i+1;j)
        // => sum(j)-sum(i-1)=sum(i,j)
        // => sum(j)-sum(i)=k ie sum is equal to k when we subtract subarray sum of j from subarray sum of i
        // => sum(j)-k=sum(i)

        int sum=0,count=0;

        // System.out.println(subarraysWithSumK(arr,k));
        
        HashMap<Integer,Integer> hm= new HashMap<>();

        // we need to add (0,1) because what if the sum of array is euqals to k;
        // then when we subtract k-k will result true.
        hm.put(0,1);

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum-k)){
                count+= hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        System.out.println(count+" subarrays whose sum is :"+k);

    }

     public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        // Write your code here
        // List<List<Integer>> list= new ArrayList<>();
        // List<Integer> li= new ArrayList<>();
        // int j=0,sum=0;
        // for(int i=0;i<a.length;i++){
        //     sum+=a[i];
        //     li.add(a[i]);
        //     while(sum>k){
        //         sum-=a[j];
        //         li.remove(Integer.valueOf(a[j]));
        //         j++;
        //     }
        //     if(sum==k){
        //         list.add(new ArrayList<>(li));
        //     }
        // }
        // // subArraySum(0,a,sum,list,new ArrayList());
        // return list;

        List<List<Integer>> list= new ArrayList<>();
        List<Integer> li= new ArrayList<>();
        int j=0,sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            li.add(a[i]);
            while(sum>k){
                sum-=a[j];
                li.remove(Integer.valueOf(a[j]));
                j++;
            }
            if(sum==k){
                list.add(new ArrayList<>(li));
            }
        }
        // subArraySum(0,a,sum,list,new ArrayList());
        return list;
    
    }
}
