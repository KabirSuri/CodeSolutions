import java.util.*;
import java.io.*;
public class clumsy{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("clumsy.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "clumsy.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      String N=s.nextToken();
      int max=N.length()/2;
      int sum=0;
      int changes=0;
      for(int i=0;i<N.length();i++){
         if(N.charAt(i)=='(')sum++;
         else sum--;
         if(sum<0){
            sum+=2;
            changes++;
         }
      }
      changes+=sum/2;
      System.out.println(changes);
      pw.println(changes);
      pw.close();
   }
}