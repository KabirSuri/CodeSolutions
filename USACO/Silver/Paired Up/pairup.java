import java.util.*;
import java.io.*;
public class pairup{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int M=0;
      int arr[][]=new int[N][2];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         arr[i][0]=Integer.parseInt(s.nextToken());
         arr[i][1]=Integer.parseInt(s.nextToken());
         M+=arr[i][0];
      }
      Arrays.sort(arr, (a, b) -> a[1] - b[1]);
      int start=0,end=N-1;
      int max=0;
      while(M>0){
         int a=arr[start][1];
         int b=arr[end][1];
         max=Math.max(a+b,max);
         arr[start][0]--;
         arr[end][0]--;
         if(arr[start][0]==0)start++;
         if(arr[end][0]==0)end--;
         M-=2;
      }
          
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}