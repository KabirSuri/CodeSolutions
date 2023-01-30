import java.util.*;
import java.io.*;
public class helpcross{
   public static int N;
   public static int C;
   public static int count=0;
   public static PriorityQueue<Integer> chickens=new PriorityQueue<Integer>();
   public static ArrayList<Cow> cows=new ArrayList<Cow>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "helpcross.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      C=Integer.parseInt(s.nextToken());
      N=Integer.parseInt(s.nextToken());
      for(int i=0;i<C;i++){
         s=new StringTokenizer(br.readLine());
         chickens.add(Integer.parseInt(s.nextToken()));
      }
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         cows.add(new Cow(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())));
      }
      Collections.sort(cows);
      while(chickens.size()>0&&cows.size()>0){
         int i=0;
         int chicken=chickens.poll();
         for(int k=0;k<cows.size()&&(cows.get(k).end<chicken||cows.get(k).start>chicken);k++)i++;
         if(i<cows.size()&&cows.get(i).start<=chicken&&cows.get(i).end>=chicken){
            cows.remove(i);
            count++;
         }
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}
class Cow implements Comparable<Cow>{
   public int start;
   public int end;
   public Cow(int s, int e){
      start=s;
      end=e;
   }
   public String toString(){
      return "("+start+","+end+")";
   }
   public int compareTo(Cow o){
      if(end==o.end)
         return start-o.start;
      return end-o.end;
   }
}