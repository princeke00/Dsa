package GreedyAlgo;

public class MaxBalancedPartionString {
    public static void main(String[] args) {
        String s = "LRRRRLLRLLRL";

        maxPartion(s);
        
    }

    private static void maxPartion(String s) {
        int r=0,l=0,ans=0;
        String str="";
        int len=s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='R'){
                str+=s.charAt(i);
                r++;
            }else if(s.charAt(i)=='L'){
                str+=s.charAt(i);
                l++;
            }
            if(r==l){
                System.out.println(str);
                ans++;
            }
        }

        System.out.println("max balanced partion done is :"+ans);
    }
}
