import java.util.*;
import java.io.*;
public class leftout{
   public static int N;
   public static boolean[][] cows;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      cows=new boolean[N][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<N;k++)cows[i][k]=(str.charAt(k)=='R');
      }
      
      if(!cows[0][0])flipCol(0);
      for(int i=1;i<N;i++){
         if(!cows[i][0])flipRow(i);
         if(!cows[0][i])flipCol(i);
      }
      int count=0,firstX=-1,firstY=-1,lastX=-1,lastY=-1;
      
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(!cows[i][k]){
               if(count==0){
                  firstX=i;
                  firstY=k;
               }
               count++;
               lastX=i;
               lastY=k;
            }
         }
      }
      
      int x=0,y=0;
      if(count==(N*N)-(2*N-1)){
         x=1;
         y=1;
      }
      else if(lastX==firstX&&firstY==lastY){
         x=lastX+1;
         y=lastY+1;
      }
      else if(lastX==firstX){
         x=lastX+1;
         y=1;
      }
      else if(lastY==firstY){
         y=lastY+1;
         x=1;
      }
      if(x==0||y==0){
         System.out.println(-1);
         pw.println(-1);
      }
      else{
         System.out.println(x+" "+y);
         pw.println(x+" "+y);
      }
      pw.close();
   }
   public static void flipRow(int r){
      for(int i=0;i<N;i++)cows[r][i]=!cows[r][i];
   }
   public static void flipCol(int c){
      for(int i=0;i<N;i++)cows[i][c]=!cows[i][c];
   }
}