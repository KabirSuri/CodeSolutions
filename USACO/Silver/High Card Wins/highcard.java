import java.util.*;
import java.io.*;
public class highcard{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(s.nextToken());
      int[] arr=new int[2*N];
      int[] elsie=new int[N];
      ArrayList<Integer> bessie=new ArrayList<>();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         arr[a]=1;
         elsie[i]=a;
      }
      Arrays.sort(elsie);
      for(int i=0;i<2*N;i++){
         if(arr[i]==0){
            bessie.add(i);
         }
      }
      int points=0;
      for(int i=0;i<N;i++){
         boolean pointLost=false;
         boolean pointWon=true;
         while(pointWon){
            if(bessie.size()==0){
               pointLost=true;
               break;
            }
            if(bessie.get(0)>elsie[i]){
               points++;
               pointWon=false;
            }
            bessie.remove(0);
         }
         if(pointLost){
            break;
         }
      }      
      //System.out.println(points);
      pw.println(points);
      pw.close();
   }
}