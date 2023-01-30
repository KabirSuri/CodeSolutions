import java.util.*;
import java.io.*;
public class greetings{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("greetings.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("greetings.out")));
      int cows[][]=new int[1000001][2];
      StringTokenizer s=new StringTokenizer(br.readLine());
      int B=Integer.parseInt(s.nextToken()), E=Integer.parseInt(s.nextToken());
      int bIndex=1,eIndex=1;
      for(int i=0;i<B;i++){
         s=new StringTokenizer(br.readLine());
         int time=Integer.parseInt(s.nextToken());
         char direction=s.nextToken().charAt(0);
         int mover=1;
         if(direction=='L')mover=-1;
         for(int k=0;k<time;k++){
            cows[bIndex][0]=cows[bIndex-1][0]+mover;
            bIndex++;
         }
      }
      for(int i=0;i<E;i++){
         s=new StringTokenizer(br.readLine());
         int time=Integer.parseInt(s.nextToken());
         char direction=s.nextToken().charAt(0);
         int mover=1;
         if(direction=='L')mover=-1;
         for(int k=0;k<time;k++){
            cows[eIndex][1]=cows[eIndex-1][1]+mover;
            eIndex++;
         }
      }
      int finalE=cows[eIndex-1][0];
      int finalB=cows[bIndex-1][0];
      while(bIndex<Math.max(bIndex,eIndex)){
         cows[bIndex][0]=finalB;
         bIndex++;
      }
      while(eIndex<Math.max(bIndex,eIndex)){
         cows[eIndex][0]=finalE;
         eIndex++;
      }
      int count=0;
      for(int i=0;i<Math.max(bIndex,eIndex)-1;i++){
         if(cows[i][0]!=cows[i][1]&&cows[i+1][0]==cows[i+1][1])count++;
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}