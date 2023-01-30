/*
ID: surikab1
LANG: JAVA
TASK: milk2
*/
import java.util.*;
import java.io.*;
public class milk2{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int[] arr=new int[1000001];
      int start=1000001;
      int end=1;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int st=Integer.parseInt(s.nextToken())+1,en=Integer.parseInt(s.nextToken())+1;
         start=Math.min(st,start);
         end=Math.max(en,end);
         arr[st]+=1;
         arr[en]-=1;
      }
      int maxOne=0;
      int maxNone=0;
      int one=0;
      int none=0;
      for(int i=start;i<=end;i++){
         arr[i]+=arr[i-1];
         if(arr[i]>0){
            one++;
            maxNone=Math.max(none,maxNone);
            none=0;
         }
         else{
            none++;
            maxOne=Math.max(one,maxOne);
            one=0;
         }
      }
      pw.println(maxOne+" "+maxNone);
      pw.close();
   }
}