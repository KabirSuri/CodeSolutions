import java.util.*;
import java.io.*;
public class loan{
   public static long N;
   public static long K;
   public static long M;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("loan.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Long.parseLong(s.nextToken());
      K=Long.parseLong(s.nextToken());
      M=Long.parseLong(s.nextToken());
      long a=1,b=1000000000000L;
      while (a!=b) {
         long mid=(a+b+1)/2;
         if(works(K,mid)) {
            a=mid;
         }
         else {
            b=mid-1;
         }
      }      
      System.out.println(a);
      pw.println(a);
      pw.close();
   }
   public static boolean works(long k,long X){
      long G=0;
      while(k>0&&G<N){
         long Y=(N-G)/X;
         if(Y<M){
            long left=(N-G+M-1)/M;
            return left<=k;
         }
         long maxmatch=N-X*Y;
         long numdays=(maxmatch-G)/Y+1;
         if(numdays>k)numdays=k;
         G+=Y*numdays;
         k-=numdays;
      }
      return G>=N;
   }
}