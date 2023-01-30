import java.util.*;
import java.io.*;
public class cowpatibility{
   public static int N;
   public static int combinations;
   public static HashSet<Integer>[] cows;
   public static boolean[][] pairs;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowpatibility.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowpatibility.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      cows=new HashSet[N];
      pairs=new boolean[N][N];
      combinations=N*(N-1)/2;
      for(int i=0;i<N;i++){
         cows[i]=new HashSet<Integer>();
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<5;k++){
            int flavor=Integer.parseInt(s.nextToken());
            cows[i].add(flavor);
            for(int j=0;j<i;j++){
               if(!pairs[i][j]&&cows[j].contains(flavor)){
                  pairs[i][j]=true;
                  combinations--;
               }
            }
         }
      }
      
      System.out.println(combinations);
      pw.println(combinations);
      pw.close();
   }
}