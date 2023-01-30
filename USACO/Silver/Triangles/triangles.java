import java.util.*;
import java.io.*;
public class triangles{
   public static int N;
   public static int[][] arr;
   public static HashMap<Integer,ArrayList<Integer>> xMap=new HashMap<Integer,ArrayList<Integer>>();
   public static HashSet<Integer> xSet=new HashSet<Integer>();
   public static HashMap<Integer,ArrayList<Integer>> yMap=new HashMap<Integer,ArrayList<Integer>>();
   public static HashSet<Integer> ySet=new HashSet<Integer>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      arr=new int[N][2];
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken()), b=Integer.parseInt(s.nextToken());
         arr[i][0]=a;
         arr[i][1]=b;
         if(!xSet.contains(a)){
            xSet.add(a);
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(b);
            xMap.put(a,temp);
         }
         else{
            xMap.get(a).add(b);
         }
         if(!ySet.contains(b)){
            ySet.add(b);
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(a);
            yMap.put(b,temp);
         }
         else{
            yMap.get(b).add(a);
         }
      }
      int sum=0;
      int i,length,width;
      for(i=0;i<N;i++){
         if(xMap.get(arr[i][0]).size()>1&&xMap.get(arr[i][0]).size()>1){
            for(int k:xMap.get(arr[i][0])){
               if(k!=arr[i][1]){
                  length=Math.abs(arr[i][1]-k);
                  for(int j:yMap.get(arr[i][1])){
                     if(j!=arr[i][0]){
                        width=Math.abs(arr[i][0]-j);
                        sum+=(width*length);
                        sum=sum%(1000000000+7);
                     }
                  }
               }
            }
         }
      }
      System.out.println(sum);
      pw.println(sum);
      pw.close();
   }
}