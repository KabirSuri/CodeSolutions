import java.util.*;
import java.io.*;
public class teleport{
   public static int N;
   public static long originalDist=0;
   public static HashSet<Long> set=new HashSet<Long>();
   public static TreeMap<Long,Long> locations=new TreeMap<Long,Long>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         Long a=Long.parseLong(s.nextToken());
         Long b=Long.parseLong(s.nextToken());
         originalDist+=Math.abs(b-a);
         if(Math.abs(b-a)>Math.abs(a)){
            Long start=0L;
            Long end=2*b;
            if(a<b&&a>=0){
               start=2*b-2*a;
               end=2*a;
            }
            if(a>=b&&a<0){
               start=2*b-2*a;
               end=2*a;
            }
            if(locations.get(start)==null)locations.put(start,0L);
            locations.put(start,locations.get(start)+1L);
            if(locations.get(b)==null)locations.put(b,0L);
            locations.put(b,locations.get(b)-2L);
            if(locations.get(end)==null)locations.put(end,0L);
            locations.put(end,locations.get(end)+1L);
         }
      }
      long distanceSaved=0;
      if(locations.size()>0){
         long lastLoc=locations.ceilingKey(Long.MIN_VALUE);
         long slope=0;
         long sum=0;
         for(long y:locations.keySet()){
            sum+=(y-lastLoc)*slope;
            distanceSaved=Math.max(sum,distanceSaved);
            slope+=locations.get(y);
            lastLoc=y;
         }
      }
      long ans=originalDist-distanceSaved;
      System.out.println(ans);
      pw.println(ans);
      pw.close();
   }
}