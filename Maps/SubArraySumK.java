package Maps;

import java.util.HashMap;

public class SubArraySumK {
    // count the number of subarray whose sum is equal to k.

    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k=-10;

        // logic
        // sum(j)-sum(i)=sum(i+1;j)
        // => sum(j)-sum(i-1)=sum(i,j)
        // => sum(j)-sum(i)=k ie sum is equal to k when we subtract subarray sum of j from subarray sum of i
        // => sum(j)-k=sum(i)

        int sum=0,count=0;
        
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
}
