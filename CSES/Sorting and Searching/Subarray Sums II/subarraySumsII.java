import java.util.*;
import java.io.*;
public class subarraySumsII{
   public static HashMap<Long,Long> count=new HashMap<>();
   public static long[] prefix;
   public static int N;
   public static int X;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      X=Integer.parseInt(s.nextToken());
      prefix=new long[N+1];
      count.put(0L,1L);
      long ans=0;
      s=new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++){
         prefix[i]=prefix[i-1]+Long.parseLong(s.nextToken());
         if(count.get(prefix[i])==null)count.put(prefix[i],0L);
         count.put(prefix[i],count.get(prefix[i])+1);
         if(count.get(prefix[i]-X)!=null)
            ans+=count.get(prefix[i]-X);
            if(prefix[i]==0&&X==0)ans--;
      }
      //System.out.println(count);
      System.out.println(ans);
   }
}