import java.util.*;
import java.io.*;
public class wormsort{
   public static int N;
   public static int M;
   public static int[] cows;
   public static ArrayList<Connection>[] connections;
   public static int[] floodfill;
   public static boolean works=false;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      connections=new ArrayList[N];
      cows=new int[N];
      s=new StringTokenizer(br.readLine());
      boolean ordered=true;
      for(int i=0;i<N;i++){
         cows[i]=Integer.parseInt(s.nextToken())-1;
         if(cows[i]!=i)ordered=false;
      }
      for(int i=0;i<N;i++){
         connections[i]=new ArrayList<Connection>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1,b=Integer.parseInt(s.nextToken())-1,w=Integer.parseInt(s.nextToken());
         connections[a].add(new Connection(b,w));
         connections[b].add(new Connection(a,w));
      }
      if(ordered)pw.println(-1);
      else{
         int a=0,b=1000000000;
         while(a!=b) {
            int mid=(a+b+1)/2;
            if(works(mid)) {
               a=mid;
            }
            else {
               b=mid-1;
            }
         }
         System.out.println(b);
         pw.println(b);
      }
      pw.close();
   }
   public static boolean works(int width){
      int color=0;
      floodfill=new int[N];
      for(int i=0;i<N;i++){
         if(floodfill[i]==0){
            color++;
            dfs(i,width,color);
         }
      }
      for(int i=0;i<N;i++){
         if(floodfill[i]!=floodfill[cows[i]])return false;
      }
      return true;
   }
   public static void dfs(int loc,int width, int color){
      if(floodfill[loc]>0)return;
      floodfill[loc]=color;
      for(int i=0;i<connections[loc].size();i++){
         if(connections[loc].get(i).w>=width){
            dfs(connections[loc].get(i).b,width,color);
         }
      }
   }
}
class Connection{
   int b;
   int w;
   public Connection(int B, int W){
      b=B;
      w=W;
   }
   public String toString(){
      return "("+b+","+w+")";
   }
}