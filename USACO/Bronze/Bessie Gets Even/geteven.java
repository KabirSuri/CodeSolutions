import java.util.*;
import java.io.*;
public class geteven{
   public static long count=0;
   public static int[] evens=new int[7];
   public static int[] odds=new int[7];
   public static HashSet<String> hs=new HashSet<>();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("geteven.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("geteven.out")));
      StringTokenizer read=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(read.nextToken());
      for(int i=0;i<N;i++){
         read=new StringTokenizer(br.readLine());
         String str=read.nextToken();
         boolean even=(Integer.parseInt(read.nextToken())%2==0);
         int index=-1;
         if(str.equals("B"))index=0;
         if(str.equals("E"))index=1;
         if(str.equals("S"))index=2;
         if(str.equals("I"))index=3;
         if(str.equals("G"))index=4;
         if(str.equals("O"))index=5;
         if(str.equals("M"))index=6;
         if(even)evens[index]++;
         else odds[index]++;
      }
      ArrayList<Integer> combos=new ArrayList<>();
      for(int i=0;i<7;i++){
         combos.add(0);
      }
      dfs(combos,0);
      for(String a:hs){
         StringTokenizer s=new StringTokenizer(a);
         long num=1;
         for(int i=0;i<7;i++){
            if(Integer.parseInt(s.nextToken())%2==0){
               num*=evens[i];
            }
            else num*=odds[i];
         }
         count+=num;
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static void dfs(ArrayList<Integer> combos, int index){
      if(combos.get(index)>1){
         return;
      }
      ArrayList<Integer> copy=new ArrayList<>();
      for(int i=0;i<7;i++){
         copy.add(combos.get(i));
      }
      for(int i=index+1;i<7;i++){
         dfs(copy,i);
      }
      if(calculate(copy)%2==0){
         hs.add(copy.get(0)+" "+copy.get(1)+" "+copy.get(2)+" "+copy.get(3)+" "+copy.get(4)+" "+copy.get(5)+" "+copy.get(6));
      }
      if(copy.get(index)==0){
         copy.set(index, copy.get(index)+1);
         dfs(copy, index);
      }
   }
   public static int calculate(ArrayList<Integer> combos){
      int B=combos.get(0),E=combos.get(1),S=combos.get(2),I=combos.get(3),G=combos.get(4),O=combos.get(5),M=combos.get(6);
      int num=(B+2*E+2*S+I)*(G+O+E+S)*(M+2*O);
      return num;
   }
}