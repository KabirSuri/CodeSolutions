/*
ID: surikab1
LANG: JAVA
TASK: combo
*/
import java.util.*;
import java.io.*;
public class combo{
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("combo.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      int a1=Integer.parseInt(s.nextToken()), b1=Integer.parseInt(s.nextToken()), c1=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      int a2=Integer.parseInt(s.nextToken()), b2=Integer.parseInt(s.nextToken()), c2=Integer.parseInt(s.nextToken());
      
      HashSet<String> hs=new HashSet<>();
      
      int one1,two1,three1;
      int one2,two2,three2;
      for(int a=-2;a<=2;a++){
         one1=change(a,a1);
         one2=change(a,a2);
         for(int b=-2;b<=2;b++){
            two1=change(b,b1);
            two2=change(b,b2);
            for(int c=-2;c<=2;c++){
               three1=change(c,c1);
               three2=change(c,c2);
               hs.add(one1+" "+two1+" "+three1);
               hs.add(one2+" "+two2+" "+three2);
            }
         }
      }
      //System.out.println(hs.size());
      pw.println(hs.size());
      pw.close();
   }
   public static int change(int a, int a1){
      int one1=a+a1;
      while(one1>N){
         one1-=N;
      }
      while(one1<=0){
         one1=N+one1;
      }
      return one1;
   }
}