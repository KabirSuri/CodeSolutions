import java.util.*;
import java.io.*;
public class StudyingAlgorithms{
   static int N;
   static int X;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      X=io.nextInt();
      ArrayList<Integer> arr=new ArrayList<Integer>();
      for(int i=0;i<N;i++){
         arr.add(io.nextInt());
      }
      int sum=0;
      int count=0;
      Collections.sort(arr);
      for(int i:arr){
         if(i+sum>X)break;
         count++;
         sum+=i;
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