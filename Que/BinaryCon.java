package Que;
import java.util.*;

public class BinaryCon {
    public static void main(String[] args) {
        // System.out.println(1/2);
        int n=5;
        binaryCon(n);
    }

    public static void binaryCon(int n){
        Deque<Integer> que = new LinkedList<>();
        for(int i=1;i<=n;i++){
            int q=i,r;
            while(q!=0){
                r=q%2;
                q=q/2;
                que.addFirst(r);  
            }

            while(!que.isEmpty()){
                System.out.print(que.remove());
            }
            System.out.println();
        }
    }
}
