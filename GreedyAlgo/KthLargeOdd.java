package GreedyAlgo;

import java.util.ArrayList;

public class KthLargeOdd {
    // to find the kth largest odd number.
    
    public static void main(String[] args) {
        int l = -3, r = 3;
        // int []arr={-3,3};
        int k = 4;
        // System.out.println( kthOdd(arr, k));

        ArrayList<Integer> al = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            if ((i & 1) > 0) {
                al.add(i);
            }

        }
        if (k > al.size()) {
            System.out.println(0);
        } else {
            // int j = 0;
            // for (int i = al.size() - 1; i > -1; i--) {
            //     j++;
            //     int number = al.get(i);
            //     if (j == k) {
            //         System.out.println(number);
            //     }
            System.out.println(al.get(al.size()-k));
        }
    }
    

    public static int kthOdd(int[] range, int K) {
        if (K <= 0)
            return 0;
        int L = range[0];
        int R = range[1];
        if ((R & 1) > 0) {
            int Count = (R - L ) / 2+ 1;
            if (K > Count)
                return 0;
            else return(R - 2 * K + 2);
        } else {
            int Count = (R - L + 1) / 2;
            if (K > Count)
                return 0;
            else return(R - 2 * K + 1);
        }
    }
}
