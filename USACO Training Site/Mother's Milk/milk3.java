/*
ID: surikab1
LANG: JAVA
TASK: milk3
*/
import java.util.*;
import java.io.*;
public class milk3{
   public static TreeSet<Integer> quantities=new TreeSet<Integer>();
   public static boolean[][][] visited;
   public static int[] capacities;
   public static int[][] transitions={{0,1},{0,2},{1,0},{1,2},{2,1},{2,0}};
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      capacities=new int[3];
      for(int i=0;i<3;i++){
         capacities[i]=Integer.parseInt(s.nextToken());
      }
      int[] milk={0,0,capacities[2]};
      visited=new boolean[21][21][21];
      dfs(milk);
      int first=quantities.first();
      quantities.remove(first);
      System.out.print(first);
      pw.print(first);
      for(int i:quantities){
         System.out.print(" "+i);
         pw.print(" "+i);
      }
      pw.println();
      System.out.println();
      pw.close();
   }
   public static void dfs(int milk[]){
      if(visited[milk[0]][milk[1]][milk[2]])
         return;
      visited[milk[0]][milk[1]][milk[2]]=true;
      if(milk[0]==0)quantities.add(milk[2]);
      int a=milk[0];
      int b=milk[1];
      int c=milk[2];
      for(int i=0;i<transitions.length;i++){
         transfer(transitions[i][0],transitions[i][1],milk);
         dfs(milk);
         milk[0]=a;
         milk[1]=b;
         milk[2]=c;
      }
   }
   public static void transfer(int from, int to, int[] milk){
      if(capacities[to]<milk[to]+milk[from]){
         milk[from]=milk[from]-(capacities[to]-milk[to]);
         milk[to]=capacities[to];
      }
      else{
         milk[to]+=milk[from];
         milk[from]=0;
      }
   }
}