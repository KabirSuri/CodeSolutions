import java.util.*;
import java.io.*;
public class hshoe{
   public static int max=0; 
   public static int N;
   public static int[][] grid;
   public static boolean[][] visited;
   public static int[][] move={{-1,0},{0,1},{1,0},{0,-1}};
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("hshoe.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hshoe.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      grid=new int[N][N];
      visited=new boolean[N][N];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<N;k++){
            if(str.charAt(k)=='(')grid[i][k]=1;
            else grid[i][k]=-1;
         }
      }
      
      floodfill(0,0,0,0);
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
   public static void floodfill(int x, int y, int open, int end){
      if(grid[x][y]==-1)end++;
      else{
         if(end>0||2*end>N*N)return;
         open++;
      }
      if(end==open){
         max=Math.max(max,end*2);
         return;
      }
      visited[x][y]=true;
      for(int i=0;i<4;i++){
         int newX=x+move[i][0];
         int newY=y+move[i][1];
         if(newX>=0&&newX<N&&newY>=0&&newY<N&&!visited[newX][newY]){
            floodfill(newX,newY,open,end);
         }
      }
      visited[x][y]=false;
   }
}