import java.util.*;
import java.io.*;
public class redistributingGifts{
   public static int N;
   public static int[][] preferences;
   public static HashSet<Integer> backwards[];
   public static int[] min;
   public static boolean[] visited;
   public static int last;
   public static StringBuffer out=new StringBuffer();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("redistributingGifts.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      preferences=new int[N][N];
      backwards=new HashSet[N];
      min=new int[N];
      for(int i=0;i<N;i++){
         backwards[i]=new HashSet<Integer>();
      }
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         for(int k=0;k<N;k++){
            preferences[i][k]=Integer.parseInt(s.nextToken())-1;
            if(i==preferences[i][k]){
               min[i]=i;
               break;
            }
            backwards[preferences[i][k]].add(i);
         }
      }
      /*for(int i=0;i<N;i++){
         System.out.println(backwards[i]);
      }*/
      visited=new boolean[N];
      for(int i=0;i<N;i++){
         if(!visited[i]){
            backDfs(i,i);
            //System.out.println();
         }
      }
      visited=new boolean[N];
      for(int i=0;i<N;i++){
         if(!visited[i]){
            backDfs(i,i);
            //System.out.println();
         }
      }
      /*for(int i=0;i<N;i++){
         //System.out.println(backwards[i]);
      }*/
      for(int i=0;i<N;i++){
         for(int k=0;k<N;k++){
            if(preferences[i][k]==i){
               out.append((i+1)+"\n");
               break;
            }
            if(backwards[i].contains(preferences[i][k])){
               out.append((preferences[i][k]+1)+"\n");
               break;
            }
         }
      }
      System.out.print(out);
   }
   public static void backDfs(int current, int previous){
      //System.out.println(current+" "+previous);
      backwards[previous].addAll(backwards[current]);
      if(visited[current])return;
      last=current;
      visited[current]=true;
      HashSet<Integer> temp=new HashSet<Integer>();
      temp.addAll(backwards[current]);
      for(int i:temp){
         backDfs(i,current);
      }
      backwards[previous].addAll(backwards[current]);
   }
}