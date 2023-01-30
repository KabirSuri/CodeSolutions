/*
ID: surikab1
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;
public class beads{
   public static int N;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("beads.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      String[] arr=s.nextToken().split("");
      int max=0;
      for(int i=0;i<N;i++){
         int sum1=0, sum2=0;
         int aPoint=i,bPoint=fixIndex(i+1);
         boolean[] visited=new boolean[N];
         String c1=arr[aPoint],c2=arr[bPoint];
         boolean keepTraversing1=true,keepTraversing2=true;
         while(keepTraversing1||keepTraversing2){
            if(!visited[aPoint]&&(arr[aPoint].equals(c1)||arr[aPoint].equals("w")||c1.equals("w"))){
               if(c1.equals("w"))c1=arr[aPoint];
               sum1++;
               visited[aPoint]=true;
               aPoint=fixIndex(aPoint-1);
            }
            else{
               keepTraversing1=false;
            }
            if(!visited[bPoint]&&(arr[bPoint].equals(c2)||arr[bPoint].equals("w"))){
               sum2++;
               visited[bPoint]=true;
               bPoint=fixIndex(bPoint+1);
            }
            else{
               keepTraversing2=false;
            }
         }
         max=Math.max(max,sum1+sum2);
      }
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
   public static int fixIndex(int i){
      if(i<0)return i+N;
      if(i>=N)return i%N;
      return i;
   }
}