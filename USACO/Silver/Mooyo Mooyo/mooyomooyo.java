import java.util.*;
import java.io.*;
public class mooyomooyo{
   public static int N;
   public static int K;
   public static int board[][];
   public static int count;
   public static boolean loop=true;
   public static boolean valid;
   public static int vectors[][]={{1,0},{0,1},{-1,0},{0,-1}};
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      board=new int[N][10];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<10;k++){
            board[i][k]=Integer.parseInt(str.substring(k,k+1));
         }
      }
      int track=0;
      while(loop){
         track++;
         loop=false;
         boolean visited[][]=new boolean[N][10];
         for(int i=0;i<N;i++){
            for(int k=0;k<10;k++){
               valid=false;
               if(board[i][k]!=0&&!visited[i][k]){
                  count=0;
                  dfs(i,k,visited,false);
                  if(valid){
                     count=0;
                     valid=false;
                     dfs(i,k,new boolean[N][10],true);
                  }
               }
            }
         }
         for(int k=0;k<10;k++){
            int zCount=0;
            for(int i=N-1;i>=0;i--){
               if(board[i][k]==0)zCount++;
               else if(zCount>0){
                  int color=board[i][k];
                  board[i][k]=0;
                  board[i+zCount][k]=color;
               }
            }
         }
      }
      for(int i=0;i<N;i++){
         for(int k=0;k<10;k++){
            System.out.print(board[i][k]);
            pw.print(board[i][k]);
         }
         System.out.println();
         pw.println();
      }
      pw.close();
   }
   public static void dfs(int x, int y, boolean[][] visited, boolean turnZero){
      if(visited[x][y])
         return;
      visited[x][y]=true;
      if(valid)return;
      if(!turnZero)count++;
      for(int i=0;i<4;i++){
         int newX=x+vectors[i][0];
         int newY=y+vectors[i][1];
         if(newX>=0&&newX<N&&newY>=0&&newY<10&&!visited[newX][newY]&&board[newX][newY]==board[x][y])
            dfs(newX,newY,visited,turnZero);
      }
      if(turnZero)board[x][y]=0;
      if(count>=K){
         loop=true;
         valid=true;
         return;
      }
   }
}