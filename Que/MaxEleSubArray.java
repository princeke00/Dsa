package Que;
import java.util.Queue;
import java.util.LinkedList;
// import java.util.PriorityQueue;

public class MaxEleSubArray {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 1, 4, 5, 2, 3, 2 };

        maxEleInSubArray(arr);
    }

    public static void maxEleInSubArray(int[] arr){
        Queue<Integer> que = new LinkedList<>();
        // PriorityQueue<Integer> pq= new PriorityQueue<>(0, null)
        int len=arr.length;
        int max=0;
        que.add(arr[0]);
        que.add(arr[1]);

        for(int i=2;i<len;i++){
            while(que.size()!=3){
                que.add(arr[i]);
                max=Math.max(max,arr[i]);
            }
            System.out.print(max+" ");
            que.remove();
        }
    }
}
