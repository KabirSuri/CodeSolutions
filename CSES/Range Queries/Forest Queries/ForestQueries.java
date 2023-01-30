import java.util.StringTokenizer;
import java.io.*;
public class ForestQueries{
   static int N;
   static int Q;
   static int[][] forest;
   static int[][] arr;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      Q=io.nextInt();
      forest=new int[N+1][N+1];
      arr=new int[N+1][N+1];
      for(int i=1;i<=N;i++){
         String str=io.next();
         for(int k=1;k<=N;k++){
            if(str.charAt(k-1)=='*')arr[i][k]++;
         }
      }
      for(int i=1;i<=N;i++){
         for(int k=1;k<=N;k++){
            forest[i][k]=arr[i][k]
                        +forest[i-1][k]
                        +forest[i][k-1]
                        -forest[i-1][k-1];
         }
      }
      for(int i=0;i<Q;i++){
         int a=io.nextInt(),b=io.nextInt(),c=io.nextInt(),d=io.nextInt();
         io.println(
                           forest[c][d]
                           -forest[a-1][d]
                           -forest[c][b-1]
                           +forest[a-1][b-1]
                           );
      }
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