import java.util.*;
import java.io.*;
public class reduce{
   public static int N;
   public static Long[][] points;
   public static ArrayList<Long[]> endpoints=new ArrayList<>();
   public static HashSet<Long[]> hs=new HashSet<>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      points=new Long[N][2];
      long minX=Long.MAX_VALUE;
      long maxX=0;
      long minY=Long.MAX_VALUE;
      long maxY=0;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         long x=Long.parseLong(s.nextToken());
         long y=Long.parseLong(s.nextToken());
         minX=Math.min(x,minX);
         maxX=Math.max(x,maxX);
         minY=Math.min(y,minX);
         maxY=Math.max(x,maxX);
         points[i][0]=x;
         points[i][1]=y;
      }
      Arrays.sort(points, (a, b) -> Long.compare(a[0], b[0]));
      for(int i=0;i<5;i++){
         endpoints.add(points[i]);
         hs.add(points[i]);
      }
      for(int i=N-1;i>=N-5;i--){
         if(hs.contains(points[i]))
            continue;
         endpoints.add(points[i]);
         hs.add(points[i]);
      }
      Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));
      for(int i=0;i<5;i++){
         if(hs.contains(points[i]))
            continue;
         endpoints.add(points[i]);
         hs.add(points[i]);
      }
      for(int i=N-1;i>=N-5;i--){
         if(hs.contains(points[i]))
            continue;
         endpoints.add(points[i]);
         hs.add(points[i]);
      }
      long area=Long.MAX_VALUE;
      for(int a=0;a<endpoints.size();a++){
         for(int b=a+1;b<endpoints.size();b++){
            for(int c=b+1;c<endpoints.size();c++){
               minX=Long.MAX_VALUE;
               maxX=0;
               minY=Long.MAX_VALUE;
               maxY=0;
               for(int i=0;i<endpoints.size();i++){
                  if(Arrays.equals(endpoints.get(i),endpoints.get(a))||Arrays.equals(endpoints.get(i),endpoints.get(b))||Arrays.equals(endpoints.get(i),endpoints.get(c)))
                     continue;
                  long x=endpoints.get(i)[0];
                  long y=endpoints.get(i)[1];
                  minX=Math.min(x,minX);
                  maxX=Math.max(x,maxX);
                  minY=Math.min(y,minY);
                  maxY=Math.max(y,maxY);
               }
               area=Math.min(area,(maxX-minX)*(maxY-minY));
            }
         }
      }
      System.out.println(area);
      pw.println(area);
      pw.close();
   }
}