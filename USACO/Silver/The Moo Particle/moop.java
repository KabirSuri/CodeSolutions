import java.util.*;
import java.io.*;
public class moop{
   public static int N;
   public static ArrayList<Integer>[] graph;
   public static boolean[] visited;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("moop.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      ArrayList<CC> components=new ArrayList<CC>();
      visited=new boolean[N];
      graph=new ArrayList[N];
      HashMap<CC,Integer> map=new HashMap<CC,Integer>();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         graph[i]=new ArrayList<Integer>();
         components.add(new CC(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())));
         map.put(components.get(i),i);
      }
      Collections.sort(components,new xComp());
      TreeSet<CC> set=new TreeSet<CC>(new yComp());
      for(int i=0;i<N;i++){
         CC c=components.get(i);
         set.add(c);
         for(CC k:set){
            if((k.x==c.x&&k.y==c.y)||k.y>c.y)break;
            graph[map.get(k)].add(map.get(c));
            graph[map.get(c)].add(map.get(k));
         }
      }
      int colors=0;
      for(int i=0;i<N;i++){
         if(!visited[i]){
            colors++;
            dfs(i);
         }
      }
      System.out.println(colors);
      pw.println(colors);
      pw.close();
   }
   public static void dfs(int node){
      if(visited[node])return;
      visited[node]=true;
      for(int i=0;i<graph[node].size();i++){
         dfs(graph[node].get(i));
      }
   }
}
class xComp implements Comparator<CC>{
   public int compare(CC o1, CC o2){
      if(o1.x==o2.x){
         return o1.y-o2.y;
      }
      return o1.x-o2.x;
   }
}
class yComp implements Comparator<CC>{
   public int compare(CC o1, CC o2){
      if(o1.y==o2.y){
         return o1.x-o2.x;
      }
      return o1.y-o2.y;
   }
}
class CC{
   int x;
   int y;
   public CC(int X,int Y){
      x=X;
      y=Y;
   }
   public String toString(){
      return "{"+x+","+y+"}";
   }
}