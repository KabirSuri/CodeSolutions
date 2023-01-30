import java.util.*;
import java.io.*;
public class buildingRoads{
   public static int N;
   public static int M;
   public static ArrayList<Integer>[] graph;
   public static int[] fill;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      graph=new ArrayList[N];
      fill=new int[N];
      Arrays.fill(fill,-1);
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
      }
      int color=-1;
      for(int i=0;i<N;i++){
         if(fill[i]==-1){
            color++;
            dfs(i,color);
         }
      }
      boolean solved[]=new boolean[color+1];
      System.out.println(color);
      int roadsBuilt=0;
      for(int i=1;i<N&&roadsBuilt<color;i++){
         if(fill[0]!=fill[i]&&!solved[fill[i]]){
            solved[fill[i]]=true;
            roadsBuilt++;
            System.out.println(1+" "+(i+1));
         }
      }
   }
   public static void dfs(int index, int color){
      if(fill[index]==color)return;
      fill[index]=color;
      for(int i:graph[index]){
         dfs(i,color);
      }
   }
}