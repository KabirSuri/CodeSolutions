import java.util.*;
import java.io.*;
public class subarrayDivisibility{
   public static HashMap<Long,Long> count=new HashMap<>();
   public static long[] prefix;
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      prefix=new long[N+1];
      count.put(0L,1L);
      long ans=0;
      s=new StringTokenizer(br.readLine());
      //System.out.println(-10%7);
      for(int i=1;i<=N;i++){
         prefix[i]=((prefix[i-1]+Long.parseLong(s.nextToken()))%N+N)%N;
         if(count.get(prefix[i])==null)count.put(prefix[i],0L);
         ans+=count.get(prefix[i]);
         count.put(prefix[i],count.get(prefix[i])+1);
      }
      //System.out.println(count);
      System.out.println(ans);
   }
}