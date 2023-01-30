import java.util.*;
import java.io.*;
import java.lang.*;
public class revegetate{ 
   public static boolean zero;
   public static ArrayList<Integer>[] graph;
   public static ArrayList<Boolean>[] different;
   public static int[] grasses;
   public static int N;
   public static int M;
   public static boolean visited[];
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      
      visited=new boolean[N];
      graph=new ArrayList[N];
      different=new ArrayList[N];
      long total=1;
      grasses=new int[N];
      int cycles=0;
      
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
         different[i]=new ArrayList<Boolean>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         boolean c=false;
         if(s.nextToken().equals("S"))c=true;
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
         different[a].add(c);
         different[b].add(c);
      }
      String answer="1";
      for(int i=0;i<N;i++){
         if(!visited[i]){
            zero=false;
            grasses[i]=1;
            floodfill(i);
            answer+="0";
            if(zero){
               answer="0";
               break;
            }
         }
      }
      
      System.out.println(answer);
      pw.println(answer);
      pw.close();
   }
   public static void floodfill(int plot){
      if(visited[plot]||zero)return;
      visited[plot]=true;
      for(int i=0;i<graph[plot].size();i++){
         boolean difference=different[plot].get(i);
         int index=graph[plot].get(i);
         if(((difference&&grasses[plot]!=grasses[index])||(!difference&&grasses[plot]==grasses[index]))&&grasses[index]>0){
            zero=true;
            return;
         }
         else if(difference)grasses[index]=grasses[plot];
         else if(grasses[plot]==1)grasses[index]=2;
         else grasses[index]=1;
         floodfill(index);
      }
   }
}