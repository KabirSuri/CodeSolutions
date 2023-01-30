import java.util.*;
import java.io.*;
public class USBvsPS2{
   static int a;
   static int b;
   static int c;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      a=Integer.parseInt(s.nextToken());
      b=Integer.parseInt(s.nextToken());
      c=Integer.parseInt(s.nextToken());
      PriorityQueue<Long> USB=new PriorityQueue<Long>();
      PriorityQueue<Long> PS2=new PriorityQueue<Long>();
      s=new StringTokenizer(br.readLine());
      int M=Integer.parseInt(s.nextToken());
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         long val=Long.parseLong(s.nextToken());
         if(s.nextToken().equals("USB"))USB.add(val);
         else PS2.add(val);
      }
      int count=0;
      long cost=0;
      for(int i=0;i<a;i++){
         if(USB.isEmpty())break;
         count++;
         cost+=USB.remove();
      }
      for(int i=0;i<b;i++){
         if(PS2.isEmpty())break;
         count++;
         cost+=PS2.remove();
      }
      for(int i=0;i<c;i++){
         if(PS2.isEmpty()){
            if(USB.isEmpty())break;
            cost+=USB.remove();
         }
         else if(USB.isEmpty())cost+=PS2.remove();
         else{
            if(USB.peek()<PS2.peek())cost+=USB.remove();
            else cost+=PS2.remove();
         }
         count++;
      }
      System.out.println(count+" "+cost);
   }
}