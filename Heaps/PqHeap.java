package Heaps;

import java.util.PriorityQueue;

public class PqHeap {

    // comparable interface proveids logic for object to be compared
    // has single function compareTo() which takes single argument.
    static class Student implements Comparable<Student> {
        int rank;
        String name;

        public Student(int rank,String name){
            this.rank=rank;
            this.name=name;
        }

        // if fucntion return +ve, first Obejct is grater
        // if function return -ve, 1st object is smaller
        // if function return 0, both objects are equal 
        @Override
        public int compareTo(Student s2){
            return s2.name.compareTo(this.name);
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq= new PriorityQueue<>();
        pq.add(new Student(5,"Prince"));
        pq.add(new Student(3,"Shashank"));
        pq.add(new Student(9,"Aayushi"));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.poll();
        }

    }
}
