import java.util.*;
import java.io.*;
public class div7{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("div7.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "div7.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      
      int max=0;
      int[] positions={0,-1,-1,-1,-1,-1,-1};
      int sum=0;
      for(int i=1;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int value=Integer.parseInt(s.nextToken())%7;
         sum+=value;
         sum%=7;
         if(positions[sum]!=-1)max=Math.max(max,i-positions[sum]);
         else positions[sum]=i;
      }
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}