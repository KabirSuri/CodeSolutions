import java.util.*;
import java.io.*;
public class birthday{
   public static ArrayList<Integer>[] graph;
   public static int visitCount=0;
   public static boolean visited[];
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int p=Integer.parseInt(s.nextToken()), c=Integer.parseInt(s.nextToken());
      while(p!=0||c!=0){
         graph=new ArrayList[p];
         for(int i=0;i<p;i++){
            graph[i]=new ArrayList<Integer>();
         }
         for(int i=0;i<c;i++){
            s=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(s.nextToken());
            int b=Integer.parseInt(s.nextToken());
            graph[a].add(b);
            graph[b].add(a);
         }
         boolean yes=false;
         for(int i=0;i<p;i++){
            for(int k=0;k<graph[i].size();k++){
               int d=graph[i].get(k);
               graph[i].set(k,i);
               visitCount=0;
               visited=new boolean[p];
               dfs(i);
               graph[i].set(k,d);
               if(visitCount<p){
                  yes=true;
                  break;
               }
            }
            if(yes)break;
         }
         if(yes)System.out.println("Yes");
         else System.out.println("No");
         s=new StringTokenizer(br.readLine());
         p=Integer.parseInt(s.nextToken());
         c=Integer.parseInt(s.nextToken());
      }
   }
   public static void dfs(int index){
      if(visited[index])return;
      visited[index]=true;
      visitCount++;
      for(int i:graph[index]){
         dfs(i);
      }
   }
}