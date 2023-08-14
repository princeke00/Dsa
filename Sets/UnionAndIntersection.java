package Sets;
import java.util.ArrayList;
import java.util.HashSet;

public class UnionAndIntersection {

    // to find union and intersection of given arrays.
    public static void main(String[] args) {
        int arr[]={7,3,9};
        int arr1[]={6,3,9,2,9,4};
        union(arr,arr1);
        intersection(arr,arr1);
    }

    // totat number of unique elements in the array 
    private static void union(int arr[],int arr1[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }

        for(int i=0;i<arr1.length;i++){

            hs.add(arr1[i]);
        }

        System.out.println("union of both arrays is :"+hs+" and length is: "+hs.size());
    }

    //number of comman unique elements.
    private static void intersection(int arr[],int arr1[]){
        HashSet<Integer> h= new HashSet<>();
        ArrayList<Integer> al= new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            h.add(arr[i]);
        }
        for(int i=0;i<arr1.length;i++){
            if(h.contains(arr1[i])){
                al.add(arr1[i]);
                h.remove(arr1[i]);
            }
        }
        System.out.println("intersection of both arrays is :"+al+" and size is :"+al.size());
    }
}
