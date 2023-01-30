import java.util.*;
import java.io.*;
public class bcount{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken()), Q=Integer.parseInt(s.nextToken());
      int[] H=new int[N+1];
      int[] G=new int[N+1];
      int[] J=new int[N+1];
      for(int i=1;i<=N;i++){
         s=new StringTokenizer(br.readLine());
         int cow=Integer.parseInt(s.nextToken());
         H[i]=H[i-1];
         G[i]=G[i-1];
         J[i]=J[i-1];
         if(cow==1)H[i]++;
         else if(cow==2)G[i]++;
         else J[i]++;
      }
      for(int i=0;i<Q;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken()),b=Integer.parseInt(s.nextToken());
         int h=H[b]-H[a-1];
         int g=G[b]-G[a-1];
         int j=J[b]-J[a-1];
         System.out.println(h+" "+g+" "+j);
         pw.println(h+" "+g+" "+j);
      }
      pw.close();
   }
}