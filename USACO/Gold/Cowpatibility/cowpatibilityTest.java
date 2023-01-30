import java.util.*;
import java.io.*;
public class cowpatibilityTest{
   public static int N;
   public static int combinations;
   public static ArrayList<Integer>[] flavors;
   public static int[][] cows;
   public static int pairs;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowpatibility.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowpatibility.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      flavors=new ArrayList[N];
      pairs=0;
      combinations=N*(N-1)/2;
      cows=new int[N][5];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<5;k++){
            int flavor=Integer.parseInt(s.nextToken());
            cows[i][k]=flavor;
            if(flavors[flavor]==null)flavors[flavor]=new ArrayList<Integer>();
            flavors[flavor].add(flavor);
         }
      }
      for(int i=0;i<(int)1e6;i++){
         if(flavors[i]==null||flavors[i].size()==1)continue;
         
      }
      
      System.out.println(combinations);
      pw.println(combinations);
      pw.close();
   }
}