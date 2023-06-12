package Que;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class RevQueue{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i =1;i<=10;i++){
            q.add(i);
        }

        reverseQueue(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }

    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }

    }
}