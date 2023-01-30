import java.util.*;
import java.io.*;
public class sort{
   public static int N;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("sort.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      Pair[] pairs=new Pair[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         pairs[i]=new Pair(Integer.parseInt(s.nextToken()),i);
      }
      Arrays.sort(pairs);
      int max=0;
      for(int i=0;i<N;i++){
         max=Math.max(pairs[i].position-i,max);
      }
      System.out.println(max+1);
      pw.println(max+1);
      pw.close();
   }
}
class Pair implements Comparable<Pair>{
   int num;
   int position;
   public Pair(int n, int p){
      num=n;
      position=p;
   }
   public int compareTo(Pair other){
      if(num==other.num)return position-other.position;
      return num-other.num;
   }
}