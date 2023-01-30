/*
ID: surikab1
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;
public class namenum{
   public static HashMap<String,String[]> map=new HashMap<String,String[]>();
   public static HashSet<String> validNames=new HashSet<String>();
   public static TreeSet<String> answer=new TreeSet<String>();
   public static String ID;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      ID=s.nextToken();
      map.put("2",new String[]{"A","B","C"});
      map.put("3",new String[]{"D","E","F"});
      map.put("4",new String[]{"G","H","I"});
      map.put("5",new String[]{"J","K","L"});
      map.put("6",new String[]{"M","N","O"});
      map.put("7",new String[]{"P","R","S"});
      map.put("8",new String[]{"T","U","V"});
      map.put("9",new String[]{"W","X","Y"});
      String line;
      br = new BufferedReader(new FileReader("dict.txt"));
      while((line=br.readLine())!=null){
         validNames.add(line);
      }
      permutations("",0,ID.length());
      for(String i:answer){
         System.out.println(i);
         pw.println(i);
      }
      if(answer.size()==0){
         System.out.println("NONE");
         pw.println("NONE");
      }
      pw.close();
   }
   public static void permutations(String name, int index, int end){
      if(index==end){
         if(validNames.contains(name))answer.add(name);
         return;
      }
      String[] arr=map.get(ID.substring(index,index+1));
      for(int i=0;i<arr.length;i++){
         permutations(name+arr[i],index+1,end);
      }
   }
}