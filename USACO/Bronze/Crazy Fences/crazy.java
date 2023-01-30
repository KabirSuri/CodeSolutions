import java.util.*;
import java.io.*;
public class crazy{
   public static int N;
   public static int C;
   public static boolean[][] visited;
   public static boolean[][] isCow;
   public static ArrayList<Point> points=new ArrayList<Point>();
   public static ArrayList<Point> cows=new ArrayList<Point>();
   public static int[][] vectors={{1,0},{0,1},{-1,0},{0,-1}};
   public static TreeSet<Integer> x=new TreeSet<Integer>();
   public static TreeSet<Integer> y=new TreeSet<Integer>();
   public static HashMap<Integer, Integer> compToOrigX=new HashMap<Integer, Integer>();
   public static HashMap<Integer, Integer> compToOrigY=new HashMap<Integer, Integer>();
   public static HashMap<Integer, Integer> origToCompX=new HashMap<Integer, Integer>();
   public static HashMap<Integer, Integer> origToCompY=new HashMap<Integer, Integer>();
   public static ArrayList<Fence> fences=new ArrayList<Fence>();
   public static int maxFound=0;
   public static int found;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("crazy.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crazy.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int C=Integer.parseInt(s.nextToken());
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int startX=Integer.parseInt(s.nextToken())*2;
         int startY=Integer.parseInt(s.nextToken())*2;
         int endX=Integer.parseInt(s.nextToken())*2;
         int endY=Integer.parseInt(s.nextToken())*2;
         fences.add(new Fence(Math.min(startX,endX),Math.max(startX,endX),Math.min(startY,endY),Math.max(startY,endY)));
         Fence f=fences.get(i);
         points.add(new Point(f.startX,f.startY));
         x.add(f.startX);
         x.add(f.startX-1);
         y.add(f.startY);
         y.add(f.startY-1);
         x.add(f.endX+1);
         x.add(f.endX);
         y.add(f.endY+1);
         y.add(f.endY);
         points.add(new Point(f.endX,f.endY));
      }
      for(int i=0;i<C;i++){
         s=new StringTokenizer(br.readLine());
         int xCoor=Integer.parseInt(s.nextToken())*2;
         int yCoor=Integer.parseInt(s.nextToken())*2;
         cows.add(new Point(xCoor,yCoor));
         x.add(xCoor); //Add the x coordinates and y coordinates to a set
         y.add(yCoor);
      }
      //System.out.println(fences);
      //Add the points in the fence that have same x/y coordinates of any cows
      int index=1;
      for(int i:x){
         compToOrigX.put(index,i);
         origToCompX.put(i,index);
         index++;
      }
      index=1;
      for(int i:y){
         compToOrigY.put(index,i);
         origToCompY.put(i,index);
         index++;
      }
      //System.out.println(compToOrigX);
      //System.out.println(compToOrigY);
      visited=new boolean[compToOrigX.size()+2][compToOrigY.size()+2];
      isCow=new boolean[compToOrigX.size()+2][compToOrigY.size()+2];
      for(int i=0;i<points.size();i++){
         visited[origToCompX.get(points.get(i).x)][origToCompY.get(points.get(i).y)]=true;
      }
      for(int i=0;i<cows.size();i++){
         isCow[origToCompX.get(cows.get(i).x)][origToCompY.get(cows.get(i).y)]=true;
      }
      for(Fence f:fences){
         int startXComp=origToCompX.get(f.startX);
         int startYComp=origToCompY.get(f.startY);
         int endXComp=origToCompX.get(f.endX);
         int endYComp=origToCompY.get(f.endY);
         if(startXComp!=endXComp){
            for(int i=startXComp;i<=endXComp;i++){
               visited[i][startYComp]=true;
            }
         }
         else{
            for(int i=startYComp;i<=endYComp;i++){
               visited[startXComp][i]=true;
            }
         }
      }
      /*for(int i=visited[0].length-1;i>=0;i--){
         for(int k=0;k<visited.length;k++){
            if(isCow[k][i])System.out.print("c");
            else if(visited[k][i])System.out.print(1);
            else System.out.print(0);
         }
         System.out.println();
      }
      System.out.println();
      for(int i=0;i<visited.length;i++){
         for(int k=0;k<visited[i].length;k++){
            if(isCow[i][k])System.out.print(1);
            else System.out.print(0);
         }
         System.out.println();
      }*/
      for(int i=0;i<visited.length;i++){
         for(int k=0;k<visited[i].length;k++){
            if(!visited[i][k])
               found=0;
            floodfill(i,k);
            maxFound=Math.max(found,maxFound);
         }
      }
      System.out.println(maxFound);
      pw.println(maxFound);
      pw.close();
   }
   public static void floodfill(int x, int y){
      if(visited[x][y])
         return;
      visited[x][y]=true;
      if(isCow[x][y])found++;
      for(int i=0;i<4;i++){
         int newX=x+vectors[i][0];
         int newY=y+vectors[i][1];
         if(newX>=0&&newX<visited.length&&newY>=0&&newY<visited[x].length)floodfill(newX,newY);
      }
   }
}
class Point{
   int x;
   int y;
   public Point(int X, int Y){
      x=X;
      y=Y;
   }
}
class Fence{
   int startX;
   int startY;
   int endX;
   int endY;
   public Fence(int sx, int ex, int sy, int ey){
      startX=sx;
      startY=sy;
      endX=ex;
      endY=ey;
   }
   public String toString(){
      return "x:("+startX+" to "+endX+") y:("+startY+" to "+endY+")";
   }
}