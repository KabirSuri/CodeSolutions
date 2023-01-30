import java.util.*;
import java.io.*;
public class slowdown{
   public static double distance=0, time=0, speed=1;
   public static ArrayList<Double> T= new ArrayList<>();
   public static ArrayList<Double> D= new ArrayList<>();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("slowdown.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String c=s.nextToken();
         if(c.equals("T"))
            T.add((double)Integer.parseInt(s.nextToken()));
         else 
            D.add((double)Integer.parseInt(s.nextToken()));
      }
      
      Collections.sort(T);
      Collections.sort(D);
      
      while(T.size()!=0||D.size()!=0){
         if(T.size()!=0&&D.size()!=0){
            if(D.get(0)<distance+tiToD(T.get(0))){
               updateD();
            }
            else{
               updateT();
            }
         }
         else if(T.size()!=0){
            updateT();
         }
         else{
            updateD();
         }
      }
      time+=(1000-distance)*speed;
      int answer=(int)(Math.round(time));
      System.out.println(answer);
      pw.println(answer);
      pw.close();
   }
   public static double tiToD(double ti){
      return (ti-time)/speed;
   }
   public static double diToT(double di){
      return (di-distance)*speed;
   }
   public static void updateD(){
      time+=diToT(D.get(0));
      distance=D.get(0);
      speed++;
      D.remove(0);
   }
   public static void updateT(){
      distance+=tiToD(T.get(0));
      time=T.get(0);
      speed++;
      T.remove(0);
   }
}