package Que;
import java.util.Queue;
import java.util.LinkedList;

// interleave the elements of queue of evene length.
public class InterLeave {
    public static void main(String[] args) {
        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<=10;i++){
            q.add(i);
        }

        mixUpQueueEle(q);

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }

    public static void mixUpQueueEle(Queue<Integer> q){
        Queue<Integer> newQueue= new LinkedList<>();
        int len=q.size();
        for(int i=0;i<len/2;i++){
            newQueue.add(q.remove());
        }

        while(!newQueue.isEmpty()){
            q.add(newQueue.remove());
            q.add(q.remove());
        }
    }
}
