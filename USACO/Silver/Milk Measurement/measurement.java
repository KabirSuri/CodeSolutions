import java.util.*;
import java.io.*;
public class measurement{
   public static int N;
   public static int G;
   public static Node nodes[];
   public static TreeSet<Integer> milk=new TreeSet<Integer>();
   public static HashMap<Integer,Integer> cows=new HashMap<Integer,Integer>();
   public static HashMap<Integer,Integer> scoreboard=new HashMap<Integer,Integer>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "measurement.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(s.nextToken());
      G=Integer.parseInt(s.nextToken());
      int days=0;
      nodes=new Node[N];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int day=Integer.parseInt(s.nextToken()), ID=Integer.parseInt(s.nextToken()), change=Integer.parseInt(s.nextToken());
         nodes[i]=new Node(day,ID,change);
         cows.put(ID,G);
      }
      cows.put(-1,G);
      
      Arrays.sort(nodes);
      milk.add(G);
      scoreboard.put(G,cows.size());
      int max=milk.last();
      int numMax=scoreboard.get(max);
      for(int i=0;i<N;i++){
         int ID=nodes[i].ID, change=nodes[i].change;
         int beforeDisplay=numMax;
         boolean wasMax=cows.get(ID)==max;
         remove(cows.get(ID));
         cows.replace(ID,cows.get(ID)+change);
         add(cows.get(ID));
         max=milk.last();
         numMax=scoreboard.get(max);
         boolean isMax=(cows.get(ID)==max);
         if(beforeDisplay!=numMax||wasMax!=isMax){
            days++;
         }
      }
      
      System.out.println(days);
      pw.println(days);
      pw.close();
   }
   public static void remove(int m){
      if(scoreboard.get(m)==1){
         milk.remove(m);
         scoreboard.remove(m);
      }
      else{
         scoreboard.replace(m, scoreboard.get(m)-1);
      }
   }
   public static void add(int m){
      if(!milk.contains(m)){
         milk.add(m);
         scoreboard.put(m,1);
      }
      else{
         scoreboard.replace(m, scoreboard.get(m)+1);
      }
   }  
}
class Node implements Comparable<Node>{
   public int day;
   public int ID;
   public int change;
   public Node(int d, int i, int c){
      day=d;
      ID=i;
      change=c;
   }
   public String toString(){
      return "("+day+","+ID+","+change+")";
   }
   public int compareTo(Node o){
      return day-o.day;
   }
}