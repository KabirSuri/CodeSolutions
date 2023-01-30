import java.util.*;
import java.io.*;
public class SumOfThreeValues{
   static int N;
   static int X;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      X=io.nextInt();
      Value values[]=new Value[N];
      for(int i=0;i<N;i++){
         values[i]=new Value(io.nextInt(),i+1);
      }
      Arrays.sort(values);
      int a=0,b=1,c=N-1;
      for(b=1;b<N-1;b++){
         boolean works=false;
         a=0;
         c=N-1;
         //System.out.println("b:"+b);
         while(a<b&&b<c){
            if(values[a].value+values[b].value+values[c].value<X)a++;
            else if(values[a].value+values[b].value+values[c].value>X)c--;
            else{
               works=true;
               break;
            }
         }
         if(works)break;
      }
      if(!(c>b&&b>a))io.println("IMPOSSIBLE");
      else io.println(values[a].origPos+" "+values[b].origPos+" "+values[c].origPos);
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
class Value implements Comparable<Value>{
   int origPos;
   int value;
   public Value(int v, int o){
      value=v;
      origPos=o;
   }
   public int compareTo(Value other){
      return value-other.value;
   }
}