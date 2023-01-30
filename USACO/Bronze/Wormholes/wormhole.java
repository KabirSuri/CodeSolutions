/*
ID: surikab1
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;
public class wormhole{
   public static int N;
   public static Wormhole[] wormholes;
   public static boolean visited[];
   public static int nextRight[];
   public static boolean found;
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      wormholes=new Wormhole[N];
      visited=new boolean[N];
      nextRight=new int[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         wormholes[i]=new Wormhole(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
      }
      for(int index=0;index<N;index++){
         int minX=Integer.MAX_VALUE;
         nextRight[index]=-1;
         for(int i=0;i<N;i++){
            //System.out.println("index: 
            if(wormholes[i].y==wormholes[index].y&&wormholes[i].x>wormholes[index].x&&wormholes[i].x<minX){
               minX=wormholes[i].x;
               nextRight[index]=i;
            }
         }
      }
      //System.out.println(Arrays.toString(nextRight));
      int total=generatePerms();
      System.out.println(total);
      pw.println(total);
      pw.close();
   }
   public static int generatePerms(){
      int i=0,total=0;
      for (i=0;i<N;i++) 
         if(wormholes[i].pair==-1) 
            break;
      if (i==N) {
         /*for(i=0;i<N;i++){
            System.out.print(wormholes[i].pair+" ");
         }
         System.out.println();*/
         if(traverse())return 1;
         else return 0;
      }
      for (int j=i+1; j<N; j++)
         if (wormholes[j].pair==-1) {
            wormholes[j].pair=i;
            wormholes[i].pair=j;
            total+=generatePerms();
            wormholes[j].pair=-1;
            wormholes[i].pair=-1;
         }
      return total;
   }
   public static boolean traverse(){
      for(int start=0;start<N;start++){
         int pos=start;
         for(int count=0;count<N;count++){
            if(pos==-1)break;
            pos=nextRight[wormholes[pos].pair];
         }
         if(pos!=-1)return true;
      }
      return false;
   }
}
class Wormhole{
   int pair;
   int x;
   int y;
   public Wormhole(int X, int Y){
      x=X;
      y=Y;
      pair=-1;
   }
}