package Recursion;

public class BasixRecursion {
    public static void main(String[] args) {
        String s="Prince kumar";
        // printName(s,0);

        printNum(1);

    }

    // to print name 5 times;
    public static void printName(String name, int num){
        if(num==5){
            return;
        }
        System.out.println(name);
        printName(name, num+1);
    }

    // print linerarly 1 to n
    public static void printNum(int num,int base){
        if(num>base) return;
        System.out.println(num++);
        printNum(num, base);
    }

    // // print linerarly n to 1
    // public static void printNum(int num){
    //     if(num==0) return;
    //     System.out.println(num--);
    //     printNum(num);
    // }

    //  print linerarly 1 to n
    public static void printNum(int num){
        if(num>5) return;
        printNum(num+1);
        System.out.println(num);
    }
}
