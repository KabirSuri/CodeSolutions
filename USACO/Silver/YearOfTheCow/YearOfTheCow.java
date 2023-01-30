import java.util.*;
import java.io.*;
public class YearOfTheCow{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()),K=Integer.parseInt(s.nextToken());
      HashSet<Integer> tM=new HashSet<>(); 
      TreeSet<Integer> allPoints=new TreeSet<>();
      TreeSet<Integer> tP=new TreeSet<>();
      tP.add(0);
      int count=0;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int num=Integer.parseInt(s.nextToken());
         allPoints.add(num);
         num+=12-num%12;
         if(!tM.contains(num)){
            tM.add(num);
            count+=12;
         }
         tP.add(num);
         tP.add(num-12);
      }
      ArrayList<Integer> oxYears=new ArrayList<Integer>(tP);
      Collections.sort(oxYears);
      ArrayList<Interval> intervals=new ArrayList<>();
      int intervalCounter=0;
      intervals.add(new Interval(0));
      for(int i=1;i<oxYears.size();i++){
         if(oxYears.get(i)-12==intervals.get(intervalCounter).b&&allPoints.higher(intervals.get(intervalCounter).b)<oxYears.get(i)){
            intervals.get(intervalCounter).add(oxYears.get(i));
         }
         else{
            intervals.add(new Interval(oxYears.get(i)));
            intervalCounter++;
         }
      }
      //System.out.println(intervals);
      ArrayList<Integer> distances=new ArrayList<>();
      for(int i=0;i<intervalCounter;i++){
         distances.add(intervals.get(i+1).a-intervals.get(i).b);
      }
      Collections.sort(distances);
      //System.out.println(distances);
      for(int i=distances.size()-K;i>=0;i--){
         count+=distances.get(i);
      }
      System.out.println(count);
   }
}
class Interval{
   int a;
   int b;
   int length;
   public Interval(int A){
      a=A;
      b=A;
      length=0;
   }
   public void add(int B){
      b=B;
      length+=12;
   }
   public String toString(){
      return "a:"+a+" b:"+b+" length:"+length;
   }
}