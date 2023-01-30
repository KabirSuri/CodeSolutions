import java.util.*;
import java.io.*;
public class moocast{
   static int N;
   static boolean[] visited;
   static int count;
   static Node nodes[];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      
      nodes=new Node[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken()), b=Integer.parseInt(s.nextToken());
         double d=Double.parseDouble(s.nextToken());
         nodes[i]=new Node(a,b,d);
      }
      int max=-1;
      for(int i=0;i<N;i++){
         visited=new boolean[N];
         count=0;
         floodfill(i);
         max=Math.max(count,max);
      }
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
   public static void floodfill(int node){
      if(visited[node])
         return;
      count++;
      visited[node]=true;
      for(int i=0;i<N;i++){
         if(withinRange(node,i))floodfill(i);
      }
   }
   public static boolean withinRange(int one, int two){
      double distance=Math.sqrt(Math.pow(nodes[one].x-nodes[two].x,2)+Math.pow(nodes[one].y-nodes[two].y,2));
      return nodes[one].distance>=distance;
   }
}
class Node{
   int x;
   int y;
   double distance;
   Node(int a, int b, double d){
      x=a;
      y=b;
      distance=d;
   }
}