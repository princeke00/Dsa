import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class sample {
    public static void main(String[] args) {
        String s="21474836460";
        // char[] c= s.toCharArray();
        // for(int i=0;i<c.length;i++){
        //     c[i]=c[(i+c.length-1)%c.length];
        //     printcC(c);
        // }
        System.out.println(myAtoi(s)); 
    }

    private static void printcC(char[] c) {
        for(char i: c){
            System.out.print(i);
        }
        System.out.println();
    }
    public static int myAtoi(String s) {
        int i=0,minus=1;
        long num=0;
        while(i<s.length() && s.charAt(i)==' ')i++;
        if(i<s.length()&& s.charAt(i)=='-'|| s.charAt(i)=='+'){
            if(s.charAt(i++)=='-') minus=-1;
        }
        while(i<s.length()&& (s.charAt(i)>='0' && s.charAt(i)<='9')){
            int a=s.charAt(i)-'0';
            num=num*10+a;
            if(num>Integer.MAX_VALUE ||num<Integer.MIN_VALUE){
                return minus==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)num*minus;
        
    }
}
