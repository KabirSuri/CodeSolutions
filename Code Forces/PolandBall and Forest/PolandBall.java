import java.util.*;
import java.io.*;
public class PolandBall{
   public static boolean[] visited;
   public static int[] mostDistance;
   public static int count=0;
   public static boolean found;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      visited=new boolean[N];
      mostDistance=new int[N];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         int index=Integer.parseInt(s.nextToken())-1;
         mostDistance[i]=index;
      }
      count=0;
      for(int i=0;i<N;i++){
         if(!visited[i]){
            found=false;
            dfs(i, mostDistance[i]);
            visited[i]=true;
            if(!found)count++;
         }
      }
      System.out.println(count);
   }
   public static void dfs(int last, int index){
      if(visited[index]){
         found=true;
         return;
      }
      if(last==mostDistance[index]){
         return;
      }
      dfs(index, mostDistance[index]);
      visited[index]=true;
   }
}