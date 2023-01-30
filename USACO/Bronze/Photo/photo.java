import java.util.*;
import java.io.*;
public class photo{
   public static int N;
   public static int K;
   public static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
   public static PriorityQueue<Integer> criticalCows=new PriorityQueue<Integer>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("photo.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "photo.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      int highestCow=0;
      for(int i=0;i<K;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken());
         int b=Integer.parseInt(s.nextToken());
         map.put(a,b);
         map.put(b,a);
         criticalCows.add(a);
         criticalCows.add(b);
         highestCow=Math.max(highestCow,a);
         highestCow=Math.max(highestCow,b);
      }
      HashSet<Integer> inPhoto=new HashSet<Integer>();
      int count=0;
      while(criticalCows.size()>0){
         if(inPhoto.contains(map.get(criticalCows.peek()))){
            inPhoto.clear();
            count++;
         }
         inPhoto.add(criticalCows.poll());
      }
      count++;
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}