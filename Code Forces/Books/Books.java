import java.util.*;
import java.io.*;
public class Books{
   static int N;
   static long T;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      T=io.nextLong();
      long[] books=new long[N];
      for(int i=0;i<N;i++){
         books[i]=io.nextLong();
      }
      int a=0;
      int b=0;
      while(b<N&&books[b]>T){
         a++;
         b++;
      }
      long time=0;
      int count=0;
      int max=0;
      while(b<N){
         while(b<N&&books[b]+time<=T){
            time+=books[b];
            b++;
            count++;
         }
         if(time<=T)max=Math.max(max,count);
         time-=books[a];
         a++;
         count--;
         if(a>b)b=a;
      }
      io.println(max);
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