/*
ID: surikab1
LANG: JAVA
TASK: dualpal
*/
import java.util.*;
import java.io.*;
public class dualpal{
   public static int N;
   public static int S;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      S=Integer.parseInt(s.nextToken());
      int count=0;
      int i=S+1;
      while(count<N){
         int baseCount=0;
         for(int b=2;b<=10;b++){
            if(isPalindrome(convert(i+"",10,b))){
               baseCount++;
               if(baseCount==2){
                  System.out.println(i);
                  pw.println(i);
                  count++;
                  break;
               }
            }
         }
         i++;
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