package GreedyAlgo;

import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsck {
    // maximize the profit that can be made from the given knapsack(bag) of given capacity w.
    public static void main(String[] args) {
        int[] value={60,120,100};
        int[] weight={10,30,20};
        int w=50;
        
        double ratio[][]= new double[value.length][2];

        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(i->i[1]));

        int maxProfit=0,capacity=w;

        for(int i=ratio.length-1;i>=0;i--){
            if(capacity>=weight[(int)ratio[i][0]]){
                maxProfit +=value[(int)ratio[i][0]];
                capacity -=weight[(int)ratio[i][0]];
            }
            else{
                maxProfit +=ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }

        System.out.println("maxprifti :"+maxProfit);
    }
}
