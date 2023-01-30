import java.util.*;
import java.io.*;
public class clocktreeTest{
   public static int N;
   public static ArrayList<Integer>[] graph;
   public static int clocks[];
   public static int startTwelve;
   public static boolean allTwelve;
   public static boolean invalid;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int[] clocksCopy=new int[N];
      clocks=new int[N];
      int startCopy=0;
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         clocksCopy[i]=Integer.parseInt(s.nextToken());
         if(clocksCopy[i]==12)startCopy++;
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
         invalid=false;
         startTwelve=startCopy;
         //System.out.println("dfs");
         dfs(i,-1,i);
         if(startTwelve==N)count++;
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void dfs(int room, int previousRoom, int start){
      //clocks[room]++;
      if(clocks[room]==12)startTwelve++;
      //System.out.println(room);
      //System.out.println(Arrays.toString(clocks));
      if(invalid)
         return;
      //CHECK END NODE IF IT CAN GO BACK WITHOUT DFSING AGAIN!!!!!!
      if(graph[room].size()==1&&(previousRoom>-1&&clocks[previousRoom]==12)){
         invalid=true;
         return;
      }
      if(previousRoom>-1&&(graph[room].size()==1||graph[previousRoom].size()==1)&&clocks[previousRoom]!=12){
         clocks[previousRoom]++;
         dfs(previousRoom,room,start);
      }
      else{
         for(int i:graph[room]){
            //System.out.println("i: "+i+" previousRoom: "+previousRoom);
            if(invalid)
               return;
            if(i==previousRoom&&!(graph[room].size()==1||graph[previousRoom].size()==1)){
               continue;
            }
            if(clocks[i]==12){
               continue;
            }
            clocks[i]++;
            dfs(i,room,start);
         }
      }
   }
}