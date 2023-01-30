import java.util.*;
import java.io.*;
public class homework{
   public static int N;
   public static int questions[];
   public static Average averages[];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("homework.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "homework.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      questions=new int[N];
      averages=new Average[N-2];
      s=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
         questions[i]=Integer.parseInt(s.nextToken());
      }
      double sum=0;
      double min=Integer.MAX_VALUE;
      for(int i=N-1;i>=1;i--){
         sum+=questions[i];
         min=Math.min(questions[i],min);
         if(i<=N-2){
            averages[i-1]=new Average(i,(sum-min)/(N-i-1));
         }
      }
      Arrays.sort(averages);
      double max=averages[N-3].val;
      for(int i=N-3;i>=0&&averages[i].val==max;i--){
         System.out.println(averages[i].num);
         pw.println(averages[i].num);
      }
      pw.close();
   }
}
class Average implements Comparable<Average>{
   public int num;
   public Double val;
   public Average(int n, double v){
      num=n;
      val=v;
   }
   public String toString(){
      return "("+num+","+val+")";
   }
   public int compareTo(Average o){
      if(val.compareTo(o.val)==0)return o.num-num;
      return val.compareTo(o.val);
   }
}