import java.util.*;
import java.io.*;
public class FerrisWheel{
   static int N;
   static int X;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      X=io.nextInt();
      int[] children=new int[N];
      for(int i=0;i<N;i++){
         children[i]=io.nextInt();
      }
      Arrays.sort(children);
      int count=0;
      int pointer1=0;
      int pointer2=N-1;
      while(pointer1<=pointer2){
         //System.out.println("pointer1:"+pointer1+" pointer2:"+pointer2);
         if(children[pointer1]+children[pointer2]<=X){
            pointer1++;
         }
         count++;
         pointer2--;
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