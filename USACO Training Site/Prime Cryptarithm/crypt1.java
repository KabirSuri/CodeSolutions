/*
ID: surikab1
LANG: JAVA
TASK: crypt1
*/
import java.util.*;
import java.io.*;
public class crypt1{
   public static int N;
   public static boolean inSet[];
   public static int count=0;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      inSet=new boolean[10];
      int[] set=new int[N];
      for(int i=0;i<N;i++){
         set[i]=Integer.parseInt(s.nextToken());
         inSet[set[i]]=true;
      }
      for(int i=0;i<set.length;i++){
         int a=set[i];
         for(int j=0;j<set.length;j++){
            int b=set[j];
            for(int k=0;k<set.length;k++){
               int c=set[k];
               for(int l=0;l<set.length;l++){
                  int d=set[l];
                  for(int m=0;m<set.length;m++){
                     int e=set[m];
                     check(a,b,c,d,e);
                  }
               }
            }
         }
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void check(int a, int b, int c, int d, int e){
      int abc=a*100+b*10+c;
      int partial1=e*abc;
      int partial2=d*abc;
      if(partial1/1000>0||partial2/1000>0)return;
      String oneStr=partial1+"";
      String twoStr=partial2+"";
      for(int i=0;i<oneStr.length();i++){
         if(!inSet[Integer.parseInt(oneStr.charAt(i)+"")])return;
      }
      for(int i=0;i<twoStr.length();i++){
         if(!inSet[Integer.parseInt(twoStr.charAt(i)+"")])return;
      }
      int product=partial1+(partial2*10);
      String productStr=product+"";
      for(int i=0;i<productStr.length();i++){
         if(!inSet[Integer.parseInt(productStr.charAt(i)+"")])return;
      }
      count++;
   }
}