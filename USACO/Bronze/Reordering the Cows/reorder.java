import java.util.*;
import java.io.*;
public class reorder{
   public static int count; 
   public static int connections[];
   public static boolean visited[];
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("reorder.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reorder.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      visited=new boolean[N];
      int[] A=new int[N];
      int max=-1;
      connections=new int[N];
      int cycles=0;
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         A[Integer.parseInt(s.nextToken())-1]=i;
      }
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         connections[A[Integer.parseInt(s.nextToken())-1]]=i;
      }
      
      for(int i=0;i<N;i++){
         count=0;
         if(!visited[i]&&connections[i]!=i){
            cycles++;
            floodfill(i);
            max=Math.max(max,count);
         }
      }
      
      System.out.println(cycles+" "+max);
      pw.println(cycles+" "+max);
      pw.close();
   }
   public static void floodfill(int i){
      if(visited[i])
         return;
      count++;
      visited[i]=true;
      floodfill(connections[i]);
   }
}