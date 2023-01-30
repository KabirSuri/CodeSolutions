import java.util.*;
import java.io.*;
public class trapped{
   public static int[][] arr;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken());
      arr=new int[N][2];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         arr[i][0]=Integer.parseInt(s.nextToken());
         arr[i][1]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(arr, (a, b) -> a[1]-b[1]);
      int area=0;
      for(int i=1;i<N;i++){
         int start=i-1;
         int end=i;
         while(start>=0&&end<N){
            boolean right=false;
            boolean left=false;
            int distance=arr[end][1]-arr[start][1];
            if(distance>arr[start][0]){
               left=true;
               start--;
            }
            if(distance>arr[end][0]){  
               right=true;
               end++;
            }
            if(!left&&!right){
               area+=(arr[i][1]-arr[i-1][1]);
               break;
            }
         }
      }
      
      System.out.println(area);
      pw.println(area);
      pw.close();
   }
}