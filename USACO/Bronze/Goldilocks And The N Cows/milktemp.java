import java.util.*;
import java.io.*;
public class milktemp{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("milktemp.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milktemp.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()), X=Integer.parseInt(s.nextToken()), Y=Integer.parseInt(s.nextToken()), Z=Integer.parseInt(s.nextToken());
      TreeSet<Integer> indexes=new TreeSet<Integer>();
      HashMap<Integer,int[]> map=new HashMap<Integer,int[]>();
      int[] firstArr={0,0};
      map.put(-1,firstArr);
      indexes.add(-1);
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine()); 
         int a=Integer.parseInt(s.nextToken());
         int b=Integer.parseInt(s.nextToken());
         if(!indexes.contains(a)){
            int[] arr={0,0};
            map.put(a,arr);
            indexes.add(a);
         }
         if(!indexes.contains(b+1)){
            int[] arr={0,0};
            map.put(b+1,arr);
            indexes.add(b+1);
         }
         map.get(a)[0]--;
         map.get(a)[1]++;
         map.get(b+1)[1]--;
      }
      int a=N,b=0,max=0;
      for(int i=0;i<indexes.size();i++){
         int index=indexes.first();
         a+=map.get(index)[0];
         b+=map.get(index)[1];
         int c=N-a-b;
         max=Math.max(max,(a*X)+(b*Y)+(c*Z));
         indexes.remove(index);
         i--;
      }
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}