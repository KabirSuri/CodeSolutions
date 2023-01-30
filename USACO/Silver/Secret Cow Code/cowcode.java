import java.util.*;
import java.io.*;
public class cowcode{
   public static String str;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      str=s.nextToken();
      long N=Long.parseLong(s.nextToken());
      char c=parse(N);
      
      System.out.println(c);
      pw.println(c);
      pw.close();
   }
   public static char parse(long N){
      if(N<=str.length()){
         return str.charAt((int) N-1);
      }
      long length=str.length();
      while(2*length<N){
         length*=2;
      }
      if(length+1 !=N){
         return parse(N-(length+1));
      }
      else{
         return parse(N-1);
      }
   }
}