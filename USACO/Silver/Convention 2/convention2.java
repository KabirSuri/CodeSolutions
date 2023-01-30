import java.util.*;
import java.io.*;
public class convention2{
   public static Cow[] seniorities;
   public static Cow[] arrivals;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "convention2.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      seniorities=new Cow[N];
      arrivals=new Cow[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         Cow c=new Cow(Long.parseLong(s.nextToken()),Long.parseLong(s.nextToken()),i);
         seniorities[i]=c;
         arrivals[i]=c;
      }
      Arrays.sort(arrivals);
      PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
      long max=-1;
      long time=0;
      for(int i=0;i<arrivals.length;i++){
         queue.add(arrivals[i].i);
         time=Math.max(time, arrivals[i].a);
         for(int k=i+1;k<arrivals.length&&arrivals[k].a==arrivals[i].a;k++){
            queue.add(arrivals[k].i);
            i++;
         }
         while(queue.size()!=0){
            Cow cow=seniorities[queue.poll()];
            max=Math.max(max,time-cow.a);
            time+=cow.t;
            for(int m=i+1;m<arrivals.length&&arrivals[m].a<=time;m++){
               queue.add(arrivals[m].i);
               i++;
            }
         }
      }
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}
class Cow implements Comparable<Cow>{
   public Long a;
   public Long t;
   public int i;
   public Cow(Long A, Long T, int I){
      a=A;
      t=T;
      i=I;
   }
   public String toString(){
      return "("+a+", "+t+", "+i+")";
   }
   public int compareTo(Cow other){
      return a.compareTo(other.a);
   }
}