import java.util.*;
import java.io.*;
public class cereal{
   public static int N;
   public static int M;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      Cow[] cows=new Cow[N];
      int answers[]=new int[N];
      int taken[]=new int[M];
      for(int i=0;i<M;i++){
         taken[i]=-1;
      }
      int hasCereal=0;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         cows[i]=new Cow(Integer.parseInt(s.nextToken())-1, Integer.parseInt(s.nextToken())-1);
      }
      for(int i=N-1;i>=0;i--){
         if(taken[cows[i].f]>-1){
            int secondCow=taken[cows[i].f];
            while(taken[cows[secondCow].s]>secondCow){
               int thirdCow=taken[cows[secondCow].s];
               taken[cows[secondCow].s]=secondCow;
               secondCow=thirdCow;
            }
            if(taken[cows[secondCow].s]==-1){
               taken[cows[secondCow].s]=secondCow;
               hasCereal++;
            }
            taken[cows[i].f]=i;
         }
         else{
            taken[cows[i].f]=i;
            hasCereal++;
         }
         answers[i]=hasCereal;
      }
      for(int i=0;i<N;i++){
         pw.println(answers[i]);
      }
      pw.close();
   }
}
class Cow{
   int s;
   int f;
   public Cow(int F, int S){
      f=F;
      s=S;
   }
   public String toString(){
      return f+","+s;
   }
}