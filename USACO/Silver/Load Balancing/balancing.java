import java.util.*;
import java.io.*;
public class balancing{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int[][] x=new int[N][2];
      int[][] y=new int[N][2];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken()), b=Integer.parseInt(s.nextToken());
         x[i][0]=a;
         x[i][1]=b;
         y[i][0]=a;
         y[i][1]=b;
      }
      Arrays.sort(x, (a, b) -> a[0]-b[0]);
      Arrays.sort(y, (a, b) -> a[1]-b[1]);
       
      int minMax=Integer.MAX_VALUE;
      int q2=0,q1=N;
      for(int i=0;i<N;i++){
         q2++;
         q1--;
         if(i<N-1&&x[i][0]==x[i+1][0])
            continue;
         int xWall=x[i][0]+1;
         int before1=q1, before2=q2;
         int q3=0, q4=0;
         for(int k=0;k<N;k++){
            if(y[k][0]<xWall){
               q2--;
               q3++;
            }
            else{
               q1--;
               q4++;
            }
            if(k<N-1&&y[k][1]==y[k+1][1])
               continue;
            minMax=Math.min(minMax,Math.max(Math.max(q1,q2),Math.max(q3,q4)));
         }
         q1=before1;
         q2=before2;
      }
      
      System.out.println(minMax);
      pw.println(minMax);
      pw.close();
   }
}