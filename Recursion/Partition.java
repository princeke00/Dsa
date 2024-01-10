package Recursion;

import java.util.ArrayList;

import javax.sql.rowset.spi.SyncResolver;

public class Partition {
    // to make partions in which is valid palindrome
    public static void main(String[] args) {
        String s="aab";
        partition(s);

        Partition p = new Partition();

        System.out.println(p.reverse(-123));
    }

    private static void partition(String s) {

        ArrayList<String> al= new ArrayList<>();        

        for(int i=0;i<s.length();i++){
            String temp="";
            for(int j=i;j<s.length();j++){
                temp+=s.charAt(j);
                System.out.println(temp);
                if(palindrome(temp)){
                    al.add(temp);
                    System.out.println(al);
                }
            }
        }

    }

    private static boolean palindrome(String temp) {
        int l=0,r= temp.length()-1;
        while(l<r){
            if(temp.charAt(l++)!=temp.charAt(r--)) return false;
        }
        return true;     
    }

    public int reverse(int x) {
        long sum=0;
        while(x!=0){
            sum=sum*10+x%10;
            x=x/10;
        }
        if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
            return 0;
        return (int)sum;
    }
}
