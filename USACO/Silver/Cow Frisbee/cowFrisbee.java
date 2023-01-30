import java.util.*;
import java.io.*;
public class cowFrisbee{
   public static long N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Long.parseLong(s.nextToken());
      long total=0;
      TreeSet<Long> positions=new TreeSet<Long>();
      TreeSet<Long> values=new TreeSet<Long>();
      HashMap<Long,Long> posToValue=new HashMap<Long,Long>();
      s=new StringTokenizer(br.readLine());
      for(long i=0;i<N;i++){
         long value=Long.parseLong(s.nextToken());
         Long positionLower=positions.lower(i);
         //System.out.println("positions:"+positions);
         //System.out.println("values:"+values);
         while(positionLower!=null){
            Long valueLower=posToValue.get(positionLower);
            total+=(i-positionLower+1);
            if(valueLower<value){
               positions.remove(positionLower);
               values.remove(valueLower);
               //System.out.println("positions:"+positions);
               //System.out.println("values:"+values);
            }
            else 
               break;
            positionLower=positions.lower(i);
         }
         //System.out.println();
         positions.add(i);
         values.add(value);
         posToValue.put(i,value);
      }
      System.out.println(total);
   }
}