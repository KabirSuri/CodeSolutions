import java.util.*;
import java.io.*;
public class MovieFestival{
   static int N;
   static int X;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      ArrayList<Movie> arr=new ArrayList<Movie>();
      for(int i=0;i<N;i++){
         arr.add(new Movie(io.nextInt(),io.nextInt()));
      }
      int time=0;
      int count=0;
      Collections.sort(arr);
      for(Movie i:arr){
         if(i.start<time)continue;
         count++;
         time=i.end;
      }
      io.println(count);
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
class Movie implements Comparable<Movie>{
   int start;
   int end;
   public Movie(int s,int e){
      start=s;
      end=e;
   }
   public int compareTo(Movie other){
      if(end==other.end){
         return start-other.start;
      }
      return end-other.end;
   }
}