package BST;
import java.util.Queue;
import java.util.LinkedList;

public class BinarTrees {
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
    
    

    static class BinaryTree{
        static int index=-1;
        public static Node buildTree(int[] arr){
            index++;
            if(arr[index]==-1){
                return null;
            }

            Node newNode  = new Node(arr[index]);
            newNode.left  = buildTree(arr);
            newNode.right = buildTree(arr);

            return newNode;
        }

        public static int preOrder(Node root){ //  root, left subtree, right subtree
            if(root==null){
                System.out.print(-1+" ");
                return 0;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
            
            return 0;
        }

        public static void inOrder(Node root){ // left subtree, root, right subtree
            if(root== null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){  // left subtree, right subtree, root
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
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
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        // BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(arr);

        // BinaryTree.preorder(root);
        // BinaryTree.inOrder(root);
        // BinaryTree.postOrder(root);
        BinaryTree.levelOrder(root);

    }
}
