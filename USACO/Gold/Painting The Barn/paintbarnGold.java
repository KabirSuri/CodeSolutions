import java.util.*;
import java.io.*;
public class paintbarnGold{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()), K=Integer.parseInt(s.nextToken());
      int[][] arr=new int[203][203];
      int[][] prefix=new int[203][203];
      int[][] upLeft=new int[203][203];//saves best rectangle up to y that's above x2
      int[][] upRight=new int[203][203];//saves best rectangle after y that's above x2
      int[][] downLeft=new int[203][203];
      int[][] downRight=new int[203][203];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine()); 
         int x1=Integer.parseInt(s.nextToken())+1, y1=Integer.parseInt(s.nextToken())+1, x2=Integer.parseInt(s.nextToken())+1, y2=Integer.parseInt(s.nextToken())+1;
         arr[x1][y1]++;
         arr[x1][y2]--;
         arr[x2][y1]--;
         arr[x2][y2]++;
      }
      int totalArea=0;
      for(int i=1;i<=9;i++){
         for(int k=1;k<=9;k++){
            arr[i][k]+=arr[i-1][k]+arr[i][k-1]-arr[i-1][k-1];
            if(arr[i][k]==K){
               prefix[i][k]--;
               totalArea++;
            }
            else if(arr[i][k]==K-1){
               prefix[i][k]++;
            }
         }
         System.out.println(Arrays.toString(arr[i]));
      }
      System.out.println();
      for(int i=1;i<=200;i++){
         for(int k=1;k<=200;k++){
            prefix[i][k]+=prefix[i-1][k];
         }
      }
      for(int i=1;i<=9;i++){
         System.out.println(Arrays.toString(prefix[i]));
      }
      for(int x1=1;x1<=201;x1++){
         for(int x2=1;x2<=201;x2++){
            int min=0;
            for(int y=1;y<=201;y++){
               int sum=prefix[x2][y]-prefix[x1][y];
               min=Math.min(sum,min);
               upLeft[x2][y]=Math.max(sum-min,upLeft[x2][y-1]);
            }
            min=0;
            for(int y=201;y>=1;y--){
               int sum=prefix[x2][y]-prefix[x1][y];
               min=Math.min(sum,min);
               upRight[x2][y]=Math.max(sum-min,upRight[x2][y+1]);
            }
         }
      }
      for(int x2=201;x2>=1;x2--){
         for(int x1=201;x1>=1;x1--){
            int min=0;
            for(int y=1;y<=201;y++){
               int sum=prefix[x2][y]-prefix[x1][y];
               min=Math.min(sum,min);
               downLeft[x1][y]=Math.max(sum-min,downLeft[x1][y-1]);
            }
            min=0;
            for(int y=201;y>=1;y--){
               int sum=prefix[x2][y]-prefix[x1][y];
               min=Math.min(sum,min);
               downRight[x1][y]=Math.max(sum-min,downRight[x1][y+1]);
            }
         }
      }
      System.out.println("up left");
      for(int i=0;i<=9;i++){
         System.out.println(Arrays.toString(upLeft[i]));
      }
      System.out.println();
      System.out.println("down left");
      for(int i=0;i<=9;i++){
         System.out.println(Arrays.toString(downLeft[i]));
      }
      System.out.println();
      System.out.println("up right");
      for(int i=0;i<=9;i++){
         System.out.println(Arrays.toString(upRight[i]));
      }
      System.out.println();
      System.out.println("down right");
      for(int i=0;i<=9;i++){
         System.out.println(Arrays.toString(downRight[i]));
      }
      System.out.println();
      int maxCombo=0;
      int mainX=0;
      int mainY=0;
      for(int x=1;x<=201;x++){
         for(int y=1;y<=201;y++){
            int oldCombo=maxCombo;
            maxCombo=Math.max(maxCombo,Math.max(Math.max(upLeft[x][y]+upRight[x][y],upLeft[x][y]+downLeft[x][y]),upLeft[x][y]+downRight[x][y]));
            if(oldCombo!=maxCombo){
               mainX=x;
               mainY=y;
            }  
         }
      }
      totalArea+=maxCombo;
      System.out.println("x:"+mainX+" y:"+mainY);
      System.out.println(totalArea);
      pw.println(totalArea);
      pw.close();
   }
}