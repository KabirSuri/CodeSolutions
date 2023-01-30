import java.util.*;
import java.io.*;
public class lazy{
   static int N;
   static int K;
   static int[][] field;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio("lazy");
      N=io.nextInt();
      K=io.nextInt();
      field=new int[2*N][2*N];
      int X=0,Y=N-1;
      boolean yHasReached0=false;
      for(int i=0;i<N;i++){
         int x=X,y=Y;
         for(int k=0;k<N;k++){
            //System.out.println(x+" "+y);
            field[x+1][y+1]=io.nextInt();
            x++;
            y++;
         }
         X++;
         if(!yHasReached0){
            Y--;
            yHasReached0=Y==0;
         }
         else Y++;
      }
      for(int i=1;i<2*N;i++){
         for(int k=1;k<2*N;k++){
            field[i][k]+=field[i-1][k]+field[i][k-1]-field[i-1][k-1];
         }
      }
      int maxSum=0;
      int add=Math.min(2*K,2*N-2);
      for(int i=1;i+add<2*N;i++){
         for(int k=1;k+add<2*N;k++){
            maxSum=Math.max(maxSum,field[i+add][k+add]-field[i-1][k+add]-field[i+add][k-1]+field[i-1][k-1]);
         }
      }
      io.println(maxSum);
      System.out.println(maxSum);
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