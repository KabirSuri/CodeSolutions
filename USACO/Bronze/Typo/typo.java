import java.util.*;
import java.io.*;
public class typo{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("typo.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("typo.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      String N=s.nextToken();
      int openingParentheses=0;   
      int closingParentheses=0;
      int sum=0;
      for(int i=0;i<N.length();i++){
         if(N.charAt(i)=='('){
            sum++;
            openingParentheses++;
         }
         else{
            sum--;
            closingParentheses++;
         }
         if(sum<2){
            openingParentheses=0;
         }
         if(sum<0)break;
      }
      if(sum<0){
         System.out.println(closingParentheses);
         pw.println(closingParentheses);
      }
      else{
         System.out.println(openingParentheses);
         pw.println(openingParentheses);
      }
      pw.close();
   }
}