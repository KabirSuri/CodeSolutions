import java.util.*;
import java.io.*;
public class milkvisits{
   static int N;
   static int M;
   static boolean farms[];
   static boolean visited[];
   static ArrayList<Integer>[] graph;
   static int[] components;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      String str=s.nextToken();
      farms=new boolean[N];
      graph=new ArrayList[N];
      for(int i=0;i<N;i++){
         char c=str.charAt(i);
         if(c=='G')farms[i]=true;
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<N-1;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1, b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
      }
      components=new int[N];
      visited=new boolean[N];
      int count=0;
      for(int i=0;i<N;i++){
         if(!visited[i]){
            floodfill(i,farms[i],count);
            count++;
         }
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1,b=Integer.parseInt(s.nextToken())-1;
         char c=s.nextToken().charAt(0);
         boolean type=false;
         if(c=='G')type=true;
         if(components[a]!=components[b]){
            System.out.print(1);
            pw.print(1);
         }
         else{
            if(type==farms[a]){
               System.out.print(1);
               pw.print(1);
            }
            else{
               System.out.print(0);
               pw.print(0);
            }
         }
      }
      pw.println();
      pw.close();
   }
   public static void floodfill(int node, boolean type, int count){
      if(visited[node]||type!=farms[node])
         return;
      visited[node]=true;
      components[node]=count;
      for(int i=0;i<graph[node].size();i++){
         floodfill(graph[node].get(i),type,count);
      }
   }
}