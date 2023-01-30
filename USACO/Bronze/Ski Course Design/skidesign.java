/*
ID: surikab1
LANG: JAVA
TASK: skidesign
*/
import java.util.*;
import java.io.*;
public class skidesign{
   public static int N;
   public static int[] hills;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      
      hills=new int[N];
      int highest=-1, lowest=101;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         hills[i]=Integer.parseInt(s.nextToken());
         highest=Math.max(hills[i],highest);
         lowest=Math.min(hills[i],lowest);
      }
      int min=Integer.MAX_VALUE;
      for(int i=lowest;i<=highest;i++){
         int count=0;
         for(int k=0;k<N;k++){
            if(hills[k]<i)count+=(int)Math.pow(i-hills[k],2);
            else if(hills[k]>i+17)count+=(int)Math.pow(hills[k]-i-17,2);
            if(count>min)break;
         }
         min=Math.min(count,min);
      }
      
      //System.out.println(min);
      pw.println(min);
      pw.close();
   }
}