import java.util.*;
import java.io.*;
public class CellularNetwork{
   static int N;
   static int M;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      M=io.nextInt();
      int cities[]=new int[N];
      int towers[]=new int[M];
      for(int i=0;i<N;i++){
         cities[i]=io.nextInt();
      }
      for(int i=0;i<M;i++){
         towers[i]=io.nextInt();
      }
      int min=0;
      //int pointer1=0;
      int pointer2=0;
      for(int pointer1=0;pointer1<N;pointer1++){
         int tempMin=Math.abs(cities[pointer1]-towers[pointer2]);
         while(pointer2+1<M&&Math.abs(cities[pointer1]-towers[pointer2+1])<=tempMin){
            pointer2++;
            tempMin=Math.abs(cities[pointer1]-towers[pointer2]);
         }
         min=Math.max(tempMin,min);
      }
      io.println(min);
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