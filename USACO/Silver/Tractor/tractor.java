import java.util.*;
import java.io.*;
public class tractor{
   public static int N;
   public static int count;
   public static int hills[][];
   public static double half;
   public static boolean visited[][];
   public static int directions[][]={{1,0},{-1,0},{0,1},{0,-1}};
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("tractor.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tractor.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      half=(N*N)/2.0;
      hills=new int[N][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            hills[i][k]=Integer.parseInt(s.nextToken());
         }
      }
      int start=0;
      int end=1000000;
      while(start!=end){
         int mid=(start+end)/2;
         int max=0;
         visited=new boolean[N][N];
         for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
               if(!visited[i][k]){
                  count=0;
                  floodfill(i,k,mid);
                  max=Math.max(max,count);
               }
            }
         }
         boolean works=(double)max>=half;
         if(works){
            end=mid;
         }
         else start=mid+1;
      }
      System.out.println(start);
      pw.println(start);
      pw.close();
   }
   public static void floodfill(int x, int y, int cost){
      if(visited[x][y])
         return;
      visited[x][y]=true;
      count++;
      for(int i=0;i<4;i++){
         int xNew=x+directions[i][0];
         int yNew=y+directions[i][1];
         if(xNew>=0&&xNew<N&&yNew>=0&&yNew<N&&Math.abs(hills[xNew][yNew]-hills[x][y])<=cost){
            floodfill(xNew,yNew,cost);
         }
      }
   }
}