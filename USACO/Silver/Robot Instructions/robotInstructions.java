import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class robotInstructions{
   public static int N;
   public static int xAns;
   public static int yAns;
   public static int[][] vectors;
   public static int[] ans;
   public static StringBuffer out=new StringBuffer();
   
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("redistributingGifts.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      xAns=Integer.parseInt(s.nextToken());
      yAns=Integer.parseInt(s.nextToken());
      vectors=new int[N][2];
      ans=new int[N];
      int xPosSum=0;
      int xNegSum=0;
      int yPosSum=0;
      int yNegSum=0;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         vectors[i][0]=Integer.parseInt(s.nextToken());
         vectors[i][1]=Integer.parseInt(s.nextToken());
         if(vectors[i][0]<0)xNegSum+=vectors[i][0];
         else xPosSum+=vectors[i][0];
         if(vectors[i][1]<0)yNegSum+=vectors[i][1];
         else yPosSum+=vectors[i][1];
      }
      dfs(0,0,0,xPosSum,xNegSum,yPosSum,yNegSum,0);
      for(int i=0;i<N;i++){
         out.append(ans[i]+"\n");
      }
      System.out.print(out);
   }
   public static void dfs(int i, int xSum, int ySum, int xPosSum, int xNegSum, int yPosSum, int yNegSum, int count){
      //System.out.println(xSum+" "+ySum);
      if(i==N){
         if(xSum==xAns&&ySum==yAns){
            ans[count-1]++;
         }
         return;
      }
      if(!(xSum+vectors[i][0]+xNegSum>xAns&&xSum+vectors[i][0]+xPosSum<xAns&&ySum+vectors[i][1]+yNegSum>yAns&&ySum+vectors[i][1]+yPosSum<yAns)){
         int xPos=xPosSum;
         int yPos=yPosSum;
         int xNeg=xNegSum;
         int yNeg=yNegSum;
         if(vectors[i][0]<0){
            xNeg-=vectors[i][0];
         }
         if(vectors[i][0]>0){
            xPos-=vectors[i][0];
         }
         if(vectors[i][1]<0){
            yNeg-=vectors[i][1];
         }
         if(vectors[i][1]>0){
            yPos-=vectors[i][1];
         }
         dfs(i+1,xSum+vectors[i][0],ySum+vectors[i][1],xPos,xNeg,yPos,yNeg,count+1);
      }
      dfs(i+1,xSum,ySum,xPosSum,xNegSum,yPosSum,yNegSum,count);
   }
}