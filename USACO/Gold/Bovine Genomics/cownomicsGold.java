import java.util.*;
import java.io.*;
public class cownomicsGold{
   public static int N;
   public static int M;
   public static boolean seen[];
   public static String[] spotty;
   public static String[] plain;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      spotty=new String[N];
      plain=new String[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         spotty[i]=s.nextToken();
      }
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         plain[i]=s.nextToken();
      }
      int a = 1, b = M;
      while (a != b) {
         int mid = (a+b)/2;
         if (works(mid)) {
            b = mid;
         }
         else {
            a = mid+1;
         }
      }      
            
      System.out.println(a);
      pw.println(a);
      pw.close();
   }
   public static boolean works(int length){
      for(int i=0;i<=M-length;i++){
         HashSet<String> spottedSequences=new HashSet<String>();
         for(int k=0;k<N;k++){
            spottedSequences.add(spotty[k].substring(i,i+length));
         }
         boolean contains=false;
         for(int k=0;k<N;k++){
            if(spottedSequences.contains(plain[k].substring(i,i+length))){
               contains=true;
               break;
            }
         }
         if(!contains)return true;
      }
      return false;
   }
}