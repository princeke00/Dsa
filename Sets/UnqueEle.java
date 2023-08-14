package Sets;
import java.util.HashSet;

public class UnqueEle {
    // find number of unique elements.
    public static void main(String[] args) {
        int arr[]={4,3,2,5,6,7,2,4,3,1};

        System.out.println("kdistinct ele is: "+uniqueEle(arr)); 
        System.out.println(distinctELe(arr));       ;
    }    

    private static int uniqueEle(int []arr){
        int result[]= new int[20];
        int k=0;

        for(int i=0;i<arr.length;i++){ 

            for(int j=0;j<i;j++){
                if(arr[i]==arr[j]){
                    break;
                }else{
                    result[k]=arr[i];
                    k++;
                }
            }

        }
        return k;
    }

    private static int distinctELe(int []arr){
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        return hs.size();
    }
}
