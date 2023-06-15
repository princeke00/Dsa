package BT;

public class InvertedBt {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isInverted(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isInverted(root1.left, root2.right) && isInverted(root1.right, root2.left);
    }

    public static Node delete(Node root, int key) {
        if (root == null) return null;
        if (root.left == null && root.right == null && root.data == key) {
            return null;
            
        }
        root.left=delete(root.left, key);
        root.right=delete(root.right, key);
        return root;

    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(3);
        node1.right.left = new Node(6);
        node1.right.right = new Node(3);

        // Node node2= new Node(1);
        // node1.left= new Node(3);
        // node1.right= new Node(2);
        // node1.left.left= new Node(7);
        // node1.left.right= new Node(6);
        // node1.right.left= new Node(5);
        // node1.right.right= new Node(4);

        // System.out.println(isInverted(node1, node2));
        delete(node1, 3);
        inOrder(node1);
    }
}
