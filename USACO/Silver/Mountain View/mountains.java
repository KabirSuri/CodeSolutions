import java.util.*;
import java.io.*;
public class mountains{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int count=N;
      boolean[] visited=new boolean[N];
      Peak[] peaks=new Peak[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         peaks[i]=new Peak(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
      }
      Arrays.sort(peaks);
      int leftest=peaks[N-1].l;
      int rightest=peaks[0].r;
      
      for(int i=N-2;i>=0;i--){
         if(leftest<=peaks[i].l&&!visited[i]){
            count--;
            visited[i]=true;
         }
         leftest=Math.min(leftest,peaks[i].l);
      }
      
      for(int i=1;i<N;i++){
         if(rightest>=peaks[i].r&&!visited[i])count--;
         rightest=Math.max(rightest,peaks[i].r);
      }
      
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}
class Peak implements Comparable<Peak>{
   int l;
   int r;
   int c;
   Peak(int x, int y){
      l=x-y;
      r=x+y;
      c=x;
   }
   public int compareTo(Peak o){
      if(c==o.c)return l-o.l;
      return c-o.c;
   }
}