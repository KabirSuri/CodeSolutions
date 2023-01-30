import java.util.*;
import java.lang.*;
import java.io.*;
public class smallestStringConcatenation{
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      StringChunk[] inputs=new StringChunk[N];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         inputs[i]=new StringChunk(s.nextToken());
      }
      Arrays.sort(inputs);
      //System.out.println(Arrays.toString(inputs));
      StringBuffer buffer=new StringBuffer();
      for(int i=0;i<N;i++){
         buffer.append(inputs[i].str);
      }
      System.out.println(buffer);
   }
}
class StringChunk implements Comparable<StringChunk>{
   String str;
   public StringChunk(String s){
      str=s;
   }
   public int compareTo(StringChunk o){
      StringBuffer one=new StringBuffer(str);
      StringBuffer two=new StringBuffer(o.str);
      one.append(o.str);
      two.append(str);
      String oneS=one.toString();
      String twoS=two.toString();
      return oneS.compareTo(twoS);
   }
   public String toString(){
      return str;
   }
}