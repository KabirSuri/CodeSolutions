import java.util.*;
import java.io.*;
public class berries{
   public static int N;
   public static int K;
   public static int[] trees;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("berries.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      trees=new int[N];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         trees[i]=Integer.parseInt(s.nextToken());   
      }
      Arrays.sort(trees);
      int max=0;
      for(int maxB=0;maxB<1000;maxB++){
         int treeCopy[]=new int[N];
         for(int i=0;i<N;i++){
            treeCopy[i]=trees[i];
         }
         for(int i=0;i<K/2;i++){
            treeCopy[N-1]-=Math.min(treeCopy[N-1],maxB);
            Arrays.sort(treeCopy);
         }
         int sum=0;
         for(int i=0;i<K/2;i++){
            sum+=Math.min(treeCopy[N-1],maxB);
            treeCopy[N-1]-=Math.min(treeCopy[N-1],maxB);
            Arrays.sort(treeCopy);
         }
         if(sum<max)break;
         max=Math.max(sum,max);
      }
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}