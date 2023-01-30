import java.util.*;
import java.io.*;
public class TheyAreEverywhere{
   static int N;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      HashSet<String> allTypes=new HashSet<>();
      HashMap<String,Integer> currentSet=new HashMap<String,Integer>();
      String[] flats=new String[N];
      String flatString=io.next();
      for(int i=0;i<N;i++){
         flats[i]=flatString.substring(i,i+1);
         allTypes.add(flats[i]);
      }
      int a=0;
      int b=0;
      int min=Integer.MAX_VALUE;
      while(a<=b&&b<N){
         if(currentSet.get(flats[b])==null)currentSet.put(flats[b],0);
         currentSet.put(flats[b],currentSet.get(flats[b])+1);
         //System.out.println(a+" "+b);
         //System.out.println(currentSet);
         while(currentSet.size()==allTypes.size()){
            //System.out.println("readjust");
            min=Math.min(b-a+1,min);
            if(currentSet.get(flats[a])==1)currentSet.remove(flats[a]);
            else currentSet.put(flats[a],currentSet.get(flats[a])-1);
            a++;
         }
         b++;
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