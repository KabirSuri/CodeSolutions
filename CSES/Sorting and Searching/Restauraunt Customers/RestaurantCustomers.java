import java.util.*;
import java.io.*;
public class RestaurantCustomers{
   static int N;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      ArrayList<int[]> movements=new ArrayList<>();
      for(int i=0;i<2*N;i+=2){
         movements.add(new int[]{1,io.nextInt()});
         movements.add(new int[]{-1,io.nextInt()});
      }
      Collections.sort(movements,new Comp());
      int curCustomers=0;
      int maxCustomers=0;
      for(int i=0;i<2*N;i++){
         if(movements.get(i)[0]==1)curCustomers++;
         else curCustomers--;
         maxCustomers=Math.max(maxCustomers,curCustomers);
      }
      io.println(maxCustomers);
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
class Comp implements Comparator<int[]>{
   public int compare(int[] o1, int[] o2){
      return o1[1]-o2[1];
   }
}