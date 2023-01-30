import java.util.*;
import java.io.*;
public class nocow{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("nocow.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("nocow.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      int K=Integer.parseInt(s.nextToken());
      ArrayList<ArrayList<String>> combos=new ArrayList<>();
      HashSet<String> strings=new HashSet<>();
      HashSet<String> has=new HashSet<>();
      
      
      System.out.println((bIndex-aIndex+1));
      pw.println((bIndex-aIndex+1));
      pw.close();
   }
}