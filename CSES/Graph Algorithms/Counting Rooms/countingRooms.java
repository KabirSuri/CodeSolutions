import java.util.*;
import java.io.*;
public class countingRooms{
   public static boolean[][] isWall;
   public static boolean[][] visited;
   public static int N;
   public static int M;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      isWall=new boolean[N][M];
      visited=new boolean[N][M];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<M;k++){
            if(str.charAt(k)=='#')isWall[i][k]=true;
         }
      }
      int color=0;
      for(int i=0;i<N;i++){
         for(int k=0;k<M;k++){
            if(!isWall[i][k]&&!visited[i][k]){
               dfs(i,k);
               color++;
            }
         }
      }
      System.out.println(color);
   }
   public static void dfs(int x, int y){
      if(x<0||x>=N||y<0||y>=M||visited[x][y]||isWall[x][y]){
         return;
      }
      visited[x][y]=true;
      dfs(x-1,y);
      dfs(x,y-1);
      dfs(x+1,y);
      dfs(x,y+1);
   }
}