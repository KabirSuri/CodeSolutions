import java.util.*;
import java.io.*;
public class cowfind{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowfind.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowfind.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      String str=s.nextToken();
      int count=0;
      int hindlegs=0;
      for(int i=0;i<str.length()-1;i++){
         if(str.charAt(i)=='('&&str.charAt(i+1)=='(')hindlegs++;
         else if(str.charAt(i)==')'&&str.charAt(i+1)==')')count+=hindlegs;
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}