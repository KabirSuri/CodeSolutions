import java.util.*;
import java.io.*;
public class JustGreen1{
   //public static int[][] field;
   public static ArrayList<ArrayList<Integer>> bad;
   public static ArrayList<ArrayList<Integer>> needed;
   public static long photos;
   public static HashSet<String> visited;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken());
      bad=new ArrayList<>();
      needed=new ArrayList<>();
      for(int i=0;i<N;i++){
         ArrayList<Integer> list=new ArrayList<>();
         ArrayList<Integer> list2=new ArrayList<>();
         bad.add(list);
         needed.add(list2);
      }
      visited=new HashSet<>();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            int value=Integer.parseInt(s.nextToken());
            if(value<100){
               bad.get(i).add(k);
            }
            else if(value==100){
               needed.get(i).add(k);
            }
         }
      }
      dfs(0,0,N-1,N-1);
      System.out.println(photos);
   }
   public static void dfs(int xMin, int yMin, int xMax, int yMax){
      if(xMin>xMax||yMin>yMax){
         return;
      }
      String graph=xMin+" "+yMin+" "+xMax+" "+yMax;
      if(visited.contains(graph)){
         return;
      }
      visited.add(graph);
      boolean small=false;
      boolean big=true;
      for(int i=yMin;i<=yMax;i++){
         for(int k:bad.get(i)){
            if(xMin<=k&&xMax>=k){
               small=true;
               break;
            }
         }
         for(int k:needed.get(i)){
            if(xMin<=k&&xMax>=k){
               big=false;
            }
         }
         if(small){
            break;
         }
      }
      if(!small&&!big){
         photos++;
      }
      dfs(xMin+1,yMin,xMax,yMax);
      dfs(xMin,yMin+1,xMax,yMax);
      dfs(xMin,yMin,xMax-1,yMax);
      dfs(xMin,yMin,xMax,yMax-1);
   }
}  