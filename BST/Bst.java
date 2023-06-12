package BST;

public class Bst {
    public static void main(String[] args) {

        int c[] = { 1, 1, 2, 5, 5 };
        System.out.println(search(c, 5));

    }

    public static int search(int A[], int N) {
        // your code here

        for (int i = 0; i < N; i++) {
            int curr = A[i], count = 0;
            for (int j = 0; j < N; j++) {
                if (curr == A[j]) {
                    count++;
                }
            }
            if (count == 1)
                return A[i];
        }
        return 0;
    }
}
