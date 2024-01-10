package LinkedLists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    public static Node sortList(Node head) {
        // Write your code here
        HashMap<Integer,Integer> map= new HashMap<>();
        Node temp=head;

        if(temp==null|| temp.next== null) return null;

        while(temp!=null){
            map.put(temp.data,map.getOrDefault(temp.data,0)+1);
            temp=temp.next;
        }
        for(int i: map.keySet()){
            System.out.println(i +""+map.get(i));
        }

        temp=head;
        for(int i=0;i<3;i++){
            while(map.get(i)>0){
                temp.data=i;
                map.put(i,map.get(i)-1);
                temp=temp.next;
            }
        }
        listPrint(head);
        return head;
    }
    public static void listPrint(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-> ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(0);
        head.next.next=new Node(2);
        head.next.next.next=new Node(1);

        Node temp= sortList(head);
        System.out.println(temp.data);

    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
