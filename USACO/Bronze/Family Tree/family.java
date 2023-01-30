import java.util.*;
import java.io.*;
public class family{
   public static int[] visited;
   public static ArrayList<Integer> graph=new ArrayList<>();
   public static int N;
   public static HashMap<String, Integer> hm=new HashMap<>();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("family.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      int position=2;
      String strA=s.nextToken(), strB=s.nextToken();
      hm.put(strA,0);
      hm.put(strB,1);
      graph.add(-1);
      graph.add(-1);
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String x=s.nextToken();
         String y=s.nextToken();
         if(hm.get(x)==null){
            hm.put(x,position);
            graph.add(-1);
            position++;
         }
         if(hm.get(y)==null){
            hm.put(y,position);
            graph.add(-1);
            position++;
         }
         graph.set(hm.get(y),hm.get(x));
      }
      visited=new int[hm.size()];
      Arrays.fill(visited,-1);
      for(int i=0,generations=0;i!=-1;generations++,i=graph.get(i)){
         visited[i]=generations;
      }
      int a=-1,b=0;
      for(int i=1;i!=-1;b++,i=graph.get(i)){
         if(visited[i]>-1){
            a=visited[i];
            break;
         }
      }
      String is=" is the ";
      String of=" of ";
      String ans="NOT RELATED";
      if(a==1&&b==1)ans="SIBLINGS";
      else if(a==1&&b>=2){
         ans=strA+is;
         for(int i=0;i<b-2;i++)ans+="great-";
         ans+="aunt"+of+strB;
      }
      else if(a>=2&&b==1){
         ans=strB+is;
         for(int i=0;i<a-2;i++)ans+="great-";
         ans+="aunt"+of+strA;
      }
      else if(a>=2&&b>=2)ans="COUSINS";
      else if(a==0&&b>=2){
         ans=strA+is;
         for(int i=0;i<b-2;i++)ans+="great-";
         ans+="grand-mother"+of+strB;
      }
      else if(a>=2&&b==0){
         ans=strB+is;
         for(int i=0;i<a-2;i++)ans+="great-";
         ans+="grand-mother"+of+strA;
      }
      else if(a==0&&b==1){
         ans=strA+is+"mother"+of+strB;
      }
      else if(a==1&&b==0){
         ans=strB+is+"mother"+of+strA;
      }
      System.out.println(ans);
      pw.println(ans);
      pw.close();
   }
}