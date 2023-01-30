import java.util.*;
import java.io.*;
public class cruise{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cruise.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cruise.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()), M=Integer.parseInt(s.nextToken()), K=Integer.parseInt(s.nextToken());
      ArrayList<Integer> traversal=new ArrayList<Integer>();
      int[][] graph=new int[N][2];
      int sequence[]=new int[M];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         graph[i][0]=Integer.parseInt(s.nextToken())-1;
         graph[i][1]=Integer.parseInt(s.nextToken())-1;
      }
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<M;i++){
         String str=s.nextToken();
         sequence[i]=0;
         if(str.equals("R"))sequence[i]=1;
      }
      boolean visited[]=new boolean[N];
      int iterator=0, port=0;
      traversal.add(port);
      for(iterator=0;iterator<K;iterator++){
         visited[port]=true;
         for(int i:sequence)port=graph[port][i];
         traversal.add(port);
         if(visited[port])break;
      }
      int ans=traversal.get(iterator);
      iterator++;
      if(visited[port]){
         int firstTime=-1;
         for(int i=0;i<traversal.size();i++){
            if(traversal.get(i).equals(traversal.get(iterator))){
               firstTime=i;
               break;
            }
         }
         ans=firstTime+(K-firstTime)%(iterator-firstTime);
      }
      ans=traversal.get(ans);
      ans++;
      System.out.println(ans);
      pw.println(ans);
      pw.close();
   }
}