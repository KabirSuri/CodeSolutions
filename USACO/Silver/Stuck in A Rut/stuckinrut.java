import java.util.*;
import java.io.*;
public class stuckinrut{
   public static int N;
   public static Cow[] cows;
   public static ArrayList<Cow> northCows;
   public static ArrayList<Cow> eastCows;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      cows=new Cow[N];
      int[] stops=new int[N];
      northCows=new ArrayList<Cow>();
      eastCows=new ArrayList<Cow>();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         if(s.nextToken().equals("E"))eastCows.add(new Cow(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()),i));
         else northCows.add(new Cow(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()),i));
      }
      Collections.sort(eastCows,new yComp());
      Collections.sort(northCows,new xComp());
      boolean[] eastStopped=new boolean[N];
      for(int i=0;i<northCows.size();i++){
         for(int k=0;k<eastCows.size();k++){
            if(northCows.get(i).y>eastCows.get(k).y||northCows.get(i).x<eastCows.get(k).x||eastStopped[k])continue;
            int xDistance=northCows.get(i).x-eastCows.get(k).x;
            int yDistance=eastCows.get(k).y-northCows.get(i).y;
            if(xDistance>yDistance){
               eastStopped[k]=true;
               stops[northCows.get(i).ID]+=stops[eastCows.get(k).ID]+1;
               //System.out.println(Arrays.toString(stops));
            }
            else if(yDistance>xDistance){
               stops[eastCows.get(k).ID]+=stops[northCows.get(i).ID]+1;
               //System.out.println(Arrays.toString(stops));
               break;
            }
         }
      }
      for(int i=0;i<N;i++){
         System.out.println(stops[i]);
      }
   }
}
class xComp implements Comparator<Cow>{
   public int compare(Cow o1, Cow o2){
      return o1.x-o2.x;
   }
}
class yComp implements Comparator<Cow>{
   public int compare(Cow o1, Cow o2){
      return o1.y-o2.y;
   }
}
class Cow{
   int x;
   int y;
   int ID;
   public Cow(int X, int Y, int id){
      x=X;
      y=Y;
      ID=id;
   }
}