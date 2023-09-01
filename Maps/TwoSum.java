package Maps;
import java.util.HashMap;

public class TwoSum {

    // to find 2 index whose sum equals to target 
    public static void main(String[] args) {
        int arr[]= {3,2,4};
        int target=6;


        // for(int i=0;i<arr.length-1;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]+arr[j]==target){
        //             System.out.println(i+" "+j);
        //         }
        //     }
        // }

        int[] a=twoSum(arr,target);
        for(int i:a){
            System.out.print(i+" ");
        }

    }

    private static int[] twoSum(int[] arr,int target) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(target-arr[i])){
               return new int[]{i,hm.get(target-arr[i])} ;
            }
            hm.put(arr[i],i);
        }
        return new int[2];
    }
}
