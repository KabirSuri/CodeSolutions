import java.util.*;
import java.io.*;
public class cowtagion{
   public static int N;
   public static ArrayList<Integer>[] graph;
   public static boolean visited[];
   public static int days;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      visited=new boolean[N];
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
      dfs(0,true);
      System.out.println(days);
   }
   public static void dfs(int index, boolean start){
      if(visited[index])return;
      visited[index]=true;
      if(!start)days++;
      int cowsWithCowid=1;
      int paths=graph[index].size();
      if(!start)paths--;
      while(cowsWithCowid<=paths){
         cowsWithCowid*=2;
         days++;
      }
      for(int i:graph[index]){
         dfs(i,false);
      }
   }
}