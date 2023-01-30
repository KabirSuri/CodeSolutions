import java.util.*;
import java.io.*;
public class cereal2{
   public static int N;
   public static int M;
   public static boolean[] visitedEdgeFloodFill;
   public static boolean[] visitedEdge;
   public static Edge[] edges;
   public static Vertex[] vertexes;
   public static Vertex[] vertexesDirected;
   public static int hungry=0;
   public static StringBuffer out=new StringBuffer();
   public static void main(String[] args) throws IOException{
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader br = new BufferedReader(new FileReader("cereal2.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      visitedEdge=new boolean[N];
      visitedEdgeFloodFill=new boolean[N];
      vertexes=new Vertex[M];
      vertexesDirected=new Vertex[M];
      for(int i=0;i<M;i++){
         vertexes[i]=new Vertex();
         vertexesDirected[i]=new Vertex();
      }
      edges=new Edge[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         edges[i]=new Edge(a,b);
         vertexes[a].add(i);
         vertexes[b].add(i);
         vertexesDirected[a].add(i);
      }
      for(int i=0;i<N;i++){
         if(visitedEdgeFloodFill[i])continue;
         HashSet<Integer> eSet=new HashSet<Integer>();
         HashSet<Integer> vSet=new HashSet<Integer>();
         vSet.add(edges[i].from);
         floodfill(i,eSet,vSet);
         System.out.println(eSet);
         System.out.println(vSet);
         int addition=Math.max(0,eSet.size()-vSet.size());
         hungry+=addition;
         HashSet<Integer> willGoHungry=new HashSet<Integer>();
         int count=0;
         for(int k:eSet){
            if(count>=addition)break;
            willGoHungry.add(k);
            count++;
         }
         for(int k:vSet){
            int edgeCount=0;
            boolean found=false;
            for(int j:vertexesDirected[k].edges){
               if(!willGoHungry.contains(j))edgeCount++;
               if(edgeCount==2){
                  found=true;
                  dfs(j,willGoHungry);
                  break;
               }
            }
            if(found)break;
         }
         for(int k:willGoHungry){
            out.append((k+1)+"\n");
         }
      }
      System.out.println(hungry);
      System.out.print(out);
   }
   public static void floodfill(int edge, HashSet<Integer> eSet, HashSet<Integer> vSet){
      if(visitedEdgeFloodFill[edge])return;
      visitedEdgeFloodFill[edge]=true;
      int vertex=edges[edge].to;
      eSet.add(edge);
      vSet.add(vertex);
      for(int i:vertexes[vertex].edges){
         floodfill(i,eSet,vSet);
      }
   }
   public static void dfs(int edge, HashSet<Integer> willGoHungry){
      if(visitedEdge[edge])return;
      visitedEdge[edge]=true;
      out.append((edge+1)+"\n");
      int vertex=edges[edge].to;
      for(int i:vertexes[vertex].edges){
         if(willGoHungry.contains(i))continue;
         dfs(i,willGoHungry);
      }
   }
}
class Edge{
   int from;
   int to;
   public Edge(int a, int b){
      from=a;
      to=b;
   }
}
class Vertex{
   ArrayList<Integer> edges;
   public Vertex(){
      edges=new ArrayList<Integer>();
   }
   public void add(int i){
      edges.add(i);
   }
}