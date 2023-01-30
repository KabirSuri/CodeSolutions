import java.util.*;
import java.io.*;
public class diamond{
   public static int N;
   public static int K;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken());
      int diamonds[]=new int[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         diamonds[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(diamonds);
      int a=0;
      int sizes[]=new int[N];
      while(a<N-1){
         int b=a;
         sizes[a]++;
         while(b<N-1&&diamonds[b+1]-diamonds[a]<=K){
            b++;
            sizes[a]++;
         }
         a++;
         if(a==N-1)sizes[a]++;
      }
      int max=-1;
      for(int i=0;i<N-1;i++){
         int caseOne=sizes[i];
         int maxCaseTwo=-1;
         for(int k=i+caseOne;k<N;k++){
            maxCaseTwo=Math.max(maxCaseTwo,sizes[k]);       
         }
         max=Math.max(max,caseOne+maxCaseTwo);
      }
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}