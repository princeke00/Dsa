package BT;
import java.util.*;
import java.util.Map.Entry;

public class TopView {
    // print topView Of a binary tree

    static class Node{
        int data; 
        Node right;
        Node left;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Info{
        Node node;
        int hd;

        public Info(int hd,Node node){
            this.node=node;
            this.hd=hd;
        }
    }

    private static void topView(Node root){
        Queue<Info> q= new LinkedList<>();
        HashMap<Integer,Node> hm= new HashMap<>();

        int max=0,min=0;
        q.add(new Info(0,root));
        q.add(null);

        while(!q.isEmpty()){
            Info curr= q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            } 
            else{
                if(!hm.containsKey(curr.hd)){
                    hm.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.hd-1,curr.node.left));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.hd+1,curr.node.right));
                    max=Math.max(max,curr.hd+1);
                }
            }
            
            
        }
        System.out.println("topView :");
        for(int i=min;i<=max;i++){
            System.out.print(hm.get(i).data+" ");
        }
        for(Entry<Integer, Node> entry:hm.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().data);
        }
    }

    private static void bottomView(Node root){
        Queue<Info> q= new LinkedList<>();
        HashMap<Integer,Node> hm= new HashMap<>();

        int max=0,min=0;
        q.add(new Info(0,root));
        q.add(null);

        while(!q.isEmpty()){
            Info curr= q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            } 
            else{
                if(!hm.containsKey(curr.hd)){
                    hm.put(curr.hd,curr.node);
                }else{
                    hm.put(curr.hd,curr.node);
                }
                
                if(curr.node.left!=null){
                    q.add(new Info(curr.hd-1,curr.node.left));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.hd+1,curr.node.right));
                    max=Math.max(max,curr.hd+1);
                }
            }
            
            
        }
        System.out.println("bottomView :");
        for(int i=min;i<=max;i++){
            System.out.print(hm.get(i).data+" ");
        }
    }

    public static void main(String[] args) {
    
        // Node root= new Node(1);
        // root.left= new Node(2);
        // root.right= new Node(3);
        // root.left.left= new Node(4);
        // root.left.right= new Node(5);
        // root.right.left= new Node(6);
        // root.right.right= new Node(7);

        Node root= new Node(20);
        root.left= new Node(8);
        root.right= new Node(22);
        root.left.left= new Node(5);
        root.left.right= new Node(3);
        root.left.right.left= new Node(10);
        root.left.right.right= new Node(14);
        root.right.right= new Node(25);
        
        topView(root);
        bottomView(root);

    }
}
