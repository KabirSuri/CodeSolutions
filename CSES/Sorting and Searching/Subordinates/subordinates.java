import java.util.*;
import java.io.*;
public class subordinates{
   public static ArrayList<Integer>[] graph;
   public static int[] ans;
   public static int count;
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      ans=new int[N];
      graph=new ArrayList[N];
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      s=new StringTokenizer(br.readLine());
      for(int b=1;b<N;b++){
         int a=Integer.parseInt(s.nextToken());
         graph[a].add(b);
      }
      dfs(0);
      for(int i=0;i<N;i++){
         System.out.print(ans[i]+" ");
      }
   }
   public static void dfs(int a){
      for(int i:graph[a]){
         dfs(i);
         ans[a]+=ans[i]+1;
     }
   }
}