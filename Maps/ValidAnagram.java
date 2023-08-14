package Maps;
import java.util.HashMap;

import java.util.Arrays;

public class ValidAnagram {
    // to check if both the string are anagaram or not
    // ie they should contain same number and value of letter in them.

    public static void main(String[] args) {
        String t="aram";
        String j="mara";

        // System.out.println(isValid(j,t));
        System.out.println(isValid1(t,j));
    }

    private static boolean isValid(String j,String t){
        if(j.length()!=t.length()) return false;

        char a[]=j.toCharArray();
        char b[]=t.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        
        for(int i=0;i<j.length();i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }

    private static boolean isValid1(String t, String j){
        if(t.length()!=j.length()) return false;

        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c= t.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        for(int i=0;i<j.length();i++){
            char c=j.charAt(i);
            if(hm.get(c)!=null){
                if(hm.get(c)==1){
                    hm.remove(c);
                }
                else{
                    hm.put(c,hm.get(c)-1);
                }
            }else return false;
        }
        return hm.isEmpty();
    }
}
