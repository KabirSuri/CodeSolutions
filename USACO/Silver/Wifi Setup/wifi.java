import java.util.*;
import java.io.*;
public class wifi{
   public static int N;
   public static long A;
   public static long B;
   public static long[] dp;
   public static long[] cows;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("wifi.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wifi.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      A=Long.parseLong(s.nextToken());
      B=Long.parseLong(s.nextToken());
      dp=new long[N+1];
      cows=new long[N+1];
      for(int i=1;i<=N;i++){
         s=new StringTokenizer(br.readLine());
         cows[i]=Long.parseLong(s.nextToken());
      }
      Arrays.sort(cows);
      for(int i=1;i<=N;i++){
         dp[i]=Long.MAX_VALUE;
         for(int j=1;j<=i;j++){
            dp[i]=Math.min(dp[j-1]+(2*A+B*(cows[i]-cows[j])),dp[i]);
         }
      }
      //System.out.println(Arrays.toString(dp));
      double d=dp[N]/2.0;
      if(d*10%10!=0){
         System.out.println(dp[N]/2.0);
         pw.println(dp[N]/2.0);
      }
      else{
         System.out.println((int)(dp[N]/2.0));
         pw.println((int)(dp[N]/2.0));
      }
      pw.close();
   }
}