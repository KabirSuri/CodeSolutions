import java.util.*;
import java.io.*;
public class comfortableCows{
   static int N;
   static int count=0;
   static boolean[][] visited=new boolean[3002][3002];
   static int[][] neighbors=new int[3002][3002];
   static int[][] vectors={{-1,0},{1,0},{0,1},{0,-1}};
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("comfortableCows.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      StringBuilder out = new StringBuilder();
      N=Integer.parseInt(s.nextToken());
      for(int n=0;n<N;n++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())+1000,b=Integer.parseInt(s.nextToken())+1000;
         Queue<Pair> queue=new LinkedList<>();
         queue.add(new Pair(a,b));
         count--;
         while(!queue.isEmpty()){
            Pair p=queue.remove();
            if(visited[p.x][p.y])
               continue;
            visited[p.x][p.y]=true;
            count++;
            for(int i=0;i<4;i++){
               int newX=p.x+vectors[i][0];
               int newY=p.y+vectors[i][1];
               neighbors[newX][newY]++;
            }
            for(int i=0;i<4;i++){
               int newX=p.x+vectors[i][0];
               int newY=p.y+vectors[i][1];
               if(visited[newX][newY]&&neighbors[newX][newY]==3){
                  //System.out.println(n);
                  for(int k=0;k<4;k++){
                     int newA=newX+vectors[k][0];
                     int newB=newY+vectors[k][1];   
                     if(!visited[newA][newB]){
                        //System.out.println(n);
                        queue.add(new Pair(newA,newB));
                        break;
                     }
                  }
               }
            }
            if(neighbors[p.x][p.y]==3){
               for(int i=0;i<4;i++){
                  int newX=p.x+vectors[i][0];
                  int newY=p.y+vectors[i][1];
                  if(!visited[newX][newY]){
                     queue.add(new Pair(newX,newY));
                     break;
                  }
               }
            }
         }
         out.append(count).append('\n');
      }
      System.out.print(out);
   }
}
class Pair{
   int x;
   int y;
   public Pair(int X, int Y){
      x=X;
      y=Y;
   }
}