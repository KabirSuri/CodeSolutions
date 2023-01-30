import java.util.*;
import java.io.*;
public class mootube{
   static int N;
   static ArrayList<Integer>[] connections;
   static ArrayList<Integer>[] relevances;
   static boolean[] visited;
   static int count;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "mootube.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(s.nextToken());
      int Q=Integer.parseInt(s.nextToken());
      connections=new ArrayList[N];
      relevances=new ArrayList[N];
      
      for(int i=0;i<N;i++){
         connections[i]=new ArrayList<Integer>();
         relevances[i]=new ArrayList<Integer>();
      }
      
      for(int i=1;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int p=Integer.parseInt(s.nextToken())-1,q=Integer.parseInt(s.nextToken())-1, r=Integer.parseInt(s.nextToken());
         connections[p].add(q);
         connections[q].add(p);
         relevances[p].add(r);
         relevances[q].add(r);
      }
      
      for(int i=0;i<Q;i++){
         s=new StringTokenizer(br.readLine());
         int k=Integer.parseInt(s.nextToken());
         int v=Integer.parseInt(s.nextToken())-1;
         visited=new boolean[N];
         count=-1;
         dfs(k,v);
         System.out.println(count);
         pw.println(count);
      }
      pw.close();
   }
   public static void dfs(int k, int v){
      if(visited[v])return;
      visited[v]=true;
      count++;
      for(int i=0;i<connections[v].size();i++){
         if(relevances[v].get(i)>=k)dfs(k,connections[v].get(i));
      }
   }
}