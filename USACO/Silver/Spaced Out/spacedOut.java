import java.util.*;
import java.io.*;
public class spacedOut{
   public static int N;
   public static long verticalSums[][];
   public static long horizontalSums[][];
   public static long max=0;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      verticalSums=new long[2][N];
      horizontalSums=new long[2][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            int a=Integer.parseInt(s.nextToken());
            verticalSums[i%2][k]+=a;
            horizontalSums[k%2][i]+=a;
         }
      }
      //System.out.println(Arrays.toString(vertical
      vertical(0,0);
      horizontal(0,0);
      System.out.println(max);
   }
   public static void vertical(int i, long sum){
      if(i==N){
         max=Math.max(sum,max);
         return;
      }
      vertical(i+1,Math.max(sum+verticalSums[0][i],sum+verticalSums[1][i]));
   }
   public static void horizontal(int i, long sum){
      if(i==N){
         max=Math.max(sum,max);
         return;
      }
      horizontal(i+1,Math.max(sum+horizontalSums[0][i],sum+horizontalSums[1][i]));
   }
}