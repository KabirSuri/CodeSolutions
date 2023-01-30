import java.util.*;
import java.io.*;
public class flightRoutesCheck{
   public static ArrayList<Integer>[] graph;
   public static ArrayList<Integer>[] backward;
   public static boolean[] visited;
   public static boolean[] backVisited;
   public static int N;
   public static int M;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      graph=new ArrayList[N];
      backward=new ArrayList[N];
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
         backward[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         backward[b].add(a);
      }
      visited=new boolean[N];
      backVisited=new boolean[N];
      dfs(0);
      backDfs(0);
      boolean yes=true;
      for(int i=1;i<N;i++){
         if(!visited[i]){
            yes=false;
            System.out.println("NO");
            System.out.println(1+" "+(i+1));
            break;
         }
      }
      if(yes){
         for(int i=1;i<N;i++){
            if(!backVisited[i]){
               yes=false;
               System.out.println("NO");
               System.out.println((i+1)+" "+1);
               break;
            }
         }
      }
      if(yes){
         System.out.println("YES");
      }
      /*System.out.println(Arrays.toString(visited));
      System.out.println(Arrays.toString(backVisited));*/ 
   }
   public static void dfs(int index){
      if(visited[index]){
         return;
      }
      visited[index]=true;
      for(int i:graph[index]){
         dfs(i);
      }
   }
   public static void backDfs(int index){
      if(backVisited[index]){
         return;
      }
      backVisited[index]=true;
      for(int i:backward[index]){
         backDfs(i);
      }
   }
}