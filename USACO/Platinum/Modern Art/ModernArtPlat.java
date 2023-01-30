import java.util.*;
import java.io.*;
public class ModernArtPlat{
   public static int[][] arr;
   public static boolean[] isSecondary;
   public static boolean[][] visited;
   public static int[][] rectangles;
   public static int N;
   public static int[][] vectors={{1,0},{0,1},{-1,0},{0,-1}};
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio("art");
      N=io.nextInt();
      arr=new int[N+2][N+2];
      isSecondary=new boolean[N*N+1];
      rectangles=new int[4][N*N+1];
      Arrays.fill(rectangles[0],Integer.MAX_VALUE);
      Arrays.fill(rectangles[1],Integer.MAX_VALUE);
      for(int i=1;i<=N;i++){
         for(int k=1;k<=N;k++){
            int color=io.nextInt();
            arr[i][k]=color;
            rectangles[0][color]=Math.min(i,rectangles[0][color]);
            rectangles[1][color]=Math.min(k,rectangles[1][color]);
            rectangles[2][color]=Math.max(i,rectangles[2][color]);
            rectangles[3][color]=Math.max(k,rectangles[3][color]);
         }
      }
      visited=new boolean[N+2][N+2];
      for(int i=1;i<=N;i++){
         for(int k=1;k<=N;k++){
            if(!visited[i][k]&&arr[i][k]!=0){
               dfs(i,k);
            }
         }
      }
      int ans=0;
      for(int i=1;i<=N*N;i++){
         if(!isSecondary[i])ans++;
      }
      
      System.out.println(ans);
      io.println(ans);
      io.close();
   }
   public static void dfs(int x, int y){
      if(visited[x][y])return;
      visited[x][y]=true;
      int color=arr[x][y];
      for(int[] vector:vectors){
         int newX=x+vector[0];
         int newY=y+vector[1];
         if(arr[newX][newY]==color)dfs(newX,newY);
         else if(newX>=rectangles[0][color]&&newX<=rectangles[2][color]&&newY>=rectangles[1][color]&&newY<=rectangles[3][color]){
            isSecondary[arr[newX][newY]]=true;
         }
      }
   }
   static class Kattio extends PrintWriter {
      private BufferedReader r;
      private StringTokenizer st;
   
   	// standard input
      public Kattio() { this(System.in, System.out); }
      public Kattio(InputStream i, OutputStream o) {
         super(o);
         r = new BufferedReader(new InputStreamReader(i));
      }
   	// USACO-style file input
      public Kattio(String problemName) throws IOException {
         super(new FileWriter(problemName + ".out"));
         r = new BufferedReader(new FileReader(problemName + ".in"));
      }
   
   	// returns null if no more input
      public String next() {
         try {
            while (st == null || !st.hasMoreTokens())
               st = new StringTokenizer(r.readLine());
            return st.nextToken();
         } catch (Exception e) { }
         return null;
      }
   
      public int nextInt() { 
         return Integer.parseInt(next()); }
      public double nextDouble() { 
         return Double.parseDouble(next()); }
      public long nextLong() { 
         return Long.parseLong(next()); }
   }
}