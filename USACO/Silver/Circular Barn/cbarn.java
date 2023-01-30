import java.util.*;
import java.io.*;
public class cbarn{
   public static int N;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int circle[]=new int[N];
      int max=0;
      int sum=0;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         circle[i]=Integer.parseInt(s.nextToken());
      }
      long energy=0;
      for(int index=0;index<N;index++){
         ArrayList<Integer> cows=new ArrayList<Integer>();
         int[] copy=circle.clone();
         while(copy[index]>0){
            copy[index]--;
            cows.add(index);
         }
         energy=0;
         boolean done=false;
         for(int i=index+1;i<index+N+1;i++){
            int mIndex=i%N;
            while(copy[mIndex]>0){
               copy[mIndex]--;
               cows.add(i);
            }
            if(cows.size()==0)
               break;
            energy+=(long)Math.pow(i-cows.remove(0),2);
            if(i==index+N)done=true;
         }
         if(done)
            break;
      }
      
      System.out.println(energy);
      pw.println(energy);
      pw.close();
   }
}