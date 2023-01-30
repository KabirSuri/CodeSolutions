import java.util.*;
import java.io.*;
public class painting{
   public static int N;
   public static int[][] rectangles;
   public static TreeSet<Fence> fences;
   public static Mark[] marks;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("painting.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("painting.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      rectangles=new int[N][4];
      marks=new Mark[2*N];
      fences=new TreeSet<Fence>();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<4;k++){
            rectangles[i][k]=Integer.parseInt(s.nextToken());
         }
         Fence current=new Fence(rectangles[i][1],rectangles[i][3]);
         marks[2*i]=new Mark(rectangles[i][0],false,current);
         marks[2*i+1]=new Mark(rectangles[i][2],true,current);
      }
      Arrays.sort(marks);
      int answer=0;
      for(int i=0;i<2*N;i++){
         if(!marks[i].close){
            Fence f=fences.higher(marks[i].fence);
            if(f==null||marks[i].fence.bottomY<f.bottomY){
               fences.add(marks[i].fence);
            }
         }
         else{
            if(fences.contains(marks[i].fence))answer++;
            fences.remove(marks[i].fence);
         }
      }
      
      System.out.println(answer);
      pw.println(answer);
      pw.close();
   }
}
class Fence implements Comparable<Fence>{
   int topY;
   int bottomY;
   public Fence(int b, int t){
      topY=t;
      bottomY=b;
   }
   public int compareTo(Fence other){
      return topY-other.topY;
   }
   public String toString(){
      return "("+topY+","+bottomY+")";
   }
}
class Mark implements Comparable<Mark>{
   int pos;
   boolean close;
   Fence fence;
   public Mark(int p, boolean c, Fence f){
      pos=p;
      close=c;
      fence=f;
   }
   public int compareTo(Mark other){
      return pos-other.pos;
   }
   public String toString(){
      return "(pos: "+pos+" close: "+close+")";
   }
}  