import java.util.*;
import java.io.*;
public class scode{
   public static int count=0;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("scode.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("scode.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      split(s.nextToken());
      
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void split(String str){
      if(str.length()==2)
         return;
      int middle=str.length()/2;
      if(str.substring(0,middle).equals(str.substring(middle+1,str.length()))){
         count+=2;
         split(str.substring(0,middle+1));
         split(str.substring(middle,str.length()));
      }
      if(str.substring(0,middle).equals(str.substring(middle,str.length()-1))){
         count++;
         split(str.substring(middle,str.length()));
      }
      if(str.substring(1,middle+1).equals(str.substring(middle+1,str.length()))){
         count++;
         split(str.substring(0,middle+1));
      }
   }
}