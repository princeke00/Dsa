package LinkedLists;

class Node {
    
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class LinkedListImplement {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };

    }

    // create linkedlist from array.
    public static Node createLinkedList(int arr[]) {
        Node head = new Node(arr[0]);
        Node idx = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            idx.next = temp;
            idx = temp;
        }
        return head;
    }

    // to find cycle in linkedList
    public static Boolean cycle(Node head){
        // will have to use 2 pointer approch
        // where 1 pointer would move 1 step ahead and other would move 2 steps head
        // will check until the fast.next pointer is not-null along with its imediate fast.next.next 

        // to get node where cycle is strating,will have to use pointer pointing to head
        // onte the cycle is detected, will again move slow and temp node to
        // get the cycle node starting point
        Node slow=head,fast= head,temp=head;

        // check if the given list is empty
        if(head==null) return false;
        
        while(fast.next!=null && fast.next.next!=null){
            // move the pointers
            slow=slow.next;
            fast=fast.next.next;

            // check if they are equal then return
            if(slow==fast){
                return true;
                // for node of cycle.
                // while(slow!=temp){
                //     temp=temp.next;
                //     slow=slow.next;
                // }
                // return slow;
            }
        }

        return false;
    }

    // to find middle node of list
    public static Node middlNode(Node head){
        // will have to use 2 pointer approch
        // where 1 pointer would move 1 step ahead and other would move 2 steps head
        // will check until the faster pointer is not-null along with its imediate next 
        
        Node slow=head,fast= head;

        // check if the given list is empty
        if(head==null||head.next==null) return head;
        
        while(fast!=null && fast.next!=null){
            // move the pointers
            slow=slow.next;
            fast=fast.next.next;

        }

        // when fast pointer is pointing to null; slow is denfinelty pointing to middle of the list
        return slow;
    }

}
