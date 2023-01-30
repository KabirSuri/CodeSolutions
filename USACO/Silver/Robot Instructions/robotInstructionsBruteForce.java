import java.util.*;
import java.io.*;
public class robotInstructionsBruteForce{
   public static int N;
   public static int xAns;
   public static int yAns;
   public static int[][] vectors;
   public static int[] ans;
   public static StringBuffer out=new StringBuffer();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("redistributingGifts.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      xAns=Integer.parseInt(s.nextToken());
      yAns=Integer.parseInt(s.nextToken());
      vectors=new int[N][2];
      ans=new int[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         vectors[i][0]=Integer.parseInt(s.nextToken());
         vectors[i][1]=Integer.parseInt(s.nextToken());
      }
      dfs(0,0,0,0);
      for(int i=0;i<N;i++){
         out.append(ans[i]+"\n");
      }
      System.out.print(out);
   }
   public static void dfs(int i, int xSum, int ySum, int count){
      System.out.println(xSum+" "+ySum);
      if(i==N){
         if(xSum==xAns&&ySum==yAns){
            ans[count-1]++;
         }
         return;
      }
      dfs(i+1,xSum+vectors[i][0],ySum+vectors[i][1],count);
      dfs(i+1,xSum,ySum,count+1);
   }
}