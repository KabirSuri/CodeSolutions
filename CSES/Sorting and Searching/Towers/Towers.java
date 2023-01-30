import java.util.*;
import java.io.*;
public class Towers{
   static int N;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      TreeMap<Integer,Integer> towers=new TreeMap<>();
      for(int i=0;i<N;i++){
         int cube=io.nextInt();
         Integer higher=towers.higherKey(cube);
         if(higher!=null){
            if(towers.get(higher)==1)
               towers.remove(higher);
            else
               towers.put(higher,towers.get(higher)-1);
         }
         if(towers.get(cube)==null)towers.put(cube,0);
         towers.put(cube,towers.get(cube)+1);
      }
      int sum=0;
      for(int i:towers.keySet()){
         sum+=towers.get(i);
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