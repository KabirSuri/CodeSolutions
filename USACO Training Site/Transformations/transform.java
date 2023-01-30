/*
ID: surikab1
LANG: JAVA
TASK: transform
*/
import java.util.*;
import java.io.*;
public class transform{
   public static char[][] original;
   public static char[][] changed;
   public static int N;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("transform.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      original=new char[N][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<N;k++){
            original[i][k]=str.charAt(k);
         }
      }
      changed=new char[N][N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String str=s.nextToken();
         for(int k=0;k<N;k++){
            changed[i][k]=str.charAt(k);
         }
      }
      boolean printed=false;
      char[][] arr=rotate(original);
      if(verify(arr)){
         System.out.println(1);
         pw.println(1);
         printed=true;
      }
      arr=rotate(arr);
      if(!printed&&verify(arr)){
         System.out.println(2);
         pw.println(2);
         printed=true;
      }
      arr=rotate(arr);
      if(!printed&&verify(arr)){
         System.out.println(3);
         pw.println(3);
         printed=true;
      }
      arr=flip(original);
      if(!printed&&verify(arr)){
         System.out.println(4);
         pw.println(4);
         printed=true;
      }
      else if(!printed){
         arr=rotate(arr);
         boolean one=verify(arr);
         arr=rotate(arr);
         boolean two=verify(arr);
         arr=rotate(arr);
         boolean three=verify(arr);
         if(one||two||three){
            printed=true;
            System.out.println(5);
            pw.println(5);
         }
      }
      if(!printed&&verify(original)){
         System.out.println(6);
         pw.println(6);
         printed=true;
      }
      if(!printed){
         System.out.println(7);
         pw.println(7);
      }
      pw.close(); 
   }
   public static char[][] rotate(char[][] arr){
      char[][] copy=new char[N][N];
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            copy[i][k]=arr[N-k-1][i];
         }
      }
      return copy;
   }
   public static char[][] flip(char[][] arr){
      char[][] copy=new char[N][N];
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            copy[i][k]=arr[i][N-k-1];
         }
      }
      return copy;
   }
   public static boolean verify(char[][] first){
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(first[i][k]!=changed[i][k])
               return false;
         }
      }
      return true;
   }
}