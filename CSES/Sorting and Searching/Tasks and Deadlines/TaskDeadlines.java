import java.util.*;
import java.io.*;
public class TaskDeadlines{
   static int N;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      Interval[] intervals=new Interval[N];
      for(int i=0;i<N;i++){
         intervals[i]=new Interval(io.nextLong(),io.nextLong());
      }
      Arrays.sort(intervals);
      long sum=0;
      long T=0;
      for(int i=0;i<N;i++){
         T+=intervals[i].duration;
         sum+=intervals[i].deadline-T;
      }
      io.println(sum);
      io.close();
   }
   static class Kattio extends PrintWriter {
      private BufferedReader r;
      private StringTokenizer st;
   
   	// standard input
      public Kattio() { this(System.in, System.out); }
      public Kattio(InputStream i, OutputStream o) {
         super(o);
         r = new BufferedReader(new InputStreamReader(i));
      }
   	// USACO-style file input
      public Kattio(String problemName) throws IOException {
         super(new FileWriter(problemName + ".out"));
         r = new BufferedReader(new FileReader(problemName + ".in"));
      }
   
   	// returns null if no more input
      public String next() {
         try {
            while (st == null || !st.hasMoreTokens())
               st = new StringTokenizer(r.readLine());
            return st.nextToken();
         } catch (Exception e) { }
         return null;
      }
   
      public int nextInt() { 
         return Integer.parseInt(next()); }
      public double nextDouble() { 
         return Double.parseDouble(next()); }
      public long nextLong() { 
         return Long.parseLong(next()); }
   }
}
class Interval implements Comparable<Interval>{
   long deadline;
   long duration;
   public Interval(long dur,long de){
      deadline=de;
      duration=dur;
   }
   public int compareTo(Interval o){
      return Long.compare(duration,o.duration);
   }
}