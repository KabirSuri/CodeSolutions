/*
ID: surikab1
LANG: JAVA
TASK: palsquare
*/
import java.util.*;
import java.io.*;
public class palsquare{
   public static int B;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      B=Integer.parseInt(s.nextToken());
      for(int i=1;i<=300;i++){
         String numStringSquared=convert((i*i)+"",10,B).toUpperCase();
         if(isPalindrome(numStringSquared)){
            String numString=convert(i+"",10,B).toUpperCase();
            System.out.println(numString+" "+numStringSquared);
            pw.println(numString+" "+numStringSquared);
         }
      }
      pw.close();
   }
   public static String convert(String num, int source, int destination){
      return Integer.toString(Integer.parseInt(num, source), destination);
   }
   public static boolean isPalindrome(String num){
      for(int i=0;i<num.length()/2;i++){
         if(num.charAt(i)!=num.charAt(num.length()-1-i))return false;
      }
      return true;
   }
}