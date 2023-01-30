import java.util.*;
import java.io.*;
public class snowboots{
   public static int N;
   public static int B;
   public static int path[];
   public static int boots[][];
   public static boolean visited[][];
   public static int min;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      B=Integer.parseInt(s.nextToken());
      min=B;
      path=new int[N];
      boots=new int[B][2];
      visited=new boolean[N][B];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         path[i]=Integer.parseInt(s.nextToken());
      }
      for(int i=0;i<B;i++){
         s=new StringTokenizer(br.readLine());
         boots[i][0]=Integer.parseInt(s.nextToken());
         boots[i][1]=Integer.parseInt(s.nextToken());
      }
      dfs(0,0);
      
      System.out.println(min);
      pw.println(min);
      pw.close();
   }
   public static void dfs(int pos, int boot){
      if(pos==N-1){
         min=Math.min(min,boot);
         return;
      }
      if(boot>=min)
         return;
      if(visited[pos][boot])
         return;
      visited[pos][boot]=true;
      if(boots[boot][0]<path[pos]){
         return;
      }
      for(int i=boot+1;i<B;i++){
         if(path[pos]<=boots[i][0]){
            dfs(pos,i);
         }
      }
      if(path[pos]<=boots[boot][0]){
         int step=boots[boot][1];
         int endValue=Math.min(N-1,pos+step);
         for(int i=pos+1;i<=endValue;i++){
            if(path[i]<=boots[boot][0]){
               dfs(i,boot);
            }
         }
      }
   }
}