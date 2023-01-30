import java.util.*;
import java.io.*;
public class baseball{
   public static int N;
   public static int[] cows;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("baseball.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      
      cows=new int[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         cows[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(cows);
      long count=0;
      for(int i=0;i<N-2;i++){
         for(int k=i+1;k<N-1;k++){
            int start=k+1,end=N-1;
            while(start!=end){
               int mid=(start+end+1)/2;
               if((cows[k]-cows[i])*2+cows[k]>=cows[mid])start=mid;
               else end=mid-1;
            }
            int max=end;
            if(cows[k]*2-cows[i]>cows[max])continue;
            start=k+1;
            while(start!=end){
               int mid=(start+end)/2;
               if(cows[k]*2-cows[i]<=cows[mid])end=mid;
               else start=mid+1;
            }
            int min=end;
            if((cows[k]-cows[i])*2+cows[k]<cows[min])continue;
            count+=(max-min+1);
         }
      }
      
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}