package GreedyAlgo;
import java.util.*;

public class MaxChainLen {

    // find the maximum chain that can formed, given that the pair can exist only if (a,b)
    // & (c-d) such that b<=c.
    public static void main(String[] args) {
        int pairs[][] ={{5,24},{39,60},{5,28},{27,40},{ 50,90}};
        int pairsSort[][]  = new int[pairs.length][3];
        for(int i=0;i<pairs.length;i++){
            pairsSort[i][0]= i;
            pairsSort[i][1]= pairs[i][0];
            pairsSort[i][2]= pairs[i][1];
        }

        Arrays.sort(pairsSort,Comparator.comparingDouble(e->e[2]));

        // for(int i=0;i<pairsSort.length;i++){
        //     for(int j=0;j<pairsSort[0].length;j++){
        //         System.out.print(pairsSort[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        maxChain(pairsSort);
    }

    public static void maxChain(int [][]pairsSort){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        int maxchain=1;
        int chainEnd=pairsSort[0][2];
        for(int i=1;i<pairsSort.length;i++){
            if(pairsSort[i][1] >=chainEnd){
                al.add(pairsSort[i][0]);
                maxchain++;
                chainEnd= pairsSort[i][2];
            }
        }
        System.out.println("maxChain length is :"+maxchain);
        for(int n=0;n<al.size();n++){
            System.out.print("chain"+al.get(n)+" ");
        }
    } 
}
