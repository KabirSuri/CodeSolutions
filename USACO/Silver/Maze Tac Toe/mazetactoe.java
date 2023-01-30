import java.util.*;
import java.io.*;
public class mazetactoe{
   public static int[][] mapBounds;
   public static Node[][] maze;
   public static int[] B=new int[2];
   public static int N;
   public static HashSet<String> count=new HashSet<>();
   public static void main(String[] args) throws IOException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      mapBounds=new int[N][N];
      maze=new Node[N][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String row=s.nextToken();
         for(int k=0;k<N*3;k+=3){
            String block=row.substring(k,k+3);
            if(block.equals("###")){
               mapBounds[i][k/3]=-1;
            }
            else if(block.equals("BBB")){
               B[0]=i;
               B[1]=k/3;
            }
            else if(!block.equals("...")){
               char c=block.charAt(0);
               int x=Integer.parseInt(block.substring(1,2))-1;
               int y=Integer.parseInt(block.substring(2,3))-1;
               Node n=new Node(c,x,y);    
               maze[i][k/3]=n;
            }
         }            
      }
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            initialize(i,k);
         }
      }
      char tic[][]=new char[3][3];
      for(int i=0;i<3;i++){
         for(int k=0;k<3;k++){
            tic[i][k]=Character.MIN_VALUE;
         }
      }
      dfs(B[0],B[1],tic, new int[N][N]);
      System.out.println(count.size());
   }
   public static boolean moo(char[][] tic){
      if(tic[1][1]=='M'){
         return false;
      }
      if(tic[0][0]=='M'){
         if(tic[1][0]=='O'&&tic[2][0]=='O'){
            return true;
         }
         else if(tic[0][1]=='O'&&tic[0][2]=='O'){
            return true;
         }
      }
      if(tic[2][0]=='M'){
         if(tic[1][0]=='O'&&tic[0][0]=='O'){
            return true;
         }
         else if(tic[2][1]=='O'&&tic[2][2]=='O'){
            return true;
         }
      }
      if(tic[0][2]=='M'){
         if(tic[1][2]=='O'&&tic[2][2]=='O'){
            return true;
         }
         else if(tic[0][1]=='O'&&tic[0][0]=='O'){
            return true;
         }
      }
      if(tic[2][2]=='M'){
         if(tic[1][2]=='O'&&tic[0][2]=='O'){
            return true;
         }
         else if(tic[2][1]=='O'&&tic[2][0]=='O'){
            return true;
         }
      }
      if(tic[1][1]=='O'){
         if(tic[1][0]=='M'&&tic[1][2]=='O'){
            return true;
         }
         if(tic[1][0]=='O'&&tic[1][2]=='M'){
            return true;
         }
         if(tic[0][1]=='M'&&tic[2][1]=='O'){
            return true;
         }
         if(tic[0][1]=='O'&&tic[2][1]=='M'){
            return true;
         }
         if(tic[2][2]=='M'&&tic[0][0]=='O'){
            return true;
         }
         if(tic[2][2]=='O'&&tic[0][0]=='M'){
            return true;
         }
         if(tic[2][0]=='M'&&tic[0][2]=='O'){
            return true;
         }
         if(tic[2][0]=='O'&&tic[0][2]=='M'){
            return true;
         }
      }
      return false;
   }
   public static String charToStr(char[][] tic){
      String str="";
      for(int i=0;i<tic.length;i++){
         for(int k=0;k<tic.length;k++){
            str+=tic[i][k];
         }
      }
      return str;
   }
   public static void dfs(int a, int b, char[][] tic, int[][] visited){
      if(a<0||a>=N||b<0||b>=N||mapBounds[a][b]==-1||visited[a][b]==mapBounds[a][b]){
         return;
      }
      Node p=null;
      boolean condition=true;
      if(maze[a][b]!=null){
         p=maze[a][b];
         if(tic[p.x][p.y]!=Character.MIN_VALUE){
            condition=false;
         }
         else{
            tic[p.x][p.y]=p.c;
         }
         if(moo(tic)&&condition){
            if(!count.contains(charToStr(tic))){
               count.add(charToStr(tic));
               tic[p.x][p.y]=Character.MIN_VALUE;
               return;
            }
            tic[p.x][p.y]=Character.MIN_VALUE;
            return;
         }
         else if(!condition){
            boolean allFilled=true;
            for(int i=0;i<3;i++){
               for(int k=0;k<3;k++){
                  if(tic[i][k]==Character.MIN_VALUE){
                     allFilled=false;
                     break;
                  }
               }
               if(!allFilled){
                  break;
               }
            }
            if(allFilled){
               tic[p.x][p.y]=Character.MIN_VALUE;
               return;
            }
         }
      }
      visited[a][b]++;
      dfs(a+1,b,tic,visited);
      dfs(a,b+1,tic,visited);
      dfs(a-1,b,tic,visited);
      dfs(a,b-1,tic,visited);
      if(p!=null&&condition){
         tic[p.x][p.y]=Character.MIN_VALUE;
      }
      visited[a][b]--;
   }
   public static void initialize(int a, int b){
      if(mapBounds[a][b]==-1){
         return;
      }
      if(a-1>=0&&mapBounds[a-1][b]>-1){
         mapBounds[a][b]++;
      }
      if(b+1<N&&mapBounds[a][b+1]>-1){
         mapBounds[a][b]++;
      }
      if(a+1<N&&mapBounds[a+1][b]>-1){
         mapBounds[a][b]++;
      }
      if(b-1>=0&&mapBounds[a][b-1]>-1){
         mapBounds[a][b]++;
      }
   }
}
class Node{
   public int x;
   public int y;
   public char c;
   public Node(char c, int x, int y){
      this.c=c;
      this.x=x;
      this.y=y;
   }
   public String toString(){
      return c+""+x+""+y+"";
   }
}