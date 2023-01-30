import java.util.*;
import java.io.*;
public class danceMooves{
   public static int N;
   public static int K;
   public static HashSet<Integer>[] allPositions;
   public static int[] current;
   public static int[] ending;
   public static boolean visited[];
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      ending=new int[N];
      current=new int[N];
      allPositions=new HashSet[N];
      for(int i=0;i<N;i++){
         ending[i]=i;
         current[i]=i;
         allPositions[i]=new HashSet<Integer>();
         allPositions[i].add(i);
      }
      for(int i=0;i<K;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         int temp=current[a];
         current[a]=current[b];
         current[b]=temp;
         allPositions[current[a]].add(a);
         allPositions[current[b]].add(b);
         ending[current[a]]=a;
         ending[current[b]]=b;
      }
      visited=new boolean[N];
      StringBuffer out=new StringBuffer();
      for(int i=0;i<N;i++){
         dfs(i,i);
         out.append(allPositions[ending[i]].size()+"\n");
      }
      System.out.print(out);
   }
   public static void dfs(int original, int i){
      if(visited[i])return;
      visited[i]=true;
      dfs(original,ending[i]);
      if(original!=i)
         allPositions[original].addAll(allPositions[i]);
      ending[i]=original;
   }
}