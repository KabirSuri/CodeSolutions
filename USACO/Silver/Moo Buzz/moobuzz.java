import java.util.*;
import java.io.*;
public class moobuzz{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      long N=Long.parseLong(s.nextToken());
      long div=(N-1)/8;
      long mod=(N-1)%8+1;
      long index=0;
      int numCount=0;
      for(int i=0;i<15;i++){
         index++;
         if((i)%3!=0&&(i)%5!=0)numCount++;
         if(numCount==mod)break;
      }
      long answer=div*(long)15+index-1;
      System.out.println(answer);
      pw.println(answer);
      pw.close();
   }
}
