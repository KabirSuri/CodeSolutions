import java.util.*;
import java.io.*;
public class cow{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cow.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "cow.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      String str=s.nextToken();
      long count=0;
      ArrayList<Long> OofC=new ArrayList<>();
      for(int i=0;i<N;i++){
         if(str.charAt(i)=='C'){
            OofC.add((long)0);
         }
         else if(str.charAt(i)=='O'&&OofC.size()>0){
            OofC.set(OofC.size()-1,OofC.get(OofC.size()-1)+1);
         }
         else{
            long Ocount=0;
            for(int k=OofC.size()-1;k>=0;k--){
               Ocount+=OofC.get(k);
               count+=Ocount;
            }
         }
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}