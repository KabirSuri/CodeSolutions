import java.util.*;
import java.io.*;
public class clocktree{
   public static int N;
   public static ArrayList<Integer>[] graph;
   public static int clocks[];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int[] clocksCopy=new int[N];
      clocks=new int[N];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         clocksCopy[i]=Integer.parseInt(s.nextToken());
      }
      graph=new ArrayList[N];
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<N-1;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         graph[a].add(b);
         graph[b].add(a);
      }
      //System.out.println(Arrays.toString(graph));
      int count=0;
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            clocks[k]=clocksCopy[k];
         }
         if(clocks[i]!=12){
            /*System.out.println(Arrays.toString(clocks));
            System.out.println("dfs");*/
            dfs(i,true,false,-1);
            if(allTwelve())count++;
         }
         //System.out.println();
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void dfs(int room, boolean start, boolean leaf, int previousRoom){
      if(!start)clocks[room]++;
      if(leaf&&clocks[previousRoom]!=12)dfs(previousRoom,false,true,room);
      /*System.out.println(room);
      System.out.println(Arrays.toString(clocks));*/
      for(int neighbors:graph[room]){
         if(neighbors!=previousRoom&&clocks[neighbors]<12){
            dfs(neighbors,false,false,room);
            break;
         }
      }
      if(previousRoom>-1&&clocks[previousRoom]<12&&graph[room].size()==1){
         dfs(previousRoom,false,true,room);
      }
   }
   public static boolean allTwelve(){
      for(int i=0;i<N;i++){
         if(clocks[i]!=12)
            return false;
      }
      return true;
   }
}