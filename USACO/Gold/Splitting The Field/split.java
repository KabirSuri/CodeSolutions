import java.util.*;
import java.io.*;
public class split{
   public static int N;
   public static long answer=-1;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("split.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      Fence a=new Fence(false);
      Fence b=new Fence(true);
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         Point p=new Point(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
         a.add(p);
      }
      function(a,b);
      a=new Fence(false);
      b=new Fence(true);
      br = new BufferedReader(new FileReader("split.in"));
      s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int x=Integer.parseInt(s.nextToken());
         int y=Integer.parseInt(s.nextToken());
         Point p=new Point(y,x);
         a.add(p);
      } 
      function(a,b);
      System.out.println(answer);
      pw.println(answer);
      pw.close();
   }
   public static void function(Fence a,Fence b){
      long bAreas[]=new long[N+1];
      long totalArea=a.area();
      bAreas[0]=0;
      
      int i=1;
      while(!a.queue.isEmpty()){
         Point p=a.queue.remove();
         b.add(p);
         bAreas[i]=b.area();
         i++;
      }
      long optimizedA=totalArea;
      long optimizedB=0;
      i=N-1;
      a=new Fence(false);
      while(!b.queue.isEmpty()){
         Point p=b.queue.remove();
         a.add(p);
         if(a.area()+bAreas[i]<optimizedA+optimizedB){
            optimizedA=a.area();
            optimizedB=bAreas[i];
         }
         i--;
      }
      answer=Math.max(answer,totalArea-(optimizedA+optimizedB));
   }
}
class Fence{
   PriorityQueue<Point> queue;
   long xMin;
   long yMin;
   long xMax;
   long yMax;
   public Fence(boolean reverse){
      xMin=Long.MAX_VALUE;
      yMin=Long.MAX_VALUE;
      if(reverse) queue=new PriorityQueue<Point>(new ReverseComp());
      else queue=new PriorityQueue<Point>(new Comp());
   }
   public void add(Point p){
      queue.add(p);
      xMin=Math.min(xMin,p.x);
      xMax=Math.max(xMax,p.x);
      yMin=Math.min(yMin,p.y);
      yMax=Math.max(yMax,p.y);
   }
   public long area(){
      return (xMax-xMin)*(yMax-yMin);
   }
}
class Comp implements Comparator<Point>{
   public int compare(Point o1, Point o2){
      if(o1.x==o2.x)return Long.compare(o1.y,o2.y);
      return Long.compare(o1.x,o2.x);
   }
}
class ReverseComp implements Comparator<Point>{
   public int compare(Point o1, Point o2){
      if(o1.x==o2.x)return Long.compare(o2.y,o1.y);
      return Long.compare(o2.x,o1.x);
   }
}
class Point{
   long x;
   long y;
   public Point(long X, long Y){
      x=X;
      y=Y;
   }
   public String toString(){
      return "("+x+","+y+")";
   }
}