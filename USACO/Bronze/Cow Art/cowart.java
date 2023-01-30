import java.util.*;
import java.io.*;
public class cowart{
   public static int N;
   public static char graph[][];
   public static boolean visited[][];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowart.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowart.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      
      graph=new char[N][N];
      visited=new boolean[N][N];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<N;k++){
            graph[i][k]=str.charAt(k);
         }
      }
      
      int humanColor=0;
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(!visited[i][k]){
               floodfill(i,k,graph[i][k]);
               humanColor++;
            }
         }
      }
      visited=new boolean[N][N];
      int cowColor=0;
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(!visited[i][k]){
               char c=graph[i][k];
               if(c=='R'||c=='G')c='O';
               floodfill(i,k,c);
               cowColor++;
            }
         }
      }
      System.out.println(humanColor+" "+cowColor);
      pw.println(humanColor+" "+cowColor);
      pw.close();
   }
   public static void floodfill(int x, int y, char color){
      if(visited[x][y])
         return;
      visited[x][y]=true;
      int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
      for(int i=0;i<4;i++){
         int newX=x+directions[i][0];
         int newY=y+directions[i][1];
         if(newX<0||newX>=N)
            continue;
         if(newY<0||newY>=N)
            continue;
         if(color==graph[newX][newY])
            floodfill(newX,newY,color);
         else if(color=='O'&&(graph[newX][newY]=='R'||graph[newX][newY]=='G'))
            floodfill(newX,newY,color);
      }
   }
}