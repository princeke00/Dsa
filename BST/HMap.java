package BST;
import java.util.HashMap;

public class HMap {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=10,j=0;i>-1 && j<10;i--,j++){
            hm.put(i,j);
        }
        // hm.put(9,0);
        // hm.put(0,1);
        // hm.put(8,18);
        // hm.put()
        System.out.println(hm);
    }    
}
