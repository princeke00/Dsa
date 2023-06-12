package GreedyAlgo;
import java.util.*;

public class MinSumDifference {
    // make the pair of element from both arrays such that their absolute idffrence sum be minimum;
    public static void main(String[] args) {
        int[] a = {4,1,8,7};
        int[] b = {2,3,6,5};

        System.out.println("minsum is :"+minSum(a,b));
    }

    public static int minSum(int[]a, int[] b){
        int minsum=0;
        Arrays.sort(a);// we know the number gives minium diffrence when thr second element is near 
        Arrays.sort(b);// or equal to the number. there for approching the greedy way and sorting both the aarays.
                       

        for(int i=0;i<a.length;i++){
            minsum += Math.abs(a[i] - b[i]);
        }
        return minsum;
    }
}
