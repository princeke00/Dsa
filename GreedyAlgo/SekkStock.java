package GreedyAlgo;
import java.util.*;

public class SekkStock {
    public static void main(String[] args) {
        int[] price={7, 1, 5, 3, 6, 4};

        int[][] prices= new int[price.length][2];

        for(int i=0;i<price.length;i++){
            prices[i][0]=i;
            prices[i][1]=price[i];
        }

        Arrays.sort(prices,Comparator.comparingDouble(i->i[1]));

        int profit=0,maxProfit=0;

        int cp=prices[0][1];
        int cidx=prices[0][0];
        for(int i=1;i<price.length;i++){
            if(cidx<prices[i][0] && cp<prices[i][1]){
                profit=prices[i][1]-cp;
                maxProfit=Math.max(profit,maxProfit);
            }
        }
        System.out.println("maxProfit is:- "+maxProfit);
        System.out.println("-----------------");
        
        maxProfit(price);
    }

    public static void maxProfit(int[] price){
        int cp=price[0];
        int profit=0;
        for(int i=1;i<price.length;i++){
            if(cp>price[i]){
                cp=price[i];
            }else{
                profit=Math.max(price[i]-cp,profit);
                
            }
        }
        System.out.println("maxProfit is :"+profit);
    }
}
