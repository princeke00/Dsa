package Maps;
import java.util.HashMap;

public class LagestSubArrSum {
    // find the largest subarray with sum = 0;
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10,23};
        largestSubArr(arr);
    }

    // we calculate the sum while traversing and putting it in map;
    // then when again same sum occurs, we subtract the value of sum when ocuured 
    // 1st time to the current travesring index
    // logic is when same sum is obtained,the contribution or ramaning array values to sum is 0.
    // hence it form subarray whose sum is 0;
    // len=1st index- current index.
    private static void largestSubArr(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        int sum=0, len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                len=Math.max(len,i-hm.get(sum));
            }else{
                hm.put(sum,i);
            }
        }
        System.out.println(hm);

        System.out.println("len of max subarray is :"+len);
    }

}
