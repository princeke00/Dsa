package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int arr[]= {9,2,5,2,6,4,8,1};
            
        mergeSort(arr,0,arr.length-1);

        for(int i:arr){
            System.out.print(i+" ");
        }
    }
 
    public static void mergeSort(int arr[],int left,int right){
       if(left>=right) return;
        int mid=left+(right-left)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr, mid+1,right);

        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int temp[]= new int[right-left+1];
        int low=left;
        int secMid=mid+1;
        int x=0;

        while(low<=mid && secMid <=right ){
            if(arr[low]<=arr[secMid]){
                temp[x++]=arr[low++];
                // low++;
            }else{
                temp[x++]=arr[secMid++];
                // secMid++;
            }
        }
        while(low<=mid){
            temp[x++]=arr[low++];
            // low++;
        }
        while(secMid<=right){
            temp[x++]=arr[secMid++];
            // secMid++;
        }
        for(int i=0,j=left;i<temp.length;i++,j++){
            arr[j]=temp[i];
        }
        
    }
}

