/*
ID: surikab1
LANG: JAVA
TASK: numtri
*/
import java.util.*;
import java.io.*;
public class numtri{
   public static int N;
   public static int triangle[][];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      triangle=new int[N][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int j=0;j<=i;j++){
            triangle[i][j]=Integer.parseInt(s.nextToken());
         }
      }
      /*for(int i=0;i<N;i++){
         System.out.println(Arrays.toString(triangle[i]));
      }
      System.out.println();*/
      alterTriangle(N-2);
      /*
      for(int i=0;i<N;i++){
         System.out.println(Arrays.toString(triangle[i]));
      }
      System.out.println();*/
      System.out.println(triangle[0][0]);
      pw.println(triangle[0][0]);
      pw.close();
   }
   public static void alterTriangle(int row){
      if(row==-1)return;
      for(int i=0;i<=row;i++){
         triangle[row][i]+=Math.max(triangle[row+1][i],triangle[row+1][i+1]);
      }
      alterTriangle(row-1);
   }
}