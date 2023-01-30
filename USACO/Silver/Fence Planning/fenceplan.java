import java.util.*;
import java.io.*;
public class fenceplan{
   static int N;
   static int M;
   static int minX, maxX, minY, maxY;
   static boolean[] visited;
   static Node[] nodes;
   static ArrayList<Integer> graph[];
   static int minPerimeter=Integer.MAX_VALUE;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      
      nodes=new Node[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken());
         int b=Integer.parseInt(s.nextToken());
         nodes[i]=new Node(a,b);
      }
      graph=new ArrayList[N];
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1, b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
      }
      visited=new boolean[N];
      for(int i=0;i<N;i++){
         if(!visited[i]){
            minX=nodes[i].x;
            maxX=nodes[i].x;
            minY=nodes[i].y;
            maxY=nodes[i].y;
            minPerimeter=Math.min(floodfill(i),minPerimeter);
         }
      }
      System.out.println(minPerimeter);
      pw.println(minPerimeter);
      pw.close();
   }
   public static int floodfill(int node){
      visited[node]=true;
      minX=Math.min(minX,nodes[node].x);
      maxX=Math.max(maxX,nodes[node].x);
      minY=Math.min(minY,nodes[node].y);
      maxY=Math.max(maxY,nodes[node].y);
      for(int i=0;i<graph[node].size();i++){
         if(!visited[graph[node].get(i)]){
            floodfill(graph[node].get(i));
         }
      }
      return getPerimeter(minX,maxX,minY,maxY); 
   }
   public static int getPerimeter(int minX, int maxX, int minY, int maxY){
      int difX=maxX-minX;
      int difY=maxY-minY;
      return 2*difX+2*difY;
   }
}
class Node{
   int x;
   int y;
   Node(int a, int b){
      x=a;
      y=b;
   }
   public String toString(){
      return "("+x+","+y+")";
   }
}