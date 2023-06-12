package GreedyAlgo;

import java.util.*;

public class lexoChar {

    // public static void main(String[] args) {
    // int n = 3; // lenth of characters
    // int k = 25; // sum of characters

    // ArrayList<Character> al = new ArrayList<>();

    // for (int i = 0; i < 26; i++) {
    // al.add((char) (i + 97));
    // }

    // lexicalString(al, n, k);
    // }

    public static void lexicalString(ArrayList<Character> al, int n, int k) {
        String s = "";
        int capacity = k;
        for (int i = 0; i < al.size(); i++) {
            while (s.length() < n) {
                if (capacity > i + 1) {
                    s += al.get(i);
                    capacity -= i + 1;
                }
            }

        }
        System.out.println(s + " " + capacity);
    }

    public static char[] lexo_small(int n, int k){
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for (int i = n - 1; i >= 0; i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                }else {
                    arr[i] = (char)(k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            }else
                break;
            k += i;
        }return arr;
    }

    public static void main(String[] args) {
        int n = 5, k = 42;
        char arr[] = lexo_small(n, k);
        System.out.print(new String(arr));
    }
}
