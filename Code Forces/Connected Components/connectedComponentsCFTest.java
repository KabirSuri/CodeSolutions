import java.util.*;
import java.io.*;
public class connectedComponentsCFTest{
   public static int N;
   public static int M;
   public static HashSet<String> banned=new HashSet<String>();
   public static ArrayList<Integer>[] graph;
   public static ArrayList<Integer> componentSizes=new ArrayList<Integer>();
   public static int[] fill;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      graph=new ArrayList[N];
      fill=new int[N];
      Arrays.fill(fill,-1);
      for(int i=0;i<N;i++){
         graph[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         banned.add(a+" "+b);
         banned.add(b+" "+a);
      }
      for(int i=0;i<N;i++){
         for(int k=i+1;k<N;k++){
            if(!banned.contains(i+" "+k)){
               graph[i].add(k);
               graph[k].add(i);
            }
         
      }
      int color=-1;
      for(int i=0;i<N;i++){
         if(fill[i]==-1){
            color++;
            componentSizes.add(0);
            dfs(i,color);
         }
      }
      Collections.sort(componentSizes);
      System.out.println(componentSizes.size());
      for(int i=0;i<componentSizes.size();i++){
         System.out.print(componentSizes.get(i)+" ");
      }
   }
   public static void dfs(int index, int color){
      if(fill[index]==color)
         return;
      fill[index]=color;
      componentSizes.set(color,componentSizes.get(color)+1);
      for(int i:graph[index]){
         dfs(i,color);
      }
   }
}