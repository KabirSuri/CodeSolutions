import java.util.*;
import java.io.*;
public class JustGreen{
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
      String graph=xMin+" "+yMin+" "+xMax+" "+yMax;
      if(xMin>xMax||yMin>yMax){
         return;
      }
      if(visited.contains(graph)){
         return;
      }
      //System.out.println(graph);
      int[] coor1={yMin,xMin};
      int[] coor2={yMax,xMax};
      visited.add(graph);
      boolean small1=false;
      boolean small2=false;
      boolean big=true;
      for(int i=yMin;i<=yMax;i++){
         for(int k:bad.get(i)){
            if(xMin<=k&&xMax>=k){
               small1=true;
               if(i!=coor2[0]&&k!=coor2[1]){
                  coor1[0]=i;
                  coor1[1]=k;
               }
            }
         }
         for(int k=bad.get(i).size()-1;k>=0;k--){
            if(xMin<=bad.get(i).get(k)&&xMax>=bad.get(i).get(k)){
               small2=true;
               if(i!=coor1[0]&&k!=coor1[1]){
                  coor2[0]=i;
                  coor2[1]=bad.get(i).get(k);
               }
            }
         }
         for(int k:needed.get(i)){
            if(xMin<=k&&xMax>=k){
               big=false;
            }
         }
         if(small1&&small2){
            break;
         }
      }
      if(!small1&&!big){
         /*System.out.print("("+yMin+","+xMin+"), ");
         System.out.print("("+yMax+","+xMin+"), ");
         System.out.print("("+yMin+","+xMax+"), ");
         System.out.println("("+yMax+","+xMax+")");
         System.out.println();*/
         photos++;
      }
      dfs(xMin,coor1[0]+1,xMax,coor2[0]);
      dfs(xMin,coor1[0],xMax,coor2[0]-1);
      dfs(coor1[1]+1,yMin,coor2[1],yMax);
      dfs(coor1[1],yMin,coor2[1]-1,yMax);
   }
}  