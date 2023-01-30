import java.util.*;
import java.io.*;
public class lightson{
   static boolean lit[][];
   static boolean visited[][];
   static ArrayList<int[]>[][] lights;
   static int N;
   static int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int M=Integer.parseInt(s.nextToken());
      visited=new boolean[N][N];
      lit=new boolean[N][N];
      lights= new ArrayList[N][N];
      
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            lights[i][k]=new ArrayList<int[]>();
         }
      }
      
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int x=Integer.parseInt(s.nextToken())-1,y=Integer.parseInt(s.nextToken())-1,a=Integer.parseInt(s.nextToken())-1,b=Integer.parseInt(s.nextToken())-1;
         int arr[]={a,b};
         lights[x][y].add(arr);
      }
      
      lit[0][0]=true;
      floodfill(0,0);
      
      int count=0;
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(lit[i][k])count++;
         }
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void floodfill(int x, int y){
      if(!isAccessible(x,y))return;
      visited[x][y]=true;
      for(int i=0;i<lights[x][y].size();i++){
         int[] arr=lights[x][y].get(i);
         lit[arr[0]][arr[1]]=true;
         floodfill(arr[0],arr[1]);
      }
      for(int i=0;i<4;i++){
         int newX=x+directions[i][0];
         int newY=y+directions[i][1];
         if(isValid(newX,newY))floodfill(newX,newY);
      }
   }
   public static boolean isAccessible(int x, int y){
      if(visited[x][y]||!lit[x][y])return false;
      if(x==0&&y==0)return true;
      boolean condition=false;
      for(int i=0;i<4;i++){
         int newX=x+directions[i][0];
         int newY=y+directions[i][1];
         if(isValid(newX,newY)&&visited[newX][newY])return true;
      }
      return false;
   }
   public static boolean isValid(int x, int y){
      return x>=0&&x<N&&y>=0&&y<N;
   }
}