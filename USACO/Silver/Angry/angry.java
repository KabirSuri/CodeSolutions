import java.util.*;
import java.io.*;
public class angry{
   public static int N;
   public static int K;
   public static long bales[];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("angry.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      bales=new long[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         bales[i]=Long.parseLong(s.nextToken());
      }
      Arrays.sort(bales);
      long start=0;
      long end=500000000;
      while(start!=end){
         long mid=(start+end)/2;
         if(works(mid))end=mid;
         else start=mid+1;
      }
      System.out.println(start);
      pw.println(start);
      pw.close();
   }
   public static boolean works(long radius){
     long diameter=radius*2;
      int index=0;
      for(int k=0;k<K;k++){
         if(index>=N)
            break;
         long end=bales[index]+diameter;
         while(index<N&&bales[index]<=end)index++;
      }
      if(index<N)
         return false;
      return true;
   }
}