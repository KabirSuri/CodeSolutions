import java.util.*;
import java.io.*;
public class planting{
   static int N;
   static int[] fields;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("planting.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      fields=new int[N];
      for(int i=0;i<N-1;i++){
         s=new StringTokenizer(br.readLine());
         fields[Integer.parseInt(s.nextToken())-1]++;
         fields[Integer.parseInt(s.nextToken())-1]++;
      }
      int grass=0;
      for(int i=0;i<N;i++){
         grass=Math.max(grass,fields[i]);
      }
      
      System.out.println(grass+1);
      pw.println(grass+1);
      pw.close();
   }
}