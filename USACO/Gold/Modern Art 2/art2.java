import java.util.*;
import java.io.*;
public class art2{
   public static int N;
   public static Stack<Integer> base=new Stack<Integer>();
   public static Interval[] intervals;
   public static int[] painting;
   public static int answer=-1;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("art2.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("art2.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      painting=new int[N+1];
      intervals=new Interval[N+1];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int color=Integer.parseInt(s.nextToken());
         painting[i]=color;
         if(color!=0){
            if(intervals[color]==null)intervals[color]=new Interval(i,i);
            intervals[color].end=i;
         }
      }
      for(int i=0;i<N;i++){
         int color=painting[i];
         if(base.size()>0&&(color==0||intervals[color].start<intervals[base.peek()].start||(intervals[color].start<intervals[base.peek()].start&&i>intervals[base.peek()].end))){
            answer=-1;
            break;
         }
         if(color>0&&intervals[color].start==i)base.add(color);
         answer=Math.max(answer,base.size());
         if(color>0&&intervals[color].end==i)base.pop();
      }
      System.out.println(answer);
      pw.println(answer);
      pw.close();
   }
}
class Interval{
   int start;
   int end;
   public Interval(int s, int e){
      start=s;
      end=e;
   }
}