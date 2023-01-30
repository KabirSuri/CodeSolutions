import java.util.*;
import java.io.*;
public class decorate{
   static ArrayList<Integer> graph[];
   static int F;
   static int J;
   static int totalJ=0;
   static boolean works=true;
   static boolean letters[];
   static boolean visited[];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("decorate.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()), M=Integer.parseInt(s.nextToken());
      graph=new ArrayList[N];
      letters=new boolean[N];
      visited=new boolean[N];
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
      }
      //System.out.println(Arrays.toString(graph));
      for(int i=0;i<N;i++){
         if(!visited[i]){
            F=0;
            J=0;
            dfs(i,true);
            totalJ+=Math.max(F,J);
            if(!works){
               totalJ=-1;
               break;
            }
         }
      }
      //System.out.println(Arrays.toString(visited));
      //System.out.println(Arrays.toString(letters));
               
      System.out.println(totalJ);
      pw.println(totalJ);
      pw.close();
   }
   public static void dfs(int pasture, boolean letter){
      if(!works)return;
      if(letter)F++;
      else J++;
      letters[pasture]=letter;
      visited[pasture]=true;
      for(int i:graph[pasture]){
         if(!visited[i])
            dfs(i,!letter);
         else if(letters[i]==letter){
            works=false;
            return;
         }
      }
   }
}