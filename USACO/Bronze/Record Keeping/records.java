import java.util.*;
import java.io.*;
public class records{
   public static int N;
   public static HashMap<String, Integer> map=new HashMap<String, Integer>();
   public static HashSet<String> set=new HashSet<String>();
   public static int max=-1;
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("records.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( "records.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String[] arr={s.nextToken(),s.nextToken(),s.nextToken()};
         Arrays.sort(arr);
         add(arr[0]+" "+arr[1]+" "+arr[2]);
      }
      
      System.out.println(max);
      pw.println(max);
      pw.close();
   }
   public static void add(String str){
      if(!set.contains(str)){
         set.add(str);
         map.put(str,1);
      }
      else{
         map.replace(str, map.get(str)+1);
         max=Math.max(map.get(str),max);
      }
   }
}