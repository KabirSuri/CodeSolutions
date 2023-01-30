import java.util.*;
import java.io.*;
public class connectTwoBarns{
   public static int N;
   public static int M;
   public static ArrayList<Integer>[] graph;
   public static ArrayList<TreeSet<Integer>> components;
   public static boolean[] visited;
   public static int nComp;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("connectTwoBarns.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int T=Integer.parseInt(s.nextToken());
      StringBuffer out=new StringBuffer();
      for(int t=0;t<T;t++){
         //System.out.println("t: "+t);
         s=new StringTokenizer(br.readLine());
         N=Integer.parseInt(s.nextToken());
         M=Integer.parseInt(s.nextToken());
         graph=new ArrayList[N];
         visited=new boolean[N];
         components=new ArrayList<TreeSet<Integer>>();
         for(int i=0;i<N;i++){
            graph[i]=new ArrayList<Integer>();
         }
         for(int i=0;i<M;i++){
            s=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(s.nextToken())-1;
            int b=Integer.parseInt(s.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
         }
         nComp=0;
         int cc=0;
         for(int i=0;i<N;i++){
            if(!visited[i]){
               components.add(new TreeSet<Integer>());
               dfs(i,cc);
               cc++;
            }
         }
         long min=Long.MAX_VALUE;
         //if(t==17)
         //System.out.println(components);
         for(int c=0;c<cc;c++){
            int distanceOne=Integer.MAX_VALUE;
            int distanceTwo=Integer.MAX_VALUE;
            for(int i:components.get(c)){
               Integer lowerA=components.get(0).floor(i);
               Integer higherA=components.get(0).ceiling(i);
               Integer lowerB=components.get(nComp).floor(i);
               Integer higherB=components.get(nComp).ceiling(i);
               distanceOne=Math.min(distanceOne,Math.abs(lowerA-i));
               if(higherA!=null)
               distanceOne=Math.min(distanceOne,Math.abs(higherA-i));
               if(lowerB!=null)
               distanceTwo=Math.min(distanceTwo,Math.abs(lowerB-i));
               distanceTwo=Math.min(distanceTwo,Math.abs(higherB-i));
            }
            min=Math.min(min,(long)distanceOne*(long)distanceOne+(long)distanceTwo*(long)distanceTwo);
         }
         //System.out.println(distanceOne+" "+distanceTwo);
         out.append(min);
         if(t<T-1)out.append("\n");
      }
      System.out.println(out);
   }
   public static void dfs(int a,int co){
      if(visited[a])
         return;
      if(a==N-1)nComp=co;
      visited[a]=true;
      components.get(co).add(a);
      for(int i:graph[a]){
         dfs(i,co);
      }
   }
}