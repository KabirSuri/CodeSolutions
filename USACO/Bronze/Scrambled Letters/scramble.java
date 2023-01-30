import java.util.*;
import java.io.*;
public class scramble{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("scramble.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("scramble.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      Word[] allStrings=new Word[2*N];
      int[][] ans=new int[N][2];
      for(int i=0;i<2*N;i+=2){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         char arr[]=str.toCharArray();
         Arrays.sort(arr);
         String f=new String(arr);
         String r=new StringBuilder(f).reverse().toString();
         allStrings[i]=new Word(false, f, i/2);
         allStrings[i+1]=new Word(true, r, i/2);
      }
      Arrays.sort(allStrings);
      int reverse=1;
      int forward=1;
      for(int i=0;i<2*N;i++){
         if(allStrings[i].reverse){
            reverse++;
            ans[allStrings[i].position][1]=forward-1;
         }
         else{
            forward++;
            ans[allStrings[i].position][0]=reverse;
         }
      }
      for(int i=0;i<N;i++){
         pw.println(ans[i][0]+" "+ans[i][1]);
      }
      pw.close();
   }
}
class Word implements Comparable<Word>{
   boolean reverse;
   String str;
   int position;
   public Word(boolean r, String s, int p){
      reverse=r;
      str=s;
      position=p;
   }
   public int compareTo(Word other){
      if(str.compareTo(other.str)==0){
         if(other.reverse)return 1;
      }
      return str.compareTo(other.str);
   }
}