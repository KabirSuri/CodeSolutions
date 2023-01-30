import java.util.*;
import java.io.*;
public class pails{
   public static int N;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("pails.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int X=Integer.parseInt(s.nextToken());
      int Y=Integer.parseInt(s.nextToken());
      int K=Integer.parseInt(s.nextToken());
      int M=Integer.parseInt(s.nextToken());
      int min=M;
      
      Queue<Integer> x=new LinkedList<Integer>();
      Queue<Integer> y=new LinkedList<Integer>();
      Queue<Integer> moves=new LinkedList<Integer>();
      boolean visited[][]=new boolean[101][101];
            
      x.add(0);
      y.add(0);
      moves.add(0);
      
      while(!x.isEmpty()){
         int xt=x.remove(), yt=y.remove(), m=moves.remove();
         if(visited[xt][yt]||m>K)continue;
         System.out.println(xt+","+yt);
         visited[xt][yt]=true;
         min=Math.min(min,Math.abs(M-xt-yt));
         x.add(xt);
         y.add(0);
         moves.add(m+1);
         x.add(0);
         y.add(yt);
         moves.add(m+1);
         if(xt<X){
            x.add(X);
            y.add(yt);
            moves.add(m+1);
         }
         if(yt<Y){
            x.add(xt);
            y.add(Y);
            moves.add(m+1);
         }
         if(xt>0){
            int xNew=xt-yt, yNew=Y;
            int difference=Y-yt;
            if(difference>xt){
               xNew=0;
               yNew=yt+xt;
            }
            else if(difference==xt){
               xNew=0;
               yNew=Y;
            }
            else{
               xNew=xt-difference;
               yNew=Y;
            }
            x.add(xNew);
            y.add(yNew);
            moves.add(m+1);
         }
         if(yt>0){
            int yNew=yt-xt, xNew=X;
            int difference=X-xt;
            if(difference>yt){
               yNew=0;
               xNew=yt+xt;
            }
            else if(difference==yt){
               yNew=0;
               xNew=X;
            }
            else{
               yNew=yt-difference;
               xNew=X;
            }
            x.add(xNew);
            y.add(yNew);
            moves.add(m+1);
         }
      }
      
      System.out.println(min);
      pw.println(min);
      pw.close();
   }
}