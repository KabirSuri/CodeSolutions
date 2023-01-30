import java.util.*;
import java.io.*;
public class bteams{
   public static int[] values=new int[12];
   public static int[] team=new int[12];
   public static int[] teamCount=new int[4];
   public static int minDifference=Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("bteams.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bteams.out")));
      for(int i=0;i<12;i++){
         StringTokenizer s=new StringTokenizer(br.readLine());
         values[i]=Integer.parseInt(s.nextToken());
      }
      recurse(0);
      
      System.out.println(minDifference);
      pw.println(minDifference);
      pw.close();
   }
   public static void recurse(int player){
      if(player==12){
         int[] sums=new int[4];
         for(int i=0;i<12;i++){
            sums[team[i]]+=values[i];
         }
         Arrays.sort(sums);
         minDifference=Math.min(minDifference,sums[3]-sums[0]);
         return;
      }
      for(int i=0;i<4;i++){
         if(teamCount[i]!=3){
            teamCount[i]++;
            team[player]=i;
            recurse(player+1);
            teamCount[i]--;
         }
      }
   }
}