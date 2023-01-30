import java.util.*;
import java.io.*;
public class cereal2Redo{
   public static int N;
   public static int M;
   public static ArrayList<Integer>[] graph;
   public static int[][] cows;
   public static boolean[] used;
   public static StringBuffer out=new StringBuffer();
   public static void main(String[] args) throws IOException{
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader br = new BufferedReader(new FileReader("cereal2.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      graph=new ArrayList[M];
      cows=new int[N][2];
      used=new boolean[M];
      for(int i=0;i<M;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         cows[i][0]=a;
         cows[i][1]=b;
         graph[a].add(b);
      }
      int[][] weights=new int[N][2];
      for(int i=0;i<N;i++){
         weights[i][0]=graph[cows[i][1]].size();
         weights[i][1]=i;
      }
      Arrays.sort(weights,(a, b) -> b[0] - a[0]);
      /*for(int i=0;i<N;i++){
         System.out.println(Arrays.toString(weights[i]));
      }*/
      out.append(simulate(weights)+"\n");
      for(int i=0;i<N;i++){
         out.append((weights[i][1]+1)+"\n");
      }
      System.out.print(out);
   }
   public static int simulate(int[][] weights){
      int hungry=0;
      for(int i=0;i<N;i++){
         if(used[cows[weights[i][1]][0]]){
            if(used[cows[weights[i][1]][1]]){
               hungry++;
            }
            else{
               used[cows[weights[i][1]][1]]=true;
            }
         }
         else{
            used[cows[weights[i][1]][0]]=true;
         }
      }
      return hungry;
   }
}