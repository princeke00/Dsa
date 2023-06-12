package Que;
import java.util.*;

// find the first nonrepeating character in the given string.
public class NonRepChar {
    public static void main(String[] args) {
       String s="ndnfjhldkjndf" ;
       nonReptitng(s);
    }

    public static void nonReptitng(String s){
        int[] freq= new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty() && freq[q.peek()-'a']>1 ){// checking the 1st element in queue if 
                                                         // that is still the 1st non repaeting
                q.remove();// removing it if frequqncy is more than 1.
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else {
                System.out.print( q.peek()+" "); // lastly printing the front of queue as its nonrepating.
                
            }
            
        }
        
    }
}
