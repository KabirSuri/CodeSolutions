/* java.util.*;
import java.io.*;
public class RectangularPasure{
   static int N;
   static int K;
   static int[] xs;
   static int[] ys;
   static Integer[] cows;
   static int[][] prefix;
   public static void main(String[] args) throws IOException{
      Kattio io=new Kattio();
      N=io.nextInt();
      cows=new Integer[N];
      xs=new int[N];
      ys=new int[N];//Coordinate Compression
      for(int i=1;i<=N;i++){
         xs[i-1]=io.nextInt();
         ys[i-1]=io.nextInt();
         cows[i-1]=i;
      }
      prefix=new int[N+1][N+1];
      Arrays.sort(cows,Comparator.comparingInt(j->xs[j-1]));
      System.out.println(Arrays.toString(cows));
      for(int x=1;x<=N;x++){
         xs[cows[x-1]-1]=x;
      }
      Arrays.sort(cows,Comparator.comparingInt(j->ys[j-1]));
      for(int y=1;y<=N;y++){
         ys[cows[y-1]-1]=y;
         prefix[xs[cows[y-1]-1]][ys[cows[y-1]-1]]++;
      }
      for(int i=1;i<=N;i++){
         for(int k=1;k<=N;k++){
            prefix[i][k]=prefix[i][k]+prefix[i-1][k]+prefix[i][k-1]-prefix[i-1][k-1];
         }
         System.out.println(Arrays.toString(prefix[i]));
      }
      int ans=N+1;
      for(int i=1;i<=N;i++){
         for(int k=i+1;k<=N;k++){
            ans+=sum(Math.min(xs[i-1],xs[k-1]),1,Math.max(xs[i-1],xs[k-1]),Math.max(ys[i-1],ys[k-1]))
            *sum(Math.min(xs[i-1],xs[k-1]),Math.max(ys[i-1],ys[k-1]),Math.min(xs[i-1],xs[k-1]),N);
         }
      }
      io.println(ans);
      io.close();
   }
   public static int sum(int x1, int y1, int x2, int y2){
      return prefix[x2][y2]-prefix[x1-1][y2]-prefix[x2][y1-1]+prefix[x1-1][x2-1];
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
}*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class RectangularPasure {
    static int[][] sums;
 
    static int getSum(int fromX, int toX, int fromY, int toY) {
        return sums[toX][toY] - sums[fromX - 1][toY] - sums[toX][fromY - 1] + sums[fromX - 1][fromY - 1];
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cows = new Integer[n];
        for (int j = 0; j < n; j++) {
            xs[j] = in.nextInt();
            ys[j] = in.nextInt();
            cows[j] = j;
        }
        Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
        for (int x = 1; x <= n; x++) {
            xs[cows[x - 1]] = x;
        }
        Arrays.sort(cows, Comparator.comparingInt(j -> ys[j]));
        for (int y = 1; y <= n; y++) {
            ys[cows[y - 1]] = y;
        }
        sums = new int[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            sums[xs[j]][ys[j]]++;
        }
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (x > 0) {
                    sums[x][y] += sums[x - 1][y];
                }
                if (y > 0) {
                    sums[x][y] += sums[x][y - 1];
                }
                if (x > 0 && y > 0) {
                    sums[x][y] -= sums[x - 1][y - 1];
                }
            }
        }
        long answer = n + 1;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                answer += getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), 1, Math.min(ys[j], ys[k]))
                        * getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), Math.max(ys[j], ys[k]), n);
            }
        }
        System.out.println(answer);
    }
}