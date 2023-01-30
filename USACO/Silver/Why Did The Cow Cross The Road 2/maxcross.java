import java.util.*;
import java.io.*;
public class maxcross{
   public static int N;
   public static int K;
   public static int B;
   public static int[] broken;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      B=Integer.parseInt(s.nextToken());
      
      broken=new int[B+1];
      broken[0]=1;
      for(int i=1;i<=B;i++){
         s=new StringTokenizer(br.readLine());
         broken[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(broken);
      
      int start=0,end=B;
      while(start!=end){
         int mid=(start+end)/2;
         if(works(mid))end=mid;
         else start=mid+1;
      }
      
      System.out.println(start);
      pw.println(start);
      pw.close();
   }
   public static boolean works(int index){
      int a=0;
      for(int i=0;i<=B;i++){
         int b=N;
         if(a+index+1<=B)b=broken[a+index+1];
         if(b-broken[a]>=K)return true;
         a++;
      }
      return false;
   }
}