import java.util.*;
import java.io.*;
public class TreeDiameter{
   public static ArrayList<Integer>[] graph;
   public static int N;
   public static int maxLength=0;
   public static int maxNode=0;
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
      dfs(-1,0,0);
      maxLength=0;
      dfs(-1,maxNode,0);
      System.out.println(maxLength);
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
}