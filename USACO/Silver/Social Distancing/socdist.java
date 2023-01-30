import java.util.*;
import java.io.*;
public class socdist{
   public static Interval[] intervals;
   public static int N;
   public static int M;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      intervals=new Interval[M];
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         intervals[i]=new Interval(Long.parseLong(s.nextToken()),Long.parseLong(s.nextToken()));
      }
      Arrays.sort(intervals);
      long a=1,b=1000000000000000000L;
      while(a!=b){
         long mid=(a+b+1)/2;
         if(works(mid)){
            a=mid;
         }
         else{
            b=mid-1;
         }
      }
      pw.println(a);
      pw.close();
   }
   public static boolean works(long D){
      long pos=intervals[0].s;
      int g=0;
      for(int i=1;i<N;i++){
         long copy=pos;
         if(pos+D>intervals[g].e){
            while(pos+D>intervals[g].e){
               g++;
               if(g>=M)
                  return false;
               copy=Math.max(intervals[g].s,pos+D);
            }
         }
         else copy=pos+D;
         pos=copy;
      }
      return true;
   }
}
class Interval implements Comparable<Interval>{
   long s;
   long e;
   public Interval(long S, long E){
      s=S;
      e=E;
   }
   public int compareTo(Interval other){
      return Long.compare(s,other.s);
   }
   public String toString(){
      return s+" to "+e;
   }
}