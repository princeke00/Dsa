package Maps;

import java.util.HashMap;

public class frequencySortLetter {
    // sort in decreasing order of freqruency of character.

    public static void main(String[] args) {
        String s="acacac";

        String s1=sortChar(s);
        System.out.println(s1);


    }

    private static String sortChar(String s){
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder s2= new StringBuilder();
        for(Character c: hm.keySet()){
            while(hm.get(c)!=0){
                s2.append(c);
                hm.put(c,hm.get(c)-1);
            }
        }
        return s2.toString();
    }
}
