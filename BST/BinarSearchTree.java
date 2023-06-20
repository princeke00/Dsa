package BST;
import java.util.*;

public class BinarSearchTree {

    static class Node{
        int data;
        Node right,left;

        public Node(int data){
            this.data=data;
            this.right=this.left=null;
        }
    }

    public static Node buildBst(Node root, int value){
        if(root==null){
            return new Node(value);
        }
        if(root.data> value){
            root.left=buildBst(root.left, value);
        }else{
            root.right=buildBst(root.right, value);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root){
        if(root== null){
            return;
        }

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr= q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static boolean find(Node root, int value){
        if(root==null) return false;
        if(root.data==value){ return true;}
        if(root.data>value){
            return find(root.left,value);
        }else{
            return find(root.right,value);
        }
    }

    public static Node delete(Node root, int value){
        if(root.data<value){
            root.right=delete(root.right, value);
        }else if(root.data>value){
            root.left=delete(root.left, value);
        }else{
            if(root.left ==null && root.right==null){
                return null;
            }
            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }

            Node inOrderS= sucessor(root.right);
            root.data=inOrderS.data;
            root.right=delete(root.right, inOrderS.data);
        }
        return root;
    }

    public static Node sucessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int val[] = {7,5,3,9,1,10,2,6,8,4,}; //{5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=buildBst(root, val[i]);
        }

        levelOrder(root);
        delete(root, 7);
        System.out.println();
        levelOrder(root);
    }
}
