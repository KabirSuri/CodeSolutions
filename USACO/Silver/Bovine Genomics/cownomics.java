import java.util.*;
import java.io.*;
public class cownomics{
   public static int N;
   public static int M;
   public static boolean[][][][] spotted;
   public static HashSet<String> offenders;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      spotted=new boolean[M][M][M][64];
            
      for(int v=0;v<N;v++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int a=0;a<M;a++){
            int one=charToInt(str.charAt(a));
            for(int b=a+1;b<M;b++){
               int two=charToInt(str.charAt(b));
               for(int c=b+1;c<M;c++){
                  int three=charToInt(str.charAt(c));
                  spotted[a][b][c][16*one+4*two+three]=true;;
               }
            }
         }
      }
      offenders=new HashSet<String>();
      for(int v=0;v<N;v++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int a=0;a<M;a++){
            int one=charToInt(str.charAt(a));
            for(int b=a+1;b<M;b++){
               int two=charToInt(str.charAt(b));
               for(int c=b+1;c<M;c++){
                  int three=charToInt(str.charAt(c));
                  if(spotted[a][b][c][16*one+4*two+three])offenders.add(a+" "+b+" "+c);
               }
            }
         }
      }
      int totalCombinations=(factorial(M,(M-2)))/6;
      
      System.out.println(totalCombinations-offenders.size());
      pw.println(totalCombinations-offenders.size());
      pw.close();
   }
   public static int factorial(int num, int stop){
      if(num==stop)return num;
      return num*factorial(num-1, stop);
   }
   public static int charToInt(char c){
      if(c=='A')
         return 0;
      else if(c=='G')
         return 1;
      else if(c=='C')
         return 2;
      else 
         return 3;
   }
}