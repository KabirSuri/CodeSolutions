import java.util.*;
import java.io.*;
public class reststops{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int L=Integer.parseInt(s.nextToken()), N=Integer.parseInt(s.nextToken()), F=Integer.parseInt(s.nextToken()), B=Integer.parseInt(s.nextToken()); 
      
      long[][] rests=new long[N][2];
      long[] maxes=new long[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         rests[i][0]=Long.parseLong(s.nextToken());
         rests[i][1]=Long.parseLong(s.nextToken());
      }
      long max=0;
      for(int i=N-1;i>=0;i--){
         max=Math.max(max,rests[i][1]);
         maxes[i]=max;
      }
      long totalRest=0, taste=0;
      for(int i=0;i<N;i++){
         if(maxes[i]==rests[i][1]){
            long fTime=rests[i][0]*F;
            long bTime=rests[i][0]*B+totalRest;
            long locRest=fTime-bTime;
            taste+=locRest*rests[i][1];
            totalRest+=locRest;
         }
      }
      //System.out.println(taste);
      pw.println(taste);
      pw.close();
   }
}