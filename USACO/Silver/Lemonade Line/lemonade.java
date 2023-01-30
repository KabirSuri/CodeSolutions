import java.util.*;
import java.io.*;
public class lemonade{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken());
      int[] cows=new int[N];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         cows[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(cows);
      int length=0;
      for(int i=cows.length-1;i>=0;i--){
         if(cows[i]>=length)
            length++;
      }
      
      //System.out.println(length);
      pw.println(length);
      pw.close();
   }
}