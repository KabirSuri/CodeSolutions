import java.util.*;
import java.io.*;
public class closing{
   public static int N;
   public static int M;
   public static boolean[] closed;
   public static ArrayList<Integer> graph[];
   public static int count;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("closing.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      
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
      closed=new boolean[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         boolean[] visited=new boolean[N];
         int node=Integer.parseInt(s.nextToken())-1;
         count=0;
         floodfill(visited,node);
         closed[node]=true;
         if(count+i==N){
            System.out.println("YES");
            pw.println("YES");
         }
         else{
            System.out.println("NO");
            pw.println("NO");
         }
      }
      
      pw.close();
   }
   public static void floodfill(boolean visited[], int node){
      if(visited[node]||closed[node])
         return;
      count++;
      visited[node]=true;
      for(int i=0;i<graph[node].size();i++){
         floodfill(visited,graph[node].get(i));
      }
   }
}