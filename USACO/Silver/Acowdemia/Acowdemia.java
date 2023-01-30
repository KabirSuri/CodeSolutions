import java.util.*;
import java.io.*;
public class Acowdemia{
   static long N;
   static long K;
   static long L;
   static Long[] papers;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Long.parseLong(s.nextToken());
      K=Long.parseLong(s.nextToken());
      L=Long.parseLong(s.nextToken());
      papers=new Long[(int)N];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         papers[i]=Long.parseLong(s.nextToken());
      }
      Arrays.sort(papers,Collections.reverseOrder());
      long a=0,b=N;
      while(a!=b) {
         long mid=(a+b+1)/2;
         if(works(mid)){
            a=mid;
         }
         else{
            b=mid-1;
         }
      }
      System.out.println(a);
   }
   public static boolean works(long h){
      long count=0;
      for(int i=0;i<h;i++){
         if(count>K*L)return false;
         if(papers[i]<h){
            if(papers[i]+K>=h){
               count+=h-papers[i];
            }
            else if(papers[i]+K<h)return false;
         }
      }
      if(count>K*L)return false;
      return true;
   }
}