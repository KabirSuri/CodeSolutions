import java.util.*;
import java.io.*;
public class convultedIntervals{
   public static int N;
   public static int M;
   public static long[] aFrequencies;
   public static long[] bFrequencies;
   public static long[] val;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      val=new long[2*M+2];
      aFrequencies=new long[M+1];
      bFrequencies=new long[M+1];
      StringBuffer out=new StringBuffer();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken()), b=Integer.parseInt(s.nextToken());
         aFrequencies[a]++;
         bFrequencies[b]++;
      }
      /*System.out.println(Arrays.toString(aFrequencies));
      System.out.println(Arrays.toString(bFrequencies));*/
      for(int i=0;i<=M;i++){
         for(int k=i;k<=M;k++){
            int sum=i+k;
            val[sum]+=aFrequencies[i]*aFrequencies[k];
            val[sum+1]-=bFrequencies[i]*bFrequencies[k];
            if(i!=k){
               val[sum]+=aFrequencies[i]*aFrequencies[k];
               val[sum+1]-=bFrequencies[i]*bFrequencies[k];
            }
         }
      }
      out.append(val[0]);
      for(int i=1;i<(2*M+1);i++){
         val[i]+=val[i-1];
         out.append("\n"+val[i]);
      }
      System.out.println(out);
   }
}