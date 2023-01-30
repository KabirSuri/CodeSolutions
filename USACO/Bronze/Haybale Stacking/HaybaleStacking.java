import java.util.*;
import java.io.*;
public class HaybaleStacking{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("stacking.in"));
      //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int K=Integer.parseInt(s.nextToken());
      int[] prefix=new int[N+2];
      for(int i=0;i<K;i++){
         s=new StringTokenizer(br.readLine());
         prefix[Integer.parseInt(s.nextToken())]++;
         prefix[Integer.parseInt(s.nextToken())]--;
      }
      for(int i=1;i<=N;i++){
         prefix[i]+=prefix[i-1];
      }
      Arrays.sort(prefix);
      //System.out.println(Arrays.toString(prefix));
      System.out.println(prefix[(N+2)/2+1]);
      //pw.println(prefix[(N+2)/2+1]);
      //pw.close();
   }
}