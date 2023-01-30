import java.util.*;
import java.io.*;
public class moocastGold{
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
         nodes[i]=new Node(a,b);
      }
      //System.out.println(Arrays.toString(nodes));
      long a=0, b=1250000000;
      while(a!=b){
         long mid=(a+b)/2;
         visited=new boolean[N];
         count=0;
         dfs(0,mid);
         //System.out.println(mid);
         //System.out.println(Arrays.toString(visited));
         if(count==N){
            b=mid;
         }
         else{
            a=mid+1;
         }
      }
      System.out.println(a);
      pw.println(a);
      pw.close();
   }
   public static void dfs(int node, long mid){
      //System.out.println("node: "+node);
      if(visited[node])
         return;
      count++;
      visited[node]=true;
      for(int i=0;i<N;i++){
         //System.out.println("i:"+i+" distance:"+distance(node,i));
         if(distance(node,i)<=mid)dfs(i,mid);
      }
   }
   public static long distance(int one, int two){
      return (long)(Math.pow(nodes[one].x-nodes[two].x,2)+Math.pow(nodes[one].y-nodes[two].y,2));
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
      return x+","+y;
   }
}