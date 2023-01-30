import java.util.*;
import java.io.*;
public class ccski{
   public static int vectors[][]={{1,0},{0,1},{-1,0},{0,-1}};
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("ccski.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int M=Integer.parseInt(s.nextToken());
      int N=Integer.parseInt(s.nextToken());
      int[][] hills=new int[M][N];
      int[][] wayPoints=new int[M][N];
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            hills[i][k]=Integer.parseInt(s.nextToken());
         }
      }
      int totalPoints=0;
      int startX=0,startY=0;
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            wayPoints[i][k]=Integer.parseInt(s.nextToken());
            if(wayPoints[i][k]==1){
               startX=i;
               startY=k;
               totalPoints++;
            }
         }
      }
      Queue<Pair> pairs;
      int visitedPoints;
      boolean[][] visited;
      int start=0, end=1000000000;
      while (start!=end) {
         int mid=(start+end)/2;
         visitedPoints=0;
         pairs=new LinkedList<Pair>();
         visited=new boolean[M][N];
         for(int i=0;i<M;i++){
            for(int k=0;k<N;k++){
               visited[i][k]=false;
            }
         }
         pairs.add(new Pair(startX,startY));
         visited[startX][startY]=true;
         while(!pairs.isEmpty()){
            Pair p=pairs.remove();
            if(wayPoints[p.x][p.y]==1){
               visitedPoints++;
               if(visitedPoints==totalPoints)
                  break;
            }
            for(int i=0;i<4;i++){
               int xNew=p.x+vectors[i][0];
               int yNew=p.y+vectors[i][1];
               if(xNew>=0&&xNew<M&&yNew>=0&&yNew<N&&!visited[xNew][yNew]&&Math.abs(hills[p.x][p.y]-hills[xNew][yNew])<=mid){
                  visited[xNew][yNew]=true;
                  pairs.add(new Pair(xNew, yNew));
               }
            }
         }
         if(visitedPoints==totalPoints){
            end=mid;
         }
         else{
            start=mid+1;
         }
      }
   
      System.out.println(start);
      pw.println(start);
      pw.close();
   }
}
class Pair{
   int x;
   int y;
   public Pair(int x, int y){
      this.x=x;
      this.y=y;
   }
}