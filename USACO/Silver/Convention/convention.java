import java.util.*;
import java.io.*;
public class convention{
   public static int N;
   public static int M;
   public static int C;
   public static int[] buses;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("convention.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      C=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      buses=new int[N];
      for(int i=0;i<N;i++){
         buses[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(buses);
      
      long start=0,end=1000000000;
      while(start!=end){
         long mid=(start+end)/2;
         if(works(mid)){
            end=mid;
         }
         else{
            start=mid+1;
         }
      }
      
      System.out.println(start);
      pw.println(start);
      pw.close();
   }
   public static boolean works(long wait){
      int index=0, numBuses=0;
      while(numBuses<=M){
         if(index==N)break;
         int min=buses[index];
         int max=buses[index];
         int numCows=1;
         for(index=index+1;index<N;index++){
            max=buses[index];
            if(max-min>wait||numCows==C){
               break;
            }
            numCows++;
         }
         numBuses++;
      }
      if(numBuses>M){
         return false;
      }
      return true;
   }
}