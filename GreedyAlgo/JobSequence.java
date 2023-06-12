package GreedyAlgo;
import java.util.*;

public class JobSequence {
    // performe some task in such a sequence that you get the maximum
    // profit. each task needs to done before its deadline and each of them take 1 unit of time
    // to done. find the maximum profit.

    static class Job{
        int deadline;
        int profit;
        char jobId;

        public Job( int deadline, int profit,char jobId){
            this.deadline=deadline;
            this.profit=profit;
            this.jobId=jobId;
        }
        
    }
    public static void main(String[] args) {
        int[][] jobInfo={{4,20},{1,10},{1,40},{1,20}};

        ArrayList<Job> jobs= new ArrayList<>();// this is based on creating a class Job and then creating its objects.

        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(jobInfo[i][0],jobInfo[i][1],(char)(65+i)));
        }

        Collections.sort(jobs,(a,b)-> b.profit-a.profit);
       
        ArrayList<Character> seq =new ArrayList<>();

        int time=0,profit=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.jobId);
                profit += curr.profit;
                time++;
            }
        }

        System.out.println("time taken is: "+time+" and profit is :"+profit);
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }

        // this is based on creating a 2d Array 
        // int[][] job= new int [jobInfo.length][3];
        // for(int i=0;i<jobInfo.length;i++){
        //     job[i][0]=i;
        //     job[i][1]=jobInfo[i][0];;
        //     job[i][2]=jobInfo[i][1];
        // }

        // Arrays.sort(job,Comparator.comparingDouble(i->i[2]));
        // ArrayList<Integer> al= new ArrayList<>();

        // int time=0,profit=0;
        // for(int i=job.length-1;i>-1;i--){
        //     if(job[i][1]>time){
        //         time++;
        //         al.add(i);
        //         profit += job[i][2];
        //     }
        // }

        // System.out.println("time taken is: "+time+" and profit is :"+profit);
        // for(int i=0;i<al.size();i++){
        //     System.out.print(al.get(i)+" ");
        // }
        
    }
}
