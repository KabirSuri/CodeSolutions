import java.util.*;
import java.io.*;
public class bipartiteness{
   public static ArrayList<Integer>[] graph;
   public static int head[];
   public static EdgeData edges[];
   public static int team[];
   public static int edgeCount=0;
   //public static HashSet<String> hs=new HashSet<>();
   public static boolean[] visited;
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int M=N-1;
      head=new int[N];
      edges=new EdgeData[2*M];
      team=new int[N];
      Arrays.fill(head,-1);
      for(int i=0;i<N-1;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         addEdge(a,b);
         addEdge(b,a);
         //hs.add(a+" "+b);
         //hs.add(b+" "+a);
      }
      visited=new boolean[N];
      for(int i=0;i<N;i++){
         if(!visited[i]){
            dfs(i,1);
         }
      }
      long one=0;
      long two=0;
      for(int i=0;i<N;i++){
         if(team[i]==0)one++;
         else two++;
      }
      long ans=one*two-N+1;
      System.out.println(ans);
   }
   public static void addEdge(int from, int to){
      edges[edgeCount]=new EdgeData();
      edges[edgeCount].to=to;
      edges[edgeCount].next=head[from];
      head[from]=edgeCount;
      edgeCount++;
   }
   public static void dfs(int index, int color){
      if(visited[index]){
         return;
      }
      visited[index]=true;
      team[index]=color;
      color=(color+1)%2;
      for(int curEdgeIndex=head[index];curEdgeIndex!=-1;curEdgeIndex=edges[curEdgeIndex].next){
         int v=edges[curEdgeIndex].to;
         dfs(v,color);
      }
   }
}
class EdgeData{
   int to, next;
}