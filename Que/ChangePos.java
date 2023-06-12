package Que;
import java.util.*;
public class ChangePos {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=10;i++){
            que.add(i*10);
        }
        int k=5;
        update(que,k);
    }

    public static void update(Queue<Integer> que,int k){
        Stack<Integer> st =  new Stack<>();
        for(int i=0;i<k;i++){
            st.push(que.remove()) ;
        }
        Queue<Integer> queue = new LinkedList<>();
        while(!st.isEmpty()){
            queue.add(st.pop());
        }

        while(!que.isEmpty()){
            queue.add(que.remove());
        }
        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }
    }
}
