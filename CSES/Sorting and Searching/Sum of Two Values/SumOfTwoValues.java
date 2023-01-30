import java.util.*;
import java.io.*;
public class SumOfTwoValues{
   static int N;
   static int X;
   static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      X=io.nextInt();
      int index1=-1;
      int index2=-1;
      for(int i=1;i<=N;i++){
         int num=io.nextInt();
         if(hm.get(num)==null){
            hm.put(num,i);
         }
         if(hm.get(X-num)!=null&&hm.get(X-num)!=i){
            index1=hm.get(X-num);
            index2=i;
         }
      }
      if(index1==-1){
         io.println("IMPOSSIBLE");
      }
      else{
         io.println(index1+" "+index2);
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