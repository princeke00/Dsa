package Stacks;
import java.util.Stack;


public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = {4, 0, 7, 2, 5, 0, 6, 4, 0, 5};
        int[] leftMax= leftMax(height);
        System.out.println();
        int[] rightMax= rightMax(height);
        System.out.println();

        findTrappedWater(height,rightMax,leftMax);
        findWater(height);
    }

    public static void findTrappedWater(int[] height,int[] rightMax ,int[] leftMax ){
        int water=0;
        for(int i=0;i<height.length;i++){
            int len=Math.min(rightMax[i],leftMax[i])-height[i];
            water+=len;
        }
        System.out.println("total water is: "+water+" in findtrappedWater method");
    }

    public static int[] leftMax(int[] height){
        Stack<Integer> st = new Stack<>();
        int ltMax[] =  new int[height.length];
        ltMax[0]=height[0];
        st.push(0);
        // find the left boundray
        for(int i=1;i<height.length;i++){
            int curr=height[i];
            while(!st.isEmpty() && curr>= height[st.peek()]){ //{7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
                st.pop();
            }
            if(st.isEmpty()){
                ltMax[i]= curr;
            }else ltMax[i]=ltMax[st.peek()];
            st.push(i);
        }
        
        return ltMax;
    }

    public static int[] rightMax(int[] height){
        Stack<Integer> st = new Stack<>();
        int rtMax[] =  new int[height.length];
        rtMax[height.length-1]=height[height.length-1];
        st.push(height.length-1);
        // find the left boundray
        for(int i=height.length-2;i>=0;i--){
            int curr=height[i];
            while(!st.isEmpty() && curr>= height[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rtMax[i]= curr;
            }else rtMax[i]=rtMax[st.peek()];
            st.push(i);
        }
        
        return rtMax;
    }

    public static void findWater(int[] height){
        int len= height.length, lp=0, rp=len-1;
        int water=0, lMax=height[lp], rMax=height[rp];
        while(lp!=rp){
            if(lMax<rMax){
                lp++;
                lMax=Math.max(lMax, height[lp]);
                water +=lMax-height[lp]  ;
            }else{
                rp--;
                rMax=Math.max(rMax, height[rp]);
                water +=rMax-height[rp]  ;
            }
        }
        System.out.println("total water is: "+water+" in findWater method");
    }
}
