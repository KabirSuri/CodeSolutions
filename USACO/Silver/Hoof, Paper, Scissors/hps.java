import java.util.*;
import java.io.*;
public class hps{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("hps.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken());
      int[][] arr=new int[N+1][3];
      for(int i=1;i<=N;i++){
         s=new StringTokenizer(br.readLine());
         String c=s.nextToken();
         arr[i][0]=arr[i-1][0];
         arr[i][1]=arr[i-1][1];
         arr[i][2]=arr[i-1][2];
         if(c.equals("H")){
            arr[i][0]++;
         }
         else if(c.equals("P")){
            arr[i][1]++;
         }
         else{
            arr[i][2]++;
         }
      }
      int max=0;
      for(int i=1;i<=N;i++){
         for(int k=0;k<3;k++){
            int current=arr[i][k];
            for(int z=0;z<3;z++){
               int pending=arr[N][z]-arr[i][z];
               max=Math.max(max,current+pending);
            }
         }
      }
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}