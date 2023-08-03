package Heaps;

import java.util.ArrayList;

public class AlHeap{

    static class Heap{
        ArrayList<Integer> heap= new ArrayList<>();

        // add a new element in a heap 
        // then fixing it to its appropriate position
        public  void add(int data){
            heap.add(data);
            int childIdx=heap.size()-1;
            int parentIdx=(childIdx-1)/2;

            while(heap.get(childIdx)<heap.get(parentIdx)){
                int temp=heap.get(childIdx);
                heap.set(childIdx,heap.get(parentIdx));
                heap.set(parentIdx,temp);

                childIdx=parentIdx;
                parentIdx=(childIdx-1)/2;
            }
        }

        // to get minimum in a min heap.
        public int peek(){
            return heap.get(0);
        }
    }
    public static void main(String[] args) {
        

    }
}