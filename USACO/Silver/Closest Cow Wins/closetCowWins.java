import java.util.*;
import java.io.*;
public class closetCowWins{
   public static int N;
   public static int M;
   public static int K;
   public static ArrayList<Patch> patches=new ArrayList<Patch>();
   public static int[] cows;
   public static void main(String[] args) throws IOException{
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedReader br = new BufferedReader(new FileReader("closetCowWins.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      K=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      N=Integer.parseInt(s.nextToken());
      cows=new int[M];
      for(int i=0;i<K;i++){
         s=new StringTokenizer(br.readLine());
         patches.add(new Patch(Integer.parseInt(s.nextToken()),Long.parseLong(s.nextToken())));
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         cows[i]=Integer.parseInt(s.nextToken());
      }
      Arrays.sort(cows);
      Collections.sort(patches,new locComparator());
      System.out.println(patches);
      for(int i=0;i<patches.size()-1;i++){
         int nextCow=nextCow(patches.get(i).loc);
         int lastCow=lastCow(patches.get(i).loc);
         /*if(i==4){
            System.out.println("nextCow: "+nextCow);
            System.out.println("lastCow: "+lastCow);
         }*/
         //System.out.println(i);
         if(nextCow==-1||(nextCow>patches.get(i+1).loc&&2*(nextCow-patches.get(i+1).loc)>patches.get(i+1).loc-patches.get(i).loc)){
            if(lastCow==-1||(2*(patches.get(i).loc-lastCow)>patches.get(i+1).loc-patches.get(i).loc)){
               patches.get(i).taste+=patches.get(i+1).taste;
               /////////
               patches.remove(i+1);
               i--;
            }
         }
      }
      Collections.sort(patches,new tasteComparator());
      long sum=0;
      System.out.println(patches);
      for(int i=patches.size()-1;i>=Math.max(0,patches.size()-N);i--){
         sum+=patches.get(i).taste;
      }
      System.out.println(sum);
   }
   public static int nextCow(int loc){
      if(loc>cows[cows.length-1])return -1;
      int a=0, b=cows.length-1;
      while(a!=b){
         int mid=(a+b)/2;
         if(cows[mid]>loc){
            b=mid;
         }
         else{
            a=mid+1;
         }
      }
      return cows[b];

   }
   public static int lastCow(int loc){
      if(loc<cows[0])return -1;
      int a=0, b=cows.length-1;
      while(a!=b){
         int mid=(a+b+1)/2;
         if(cows[mid]<loc){
            a=mid;
         }
         else{
            b=mid-1;
         }
      }
      return cows[b];
   }
}
class Patch{
   int startLoc;
   int endLoc;
   long taste;
   public Patch(int l, long t){
      startLoc=l;
      endLoc=l;
      taste=t;
   }
   public String toString(){
      return "startLoc:"+startLoc+" endLoc:"+endLoc+" taste:"+taste;
   }
}
class locComparator implements Comparator<Patch>{
   public int compare(Patch o1, Patch o2){
      return o1.startLoc-o2.startLoc;
   }
}
class tasteComparator implements Comparator<Patch>{
   public int compare(Patch o1, Patch o2){
      return Long.compare(o1.taste,o2.taste);
   }
}