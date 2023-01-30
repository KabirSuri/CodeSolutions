/*
ID: surikab1
LANG: JAVA
TASK: milk
*/
import java.util.*;
import java.io.*;
public class milk{
   public static int N;
   public static int M;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("milk.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      Farmer[] farmers=new Farmer[M];
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         farmers[i]=new Farmer(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
      }
      Arrays.sort(farmers);
      int milkSum=0;
      int centSum=0;
      int i=0;
      while(milkSum!=N){
         int dMilk=Math.min(farmers[i].units,N-milkSum);
         milkSum+=dMilk;
         centSum+=farmers[i].cost*dMilk;
         i++;
      }
      System.out.println(centSum);
      pw.println(centSum);
      pw.close();
   }
}
class Farmer implements Comparable<Farmer>{
   int units;
   int cost;
   public Farmer(int c, int u){
      units=u;
      cost=c;
   }
   public int compareTo(Farmer o){
      return cost-o.cost;
   }
}