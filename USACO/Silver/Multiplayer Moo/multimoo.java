import java.util.*;
import java.io.*;
public class multimoo{
   static int N;
   static int[][] arr;
   static ArrayList<Region> regions=new ArrayList<>();
   static int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
   static boolean visited[][];
   static boolean regionVisited[];
   static int doubleMax=0;
   static int totalArea;
   static int regionArr[][];
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int singleMax=0;
      arr=new int[N][N];
      visited=new boolean[N][N];
      regionArr=new int[N][N];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            arr[i][k]=Integer.parseInt(s.nextToken());
         }
      }
      
      int region=0;
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(!visited[i][k]){
               Region r=new Region(region,arr[i][k]);
               floodfill(i,k,r);
               regions.add(r);
               singleMax=Math.max(singleMax,r.area);
               region++;
            }
         }
      }
      
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            for(int z=0;z<4;z++){
               int x=i+directions[z][0];
               int y=k+directions[z][1];
               if(x>=0&&x<N&&y>=0&&y<N&&regionArr[x][y]!=regionArr[i][k]){
                  regions.get(regionArr[i][k]).add(regionArr[x][y]);
               }
            }
         }
      }
      
      for(int i=0;i<regions.size();i++){
         for(int k:regions.get(i).neighbors){
            totalArea=0;
            regionVisited=new boolean[regions.size()];
            dfs(i,i,regions.get(i).ID,regions.get(k).ID);
         }
      }
      
      System.out.println(singleMax);
      System.out.println(doubleMax);
      pw.println(singleMax);
      pw.println(doubleMax);
      pw.close();
   }
   public static void floodfill(int x, int y, Region r){
      visited[x][y]=true;
      r.area++;
      regionArr[x][y]=r.region;
      for(int i=0;i<4;i++){
         int newX=x+directions[i][0];
         int newY=y+directions[i][1];
         if(newX>=0&&newX<N&&newY>=0&&newY<N&&!visited[newX][newY]&&arr[newX][newY]==r.ID){
            floodfill(newX,newY,r);
         }
      }
   }
   public static void dfs(int parent, int child, int ID1, int ID2){
      if(regionVisited[child])
         return;
      regionVisited[parent]=true;
      regionVisited[child]=true;
      totalArea+=regions.get(child).area;
      for(int k:regions.get(child).neighbors){
         if(regions.get(k).ID==ID1||regions.get(k).ID==ID2)
            dfs(child,k,ID1,ID2);
      }
      doubleMax=Math.max(doubleMax,totalArea);   
   }
}
class Region{
   int area;
   int region;
   HashSet<Integer> neighbors;
   int ID;
   Region(int r,int id){
      region=r;
      ID=id;
      neighbors=new HashSet<Integer>();
   }
   void add(int a){
      neighbors.add(a);
   }
   void remove(int a){
      neighbors.remove(a);
   }
   public String toString(){
      return "("+region+","+ID+")";
   }
}