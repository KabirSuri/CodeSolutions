import java.util.*;
import java.io.*;
public class countcross{
   static int N;
   static int K;
   static int R;
   static boolean[][] visited;
   static boolean[][][] roads;
   static int cows[][];
   static int directions[][]={{1,0},{0,1},{-1,0},{0,-1}};
   static boolean found;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      R=Integer.parseInt(s.nextToken());
      roads=new boolean[N][N][4];
      
      for(int i=0;i<R;i++){
         s=new StringTokenizer(br.readLine());
         int r=Integer.parseInt(s.nextToken())-1,c=Integer.parseInt(s.nextToken())-1,ro=Integer.parseInt(s.nextToken())-1,co=Integer.parseInt(s.nextToken())-1;
         if(r!=ro){
            if(r==ro+1){
               roads[r][c][2]=true;
               roads[ro][co][0]=true;
            }
            else{
               roads[ro][co][2]=true;
               roads[r][c][0]=true;
            }
         }
         else{
            if(c==co+1){
               roads[r][c][3]=true;
               roads[ro][co][1]=true;
            }
            else{
               roads[ro][co][3]=true;
               roads[r][c][1]=true;
            }
         }
      }
      
      cows=new int[K][2];
      for(int i=0;i<K;i++){
         s=new StringTokenizer(br.readLine());
         cows[i][0]=Integer.parseInt(s.nextToken())-1;
         cows[i][1]=Integer.parseInt(s.nextToken())-1;
      }
      
      int count=0;
      for(int i=0;i<K;i++){
         for(int k=i+1;k<K;k++){
            visited=new boolean[N][N];
            found=false;
            floodfill(cows[i][0],cows[i][1],cows[k][0],cows[k][1]);
            if(!found){
               count++;
            }
         }
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void floodfill(int x, int y,int goalX, int goalY){
      if(!isValid(x,y))
         return;
      visited[x][y]=true;
      if(x==goalX&&y==goalY){
         found=true;
         return;
      }
      for(int i=0;i<4;i++){
         if(!roads[x][y][i]){
            int newX=x+directions[i][0];
            int newY=y+directions[i][1];
            floodfill(newX,newY,goalX,goalY);
         }
      }
   }
   public static boolean isValid(int x, int y){
      return x>=0&&x<N&&y>=0&&y<N&&visited[x][y]==false;
   }
}