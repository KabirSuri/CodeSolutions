import java.util.*;
import java.io.*;
public class shuffle{
   static int[] connections;
   static int[] alwaysOccupied;
   static boolean[] visited;
   static boolean[] hasConnection;
   static int N;
   static int count=0;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(s.nextToken());
      alwaysOccupied=new int[N];
      connections=new int[N];
      hasConnection=new boolean[N];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         int c=Integer.parseInt(s.nextToken())-1;
         connections[i]=c;
         hasConnection[c]=true;
      }
      for(int i=0;i<N;i++){
         if(!hasConnection[i])continue;
         visited=new boolean[N];
         dfs(i,i,true);
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void dfs(int current, int start, boolean noShuffles){
      if(!noShuffles&&current==start){
         alwaysOccupied[start]=1;
         count++;
         return;
      }
      if(visited[current]||alwaysOccupied[current]==-1){
         alwaysOccupied[start]=-1;
         return;
      }
      visited[current]=true;
      dfs(connections[current],start,false);
   }
}