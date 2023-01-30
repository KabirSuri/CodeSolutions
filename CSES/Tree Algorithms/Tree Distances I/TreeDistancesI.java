import java.util.*;
import java.io.*;
public class TreeDistancesI{
   public static ArrayList<Integer>[] graph;
   public static int N;
   public static int maxLength=0;
   public static int maxNode=0;
   public static boolean[] visited;
   public static int distances[];
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      graph=new ArrayList[N];
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<N-1;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
      }
      visited=new boolean[N];
      dfs(-1,0,0);
      maxLength=0;
      distances=new int[N];
      dfs1(-1,maxNode,0);
      System.out.println(Arrays.toString(distances));
      for(int i=0;i<N;i++){
         distances[i]=Math.max(maxLength-distances[i],distances[i]);
         System.out.print(distances[i]+" ");
      }
   }
   public static void dfs(int last, int index, int pathLength){
      for(int i:graph[index]){
         if(i==last)continue;
         dfs(index,i,pathLength+1);
      }
      if(graph[index].size()==1&&graph[index].get(0)==last){
         if(pathLength>maxLength){
            maxNode=index;
            maxLength=pathLength;
         }
      }
   }
   public static void dfs1(int last, int index, int length){
      distances[index]=length;
      for(int i:graph[index]){
         if(i==last)continue;
         dfs1(index,i,length+1);
      }
      if(graph[index].size()==1&&graph[index].get(0)==last){
         if(length>maxLength){
            maxNode=index;
            maxLength=length;
         }
      }
   }
}