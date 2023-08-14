package Maps;
import java.util.HashMap;

public class MajorityEle {

    // find the element who appear more than [n/3] times. n is length of array

    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        int l=0,r=arr.length-1,max=Integer.MIN_VALUE;
        while(l!=r){
            if(arr[l]<arr[r]){
                max=arr[r];
                l++;
            }else{
                
                max=arr[l];
                r--;
            }
        }
        System.out.println(max);

        int count[]= new int[max+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>arr.length/3){
                System.out.println(i);
            }
        }

        // majorityele(arr);
    }

    private static void majorityele(int[] arr) {
        HashMap<Integer,Integer> hm= new HashMap<>();

        // for(int i=0;i<arr.length;i++){
        //     if(hm.containsKey(arr[i])){
        //         hm.put(arr[i],hm.get(arr[i])+1);
        //     }else{
        //         hm.put(arr[i],1);
        //     }
        // }

        // alternate of above code
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        System.out.println(hm);

        int x=arr.length/3;
        for(Integer i:hm.keySet()){
            if(hm.get(i)>x){
                System.out.println(i);
            }
        }

    }
}
