import java.util.*;
import java.io.*;
public class paintbarn{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()), K=Integer.parseInt(s.nextToken());
      int[][] arr=new int[201][201];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine()); 
         int x1=Integer.parseInt(s.nextToken())+1, y1=Integer.parseInt(s.nextToken())+1, x2=Integer.parseInt(s.nextToken())+1, y2=Integer.parseInt(s.nextToken())+1;
         arr[x1][y1]++;
         arr[x1][y2]--;
         arr[x2][y1]--;
         arr[x2][y2]++;
      }
      int totalArea=0;
      for(int i=1;i<=9;i++){
         for(int k=1;k<=9;k++){
            arr[i][k]+=arr[i-1][k]+arr[i][k-1]-arr[i-1][k-1];
            if(arr[i][k]==K)totalArea++;
         }
         System.out.println(Arrays.toString(arr[i]));
      }
      
      System.out.println(totalArea);
      pw.println(totalArea);
      pw.close();
   }
}