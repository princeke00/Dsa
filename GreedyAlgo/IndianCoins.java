package GreedyAlgo;
import java.util.*;

public class IndianCoins {

    // find minimum no of coins tht is to given .
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount=590;
        Arrays.sort(coins,Comparator.reverseOrder());

        minCoin(coins,amount);
    }

    public static void minCoin(Integer[] coins, int amount){
        ArrayList<Integer> al= new ArrayList<>();
        int noOfCoins=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    noOfCoins++;
                    al.add(coins[i]);
                    amount -=coins[i];
                }
            }
        }
        System.out.println(noOfCoins);
        
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
    }
}
