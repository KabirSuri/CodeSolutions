import java.util.*;
import java.io.*;
public class cowjump{
   public static int N;
   public static ArrayList<Line> lines=new ArrayList<Line>();
   public static HashMap<Line,Integer> map=new HashMap<>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         Point a=new Point(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
         Point b=new Point(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
         lines.add(new Line(a,b));
         map.put(lines.get(i),i+1);
      }
      Collections.sort(lines,new xComparator());
      TreeSet<Line> ys=new TreeSet<Line>(new yComparator());
      TreeSet<Line> xs=new TreeSet<Line>(new xComparator());
      Line line1=null;
      Line line2;
      xs.add(lines.get(0));
      ys.add(lines.get(0));
      for(int i=1;i<N;i++){
         line2=lines.get(i);
         Line first=xs.first();
         while(first.pointsX.get(1).x<line2.pointsX.get(0).x){
            xs.remove(first);
            first=xs.first();
         }
         Line lower=ys.lower(line2);
         if(lower!=null&&intersecting(lower,line2)){
            line1=lower;
            break;
         }
         Line higher=ys.higher(line2);
         if(higher!=null&&intersecting(higher,line2)){
            line1=higher;
            break;
         }
         ys.add(line2);
         xs.add(line2);
      }
      //find the right line between line1 and line 2
      //System.out.println(map.get(lines[index1]));
      //pw.println(map.get(lines[index1]));
      pw.close();
   }
   public static boolean intersecting(Line a, Line b){
      if(a.pointsX.get(0).x<b.pointsX.get(0).x)
         return false;
      double slopeA=((double)(a.pointsX.get(0).y-a.pointsX.get(1).y))/(a.pointsX.get(1).x-a.pointsX.get(1).x);
      double aAtB0=(double)a.pointsX.get(0).y+(slopeA*(b.pointsX.get(0).x-a.pointsX.get(0).x));
      if(aAtB0>b.pointsX.get(0).y){
         if(a.pointsX.get(1).x>b.pointsX.get(1).x){
            double aAtB1=(double)a.pointsX.get(0).y+(slopeA*(b.pointsX.get(1).x-a.pointsX.get(1).x));
            if(aAtB1<b.pointsX.get(1).y)
               return true;
         }
         if(a.pointsX.get(1).x<b.pointsX.get(1).x){
            double slopeB=((double)(b.pointsX.get(0).y-b.pointsX.get(1).y))/(b.pointsX.get(0).x-b.pointsX.get(1).x);
            double bAtA1=(double)b.pointsX.get(0).y+(slopeB*(a.pointsX.get(1).x-b.pointsX.get(0).x));
            if(bAtA1>a.pointsX.get(1).y)
               return true;
         }
      }
      else if(aAtB0<b.pointsX.get(0).y){
         if(a.pointsX.get(1).x>b.pointsX.get(1).x){
            double aAtB1=(double)a.pointsX.get(0).y+(slopeA*(b.pointsX.get(1).x-a.pointsX.get(1).x));
            if(aAtB1>b.pointsX.get(1).y)
               return true;
         }
         if(a.pointsX.get(1).x<b.pointsX.get(1).x){
            double slopeB=((double)(b.pointsX.get(0).y-b.pointsX.get(1).y))/(b.pointsX.get(0).x-b.pointsX.get(1).x);
            double bAtA1=(double)b.pointsX.get(0).y+(slopeB*(a.pointsX.get(1).x-b.pointsX.get(0).x));
            if(bAtA1<a.pointsX.get(1).y)
               return true;
         }
      }

      return false;
   }
}
//Fix the comparators(uses point's compareTo method which doesn't sort for y)
class xComparator implements Comparator<Line>{
   public int compare(Line l1, Line l2){
      
      if(l1.pointsX.get(0).compare(l1.pointsX.get(0),l2.pointsX.get(0))==0){
         return l1.pointsX.get(0).compare(l1.pointsX.get(1),l2.pointsX.get(1));
      }
      return l1.pointsX.get(0).compare(l1.pointsX.get(0),l2.pointsX.get(0));
   }
}
class yComparator implements Comparator<Line>{
   public int compare(Line l1, Line l2){
      if(l1.pointsY.get(0).compare(pointsY.get(0),l2.pointsY.get(0))==0){
         return l1.pointsY.get(0).compare(l1.pointsY.get(1),l2.pointsY.get(1));
      }
      return l1.pointsY.get(0).compare(l1.pointsY.get(0),l2.pointsY.get(0));
   }
}
class Line{
   ArrayList<Point> pointsX;
   ArrayList<Point> pointsY;
   Line(Point A, Point B){
      pointsX=new ArrayList<Point>();
      pointsY=new ArrayList<Point>();
      pointsX.add(A);
      pointsX.add(B);
      pointsY.add(A);
      pointsY.add(B);
      Collections.sort(pointsX, new xPointComp());
      Collections.sort(pointsY, new yPointComp());
   }
   public String toString(){
      return pointsX.get(0)+","+pointsX.get(1);
   }
}
class Point implements Comparable<Point>{
   int x;
   int y;
   Point(int X, int Y){
      x=X;
      y=Y;
   }
   public int compareTo(Point other){
      if(x==other.x)
         return y-other.y;
      return x-other.x;
   }
   public String toString(){
      return "("+x+","+y+")";
   }
}
class xPointComp implements Comparator<Point>{
   public int compareTo(Point p1, Point p2){
      if(p1.x==p2.x)
         return p1.y-p2.y;
      return p1.x-p2.x;
   }
}
class yPointComp implements Comparator<Point>{
   public int compareTo(Point p1, Point p2){
      if(p1.y==p2.y)
         return p1.x-p2.x;
      return p1.y-p2.y;
   }
}