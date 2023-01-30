import java.util.*;
import java.io.*;
public class perimeter{
   static int N;
   static boolean[][] visited;
   static char[][] map;
   static int area=0;
   static int perimeter=0;
   static int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
   static int a;
   static int p;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      map=new char[N][N];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<N;k++){
            map[i][k]=str.charAt(k);
         }
      }
      
      visited=new boolean[N][N];
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(!visited[i][k]&&map[i][k]=='#'){
               a=0;
               p=0;
               floodfill(i,k);
               if(a>area||(a==area&&p<perimeter)){
                  area=a;
                  perimeter=p;
               }
            }
         }
      }
      System.out.println(area+" "+perimeter);
      pw.println(area+" "+perimeter);
      pw.close();
   }
   public static void floodfill(int x, int y){
      visited[x][y]=true;
      a++;
      for(int i=0;i<4;i++){
         int newX=x+directions[i][0];
         int newY=y+directions[i][1];
         if(newX>=0&&newX<N&&newY>=0&&newY<N&&map[newX][newY]=='#'){
            if(!visited[newX][newY])floodfill(newX,newY);
         }
         else p++;
      }
   }
}