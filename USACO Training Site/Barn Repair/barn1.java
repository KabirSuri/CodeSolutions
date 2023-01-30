/*
ID: surikab1
LANG: JAVA
TASK: barn1
*/
import java.util.*;
import java.io.*;
public class barn1{
   public static int M;
   public static int S;
   public static int C;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      M=Integer.parseInt(s.nextToken());
      S=Integer.parseInt(s.nextToken());
      C=Integer.parseInt(s.nextToken());
      PriorityQueue<Integer> gaps=new PriorityQueue<Integer>(Collections.reverseOrder());
      int[] stalls=new int[C];
      for(int i=0;i<C;i++){
         s=new StringTokenizer(br.readLine());
         stalls[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(stalls);
      for(int i=1;i<C;i++){
         gaps.add(stalls[i]-stalls[i-1]-1);
      }
      int blocked=stalls[C-1]-stalls[0]+1;
      for(int i=1;i<M;i++){
         if(gaps.size()>0)blocked-=gaps.remove();
      }
      System.out.println(blocked);
      pw.println(blocked);
      pw.close();
   }
}