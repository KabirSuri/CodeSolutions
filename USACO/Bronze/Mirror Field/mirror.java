import java.util.*;
import java.io.*;
public class mirror{
   public static int count; 
   public static int N;
   public static int M;
   public static char[][] mirrors;
   public static int[][] move={{-1,0},{0,1},{1,0},{0,-1}};
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("mirror.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mirror.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      mirrors=new char[N][M];
      int max=0;
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<M;k++){
            mirrors[i][k]=str.charAt(k);
         }
      }
      
      for(int i=0;i<N;i++){
         count=0;
         floodfill(i,0,1);
         max=Math.max(max,count);
         count=0;
         floodfill(i,M-1,3);
         max=Math.max(max,count);
      }
      
      for(int i=0;i<M;i++){
         count=0;
         floodfill(0,i,2);
         max=Math.max(max,count);
         count=0;
         
         floodfill(N-1,i,0);
         max=Math.max(max,count);
      }
      
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
   public static void floodfill(int x, int y, int direction){
      if(mirrors[x][y]=='/'){
         if(direction%2==0)
            direction=(direction+1)%4;
         else direction=(direction+3)%4;    
      }
      else{
         if(direction%2==0)
            direction=(direction+3)%4;
         else direction=(direction+1)%4;  
      }
      count++;
      int newX=x+move[direction][0];
      int newY=y+move[direction][1];
      if(newX>=0&&newX<N&&newY>=0&&newY<M){
         floodfill(newX,newY,direction);
      }
   }
}