import java.util.*;
import java.io.*;
public class herding{
   public static int N;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("herding.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      
      int[] arr=new int[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int num=Integer.parseInt(s.nextToken());
         arr[i]=num;
      }
      Arrays.sort(arr);
      
      long min=0;
      if(arr[N-2]-arr[0]==N-2&&arr[N-1]-arr[N-2]>2)min=2;
      else if(arr[N-1]-arr[1]==N-2&&arr[1]-arr[0]>2)min=2;
      else{
         int end=0;
         for(int start=0;start<N;start++){
            while(end<N-1&&arr[end+1]-arr[start]<=N-1)end++;
            min=Math.max(min, end-start+1);
         }
         min=N-min; 
      }     
      long max=0;
      max = Math.max(arr[N-2]-arr[0],arr[N-1]-arr[1])-(N-2);      
      System.out.println(min);
      pw.println(min);
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}