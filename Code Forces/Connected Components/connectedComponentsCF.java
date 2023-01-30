import java.util.*;
import java.io.*;
public class connectedComponentsCF{
   public static int N;
   public static int M;
   public static HashSet<Integer> banned[];
   public static ArrayList<Integer> componentSizes=new ArrayList<Integer>();
   public static TreeSet<Integer> fill;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      banned=new HashSet[N];
      fill=new TreeSet<Integer>();
      for(int i=0;i<N;i++){
         banned[i]=new HashSet<Integer>();
         fill.add(i);
      }
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         banned[a].add(b);
         banned[b].add(a);
      }
      int color=-1;
      while(!fill.isEmpty()){
            color++;
            componentSizes.add(0);
            dfs(fill.first(),color);
      }
      Collections.sort(componentSizes);
      System.out.println(componentSizes.size());
      for(int i=0;i<componentSizes.size();i++){
         System.out.print(componentSizes.get(i)+" ");
      }
   }
   public static void dfs(int index, int color){
      if(!fill.contains(index))return;
      fill.remove(index);
      componentSizes.set(color,componentSizes.get(color)+1);
      for(int i=0;i<N;i++){
         if(!banned[index].contains(i)&&i!=index)
            dfs(i,color);
      }
   }
}