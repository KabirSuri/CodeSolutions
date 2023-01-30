import java.util.*;
import java.io.*;
public class solveTheMaze{
   public static boolean[][] isWall;
   public static boolean[][] visited;
   public static boolean[][] isGood;
   public static boolean[][] isBad;
   public static ArrayList<Coor> badGuys;
   public static ArrayList<Coor> goodGuys;
   public static boolean works;
   public static int[][] vectors={{0,1},{1,0},{-1,0},{0,-1}};
   public static int N;
   public static int M;
   public static int T;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      T=Integer.parseInt(s.nextToken());
      for(int t=0;t<T;t++){
         s=new StringTokenizer(br.readLine());
         N=Integer.parseInt(s.nextToken());
         M=Integer.parseInt(s.nextToken());
         isWall=new boolean[N][M];
         visited=new boolean[N][M];
         isGood=new boolean[N][M];
         isBad=new boolean[N][M];
         badGuys=new ArrayList<Coor>();
         goodGuys=new ArrayList<Coor>();
         works=true;
         for(int i=0;i<N;i++){
            s=new StringTokenizer(br.readLine());
            String str=s.nextToken();
            for(int k=0;k<M;k++){
               if(str.charAt(k)=='G'){
                  isGood[i][k]=true;
                  goodGuys.add(new Coor(i,k));
               }
               else if(str.charAt(k)=='B'){
                  isBad[i][k]=true;
                  badGuys.add(new Coor(i,k));
               }
               else if(str.charAt(k)=='#')isWall[i][k]=true;
            }
         }
         for(Coor c: badGuys){
            if(!visited[c.x][c.y]){
               buildWalls(c.x,c.y);
               if(!works)
                  break;
            }
         }
         if(!works){
            System.out.println("No");
            continue;
         }
         for(Coor c: goodGuys){
            if(!visited[c.x][c.y]){
               works=false;
               escape(c.x,c.y);
               if(!works)
                  break;
            }
         }
         if(goodGuys.size()==0)works=true;
         if(!works){
            System.out.println("No");
            continue;
         }
         System.out.println("Yes");
      }
   }
   public static void buildWalls(int x, int y){
      if(visited[x][y]||!works)
         return;
      visited[x][y]=true;
      for(int[] vector: vectors){
         int newX=vector[0]+x;
         int newY=vector[1]+y;
         if(newX>=0&&newX<N&&newY>=0&&newY<M){
            if(isBad[newX][newY])buildWalls(newX,newY);
            else if(isGood[newX][newY]){
               works=false;
               return;
            }
            else{
               isWall[newX][newY]=true;
            }
         }
      }
   }
   public static void escape(int x, int y){
      if(visited[x][y]||isWall[x][y]){
         return;
      }
      if(x==N-1&&y==M-1)works=true;
      visited[x][y]=true;
      for(int[] vector: vectors){
         int newX=vector[0]+x;
         int newY=vector[1]+y;
         if(newX>=0&&newX<N&&newY>=0&&newY<M){
            escape(newX,newY);
         }
      }
   }
}
class Coor{
   int x;
   int y;
   public Coor(int X, int Y){
      x=X;
      y=Y;
   }
   public String toString(){
      return "("+x+","+y+")";
   }
}