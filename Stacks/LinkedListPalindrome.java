package Stacks;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        LinkedList<Integer> ll =  new LinkedList<>();
        ll.add(1);ll.add(2); ll.add(3); ll.add(4);
        ll.add(3); ll.add(2); ll.add(1);

        System.out.println(isPalindrome(ll));

    }

    public static boolean isPalindrome(LinkedList<Integer> ll){
        Stack<Integer> st = new Stack<>();
        Iterator<Integer> it= ll.iterator();
        while(it.hasNext()){
            st.push((Integer) it.next());
        }
        it= ll.iterator();
        while(!st.isEmpty() && it.hasNext()){
            if(it.next()!=st.pop()) return false;
           
        }
        return true;
    }
}
