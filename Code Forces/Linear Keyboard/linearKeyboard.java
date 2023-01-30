import java.util.*;
import java.io.*;
public class linearKeyboard{
   public static void main(String[] args) throws IOException{
      BufferedReader f= new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(f.readLine());
      int t=Integer.parseInt(s.nextToken());
      HashMap<Character,Integer> map=new HashMap<Character,Integer>();
      for(int i=0;i<2*t;i+=2){
         s=new StringTokenizer(f.readLine());
         String keyboard=s.nextToken();
         for(int k=0;k<keyboard.length();k++){
            map.put(keyboard.charAt(k),k);
         }
         s=new StringTokenizer(f.readLine());
         String word=s.nextToken();
         int time=0;
         int previousIndex=map.get(word.charAt(0));
         for(int k=1;k<word.length();k++){
            int index=map.get(word.charAt(k));
            time+=Math.abs(index-previousIndex);
            previousIndex=index;
         }
         System.out.println(time);
      }
   }
}