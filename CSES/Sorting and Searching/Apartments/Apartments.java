import java.util.*;
import java.io.*;
public class Apartments{
   static int N;
   static int M;
   static int K;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      M=io.nextInt();
      K=io.nextInt();
      int[] applicants=new int[N];
      int[] apartments=new int[M];
      for(int i=0;i<N;i++){
         applicants[i]=io.nextInt();
      }
      for(int i=0;i<M;i++){
         apartments[i]=io.nextInt();
      }
      int count=0;
      Arrays.sort(applicants);
      Arrays.sort(apartments);
      int pointer1=0;
      int pointer2=0;
      while(pointer1<N&&pointer2<M){
         if(Math.abs(applicants[pointer1]-apartments[pointer2])<=K){
            count++;
            pointer1++;
            pointer2++;
         }
         else if(applicants[pointer1]-K>apartments[pointer2])pointer2++;
         else pointer1++;
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