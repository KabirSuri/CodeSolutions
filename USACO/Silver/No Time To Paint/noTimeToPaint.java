import java.util.*;
import java.io.*;
public class noTimeToPaint{
   public static int N;
   public static int Q;
   public static String fence;
   public static int[] prefix;
   public static int[] suffix;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      Q=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      prefix=new int[N+2];
      suffix=new int[N+2];
      fence=s.nextToken();
      Stack<String> stack=new Stack<>();
      for(int i=1;i<=N;i++){
         prefix[i]=prefix[i-1];
         while(!stack.isEmpty()&&stack.peek().compareTo(fence.substring(i-1,i))>0){
            stack.pop();
         }
         if(stack.isEmpty()||stack.peek().compareTo(fence.substring(i-1,i))<0){
            stack.add(fence.substring(i-1,i));
            prefix[i]++;
         }
      }
      stack=new Stack<>();
      for(int i=N;i>0;i--){
         suffix[i]=suffix[i+1];
         while(!stack.isEmpty()&&stack.peek().compareTo(fence.substring(i-1,i))>0){
            stack.pop();
         }
         if(stack.isEmpty()||stack.peek().compareTo(fence.substring(i-1,i))<0){
            stack.add(fence.substring(i-1,i));
            suffix[i]++;
         }
      }
      for(int i=0;i<Q;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken());
         int b=Integer.parseInt(s.nextToken());
         System.out.println((prefix[a-1]-prefix[0]+suffix[b+1]-suffix[N+1]));
      }
   }
}