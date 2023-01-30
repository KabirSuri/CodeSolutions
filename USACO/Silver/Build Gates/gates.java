import java.util.*;
import java.io.*;
public class gates{
   public static int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
   public static int N;
   public static int visited[][];
   public static int yMin, xMin, yMax, xMax;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("gates.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      visited=new int[4*N+2][4*N+2];
      int count=-1,x=2*N,y=2*N;
      visited[y][x]=1;
      s=new StringTokenizer(br.readLine());
      String str=s.nextToken();
      yMin=y;
      xMin=x;
      yMax=y;
      xMax=x;
      for(int i=0;i<N;i++){
         char c=str.charAt(i);
         if(c=='N'){
            visited[y-1][x]=1;
            y-=2;
         }
         else if(c=='S'){
            visited[y+1][x]=1;  
            y+=2;
         }
         else if(c=='E'){
            visited[y][x+1]=1;
            x+=2;
         }
         else{
            visited[y][x-1]=1;
            x-=2;
         }
         yMin=Math.min(yMin,y);
         xMin=Math.min(xMin,x);
         yMax=Math.max(yMax,y);
         xMax=Math.max(xMax,x);
         visited[y][x]=1;
      }
      /*for(int i=yMin-1;i<=yMax+1;i++){
         for(int k=xMin-1;k<=xMax+1;k++){
            System.out.print(visited[i][k]+",");
         }
         System.out.println();
      }*/
      for(int i=yMin-1;i<=yMax+1;i++){
         for(int k=xMin-1;k<=xMax+1;k++){
            if(isValid(i,k)){
               floodfill(i,k);
               count++;
            }
         }
      }
      /*System.out.println();
      for(int i=yMin-1;i<=yMax+1;i++){
         for(int k=xMin-1;k<=xMax+1;k++){
            System.out.print(visited[i][k]+",");
         }
         System.out.println();
      }*/
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void floodfill(int y, int x){
      visited[y][x]=1;
      for(int i=0;i<4;i++){
         int newX=x+directions[i][1];
         int newY=y+directions[i][0];
         if(isValid(newY,newX))
            floodfill(newY, newX);
      }
   }
   public static boolean isValid(int y, int x){
      return y>=yMin-1&&y<=yMax+1&&x>=xMin-1&&x<=xMax+1&&visited[y][x]==0;
   }  
}