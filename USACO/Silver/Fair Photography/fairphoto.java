import java.util.*;
import java.io.*;
public class fairphoto{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      HashSet<Integer> eHS=new HashSet<>();
      HashMap<Integer,Integer> eHM=new HashMap<>();
      HashSet<Integer> oHS=new HashSet<>();
      HashMap<Integer,Integer> oHM=new HashMap<>();
      int[][] cows=new int[N+1][2];
      for(int i=1;i<=N;i++){
         s=new StringTokenizer(br.readLine());
         cows[i][0]=Integer.parseInt(s.nextToken());
         cows[i][1]=-1;
         if(s.nextToken().equals("H"))cows[i][1]=1;
      }
      Arrays.sort(cows,(a,b)->a[0]-b[0]);
      /*for(int i=0;i<=N;i++){
         System.out.println(Arrays.toString(cows[i]));
      }*/
      int cow=0;
      int index=0;
      int max=0;
      for(int i=1;i<=N;i++){
         if(cow!=cows[i][1]){
            max=Math.max(max,cows[i-1][0]-cows[index][0]);
            cow=cows[i][1];
            index=i;
         }
         cows[i][1]+=cows[i-1][1];
         if(i%2==0){
            oHM.put(cows[i][1],cows[i][0]);
            oHS.add(cows[i][1]);
         }
         else{
            eHM.put(cows[i][1],cows[i][0]);
            eHS.add(cows[i][1]);
         }
      }
      if(index<N)
         max=Math.max(max,cows[N][0]-cows[index][0]);
      for(int i=1;i<N;i++)
         if(i%2==0&&eHS.contains(cows[i-1][1]))
            max=Math.max(max,eHM.get(cows[i-1][1])-cows[i][0]);
         else if(oHS.contains(cows[i-1][1]))
            max=Math.max(max,oHM.get(cows[i-1][1])-cows[i][0]);
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
}