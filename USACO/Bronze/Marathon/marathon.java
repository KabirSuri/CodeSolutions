import java.util.*;
import java.io.*;
public class marathon{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("marathon.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken());
      int[][] positions=new int[N][2];
      int[] distances=new int[N];
      
      s=new StringTokenizer(br.readLine());
      int prevX=Integer.parseInt(s.nextToken()), prevY=Integer.parseInt(s.nextToken()), total=0;
      for(int i=1;i<N;i++){
         s=new StringTokenizer(br.readLine());
         positions[i][0]=Integer.parseInt(s.nextToken());
         positions[i][1]=Integer.parseInt(s.nextToken());
         distances[i]=Math.abs(positions[i][0]-prevX)+Math.abs(positions[i][1]-prevY);
         total+=distances[i];
         prevX=positions[i][0];
         prevY=positions[i][1];
      }
      int minDist=total;
      for(int index=1;index<N-1;index++){
         int temp=total-distances[index]-distances[index+1];
         temp+=Math.abs(positions[index+1][0]-positions[index-1][0])+Math.abs(positions[index+1][1]-positions[index-1][1]);
         minDist=Math.min(temp,minDist);
      }
      
      System.out.println(minDist);
      pw.println(minDist);
      pw.close();
   }
}