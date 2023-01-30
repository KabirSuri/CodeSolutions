import java.util.*;
import java.io.*;
public class poker{
   public static int N;
   public static int[] poker;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("poker.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("poker.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      poker=new int[N];
      int zeroCount=0;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         poker[i]=Integer.parseInt(s.nextToken());
         if(poker[i]==0)zeroCount++;
      }
      int start=0;
      int straights=0;
      while(zeroCount!=N){
         while(start<N&&poker[start]==0)start++;
         int end=start;
         int minHeight=poker[start];
         while(end<N&&poker[end]!=0){
            minHeight=Math.min(minHeight,poker[end]);
            end++;
         }
         //System.out.println(Arrays.toString(poker));
         //System.out.println("minHeight: "+minHeight);
         if(start<N&&end<=N)
            for(int i=start;i<end;i++){
               poker[i]-=minHeight;
               if(poker[i]==0)zeroCount++;
            }
         straights+=minHeight;
      }
      System.out.println(straights);
      pw.println(straights);
      pw.close();
   }
}