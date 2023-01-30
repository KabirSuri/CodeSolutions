import java.util.*;
import java.io.*;
public class rent{
   public static int T;
   public static int N;
   public static Order[] orders;
   public static int[] dp;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      T=Integer.parseInt(s.nextToken());
      for(int t=0;t<T;t++){
         s=new StringTokenizer(br.readLine());
         N=Integer.parseInt(s.nextToken());
         orders=new Order[N+1];
         dp=new int[N+1];
         orders[0]=new Order(0,0,0);
         for(int i=1;i<=N;i++){
            s=new StringTokenizer(br.readLine());
            orders[i]=new Order(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
         }
         Arrays.sort(orders);
         int[] prev=new int[N+1];
         for(int i=1;i<=N;i++){
            prev[i]=binarySearch(i);
         }
         for(int i=1;i<=N;i++){
            dp[i]=Math.max(dp[i-1],orders[i].price+dp[prev[i]]);
         }
         System.out.println(dp[N]);
      }
   }
   public static int binarySearch(int index){
      int a=0,b=N;
      while(a!=b){
         int mid=(a+b+1)/2;
         if(orders[mid].end<=orders[index].start){
            a=mid;
         }
         else{
            b=mid-1;
         }
      }
      return b;
   }
}
class Order implements Comparable<Order>{
   int start;
   int end;
   int price;
   public Order(int a, int d, int p){
      start=a;
      end=start+d;
      price=p;
   }
   public int compareTo(Order o){
      if(end==o.end)return start-o.start;
      return end-o.end;
   }
}