import java.util.*;
import java.io.*;
public class auto{
   public static int W;
   public static int N;
   public static Word[] words;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("auto.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      W=Integer.parseInt(s.nextToken());
      N=Integer.parseInt(s.nextToken());
      
      words=new Word[W];
      for(int i=0;i<W;i++){
         s=new StringTokenizer(br.readLine());
         words[i]=new Word(s.nextToken(),(long)(i+1));
      }
      Arrays.sort(words);
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int index=Integer.parseInt(s.nextToken());
         String string=s.nextToken();     
         int start=0,end=W-1,mid=-1;
         while(mid!=(start+end)/2){
            mid=(start+end)/2;
            String temp=words[mid].str.substring(0,Math.min(string.length(),words[mid].str.length()));
            if(temp.compareTo(string)<0){
               start=mid+1; 
            }
            else{
               end=mid;
            }
         }
         int min=end;
         if(words[min].str.indexOf(string)!=0){
            //System.out.println(-1);
            pw.println(-1);
            continue;
         }
         if(min+index-1>=W||words[min+index-1].str.indexOf(string)!=0){
            //System.out.println(-1);
            pw.println(-1);
            continue;
         }
         //System.out.println(words[min+index-1].index);
         pw.println(words[min+index-1].index);
      }
      pw.close();
   }
}
class Word implements Comparable<Word>{
   public String str;
   public long index;
   public Word(String str, long index){
      this.str=str;
      this.index=index;
   }
   public String toString(){
      return str;
   }
   public int compareTo(Word other){
      return this.str.compareTo(other.str);
   }
}