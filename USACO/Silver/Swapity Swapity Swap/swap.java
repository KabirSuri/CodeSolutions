import java.util.*;
import java.io.*;
public class swap{
   static int N;
   static int M;
   static int K;
   static int[] cows;
   static int[] answer;
   static int[][] moves;
   static boolean[] visited;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("swap.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      moves=new int[M][2];
      cows=new int[N];
      answer=new int[N];
      visited=new boolean[N];
      for(int i=0;i<N;i++){
         cows[i]=i+1;
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         moves[i][0]=Integer.parseInt(s.nextToken())-1;
         moves[i][1]=Integer.parseInt(s.nextToken())-1;
      }
      int k=0;
      for(int m=0;m<M;m++){
         int start=moves[m][0];
         int end=moves[m][1];
         int length=end-start+1;
         for(int i=0;i<length/2;i++) {
            int t=cows[i+start];
            cows[i+start]=cows[length-i-1+start];
            cows[length-i-1+start]=t;
         }
      }
      for(int i=0;i<N;i++){
         if(!visited[i]){
            visited[i]=true;
            ArrayList<Integer> cycle=new ArrayList<Integer>();
            int start=i;
            int a=cows[start]-1;
            cycle.add(start);
            while(a!=start){
               visited[a]=true;
               cycle.add(a);
               a=cows[a]-1;
            }
            int iter=K%cycle.size();
            for(int j=0;j<cycle.size();j++){
               answer[cycle.get(j)]=cycle.get((j+iter)%cycle.size())+1;
            }
         }
      }
      for(int i=0;i<N;i++){
         pw.println(answer[i]);
         System.out.println(answer[i]);
      }
      pw.close();
   }
}