import java.util.*;
import java.io.*;
public class cowdance{
   public static int[] cows;
   public static int N;
   public static int Tmax;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "cowdance.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      Tmax=Integer.parseInt(s.nextToken());
      cows=new int[N];
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         cows[i]=Integer.parseInt(s.nextToken());
      }
      
      int max=N;
      int min=1;
      while(min!=max){
         int K=(max+min)/2;
         if(works(K)){
            max=K;
         }
         else{
            min=K+1;
         }
      }
      System.out.println(min);
      pw.println(min);
      pw.close();
   }
   public static boolean works(int K){
      int t=0;
      PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
      for(int i=0;i<N;i++) {
			if(queue.size()==K) {
				t = queue.poll();
			}
			if(t+cows[i]>Tmax) {
				return false;
			}
			queue.add(t+cows[i]);
		}
		return true;
   }
}