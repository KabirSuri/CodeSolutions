import java.util.*;
import java.io.*;
public class lifeguards{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      Shift shifts[]=new Shift[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         shifts[i]=new Shift(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
      }
      Arrays.sort(shifts);
      int start=-1;
      int end=-1;
      int minLoss=Integer.MAX_VALUE;
      int totalTime=0;
      for(int i=0;i<N;i++){
         int nextstart=shifts[i].end+1;
         if(i<N-1)nextstart=shifts[i+1].start;      
         int a=shifts[i].start;
         int b=shifts[i].end;
         if(end>shifts[i].start)a=end;
         if(end>shifts[i].end)b=end;
         else if(shifts[i].end>nextstart)b=nextstart;
         int loss=b-a; 
         if(loss>=0)minLoss=Math.min(loss,minLoss);
         if(end<shifts[i].start){
            totalTime+=(end-start);
            start=shifts[i].start;
         }
         end=Math.max(shifts[i].end,end);
         if(i==N-1)totalTime+=(end-start);
      }
      System.out.println(minLoss);
      System.out.println(totalTime-minLoss);
      pw.println(totalTime-minLoss);
      pw.close();
   }
}
class Shift implements Comparable<Shift>{
   int start;   
   int end;
   public Shift(int a, int b){
      start=a;
      end=b;
   }
   public int compareTo(Shift o){
      if(start==o.start)return end-o.end;
      return start-o.start;
   }
}