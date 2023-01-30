import java.util.*;
import java.io.*;
public class Multiple2019{
   public static String str;
   public static int[] modCount=new int[2019];
   public static int[] modPrefixes;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      str=s.nextToken();
      int N=str.length();
      modPrefixes=new int[N];
      modCount[0]++;
      modPrefixes[N-1]=Integer.parseInt(str.substring(N-1,N));
      modCount[modPrefixes[N-1]]++;
      int runningZeroes=0;
      for(int i=N-2;i>=0;i--){
         int digitCount=10;
         int temp=modPrefixes[i+1];
         while(temp/10>0){
            temp/=10;
            digitCount*=10;
         }
         digitCount*=Math.pow(10,runningZeroes);
         int digit=Integer.parseInt(str.substring(i,i+1));
         modPrefixes[i]=modPrefixes[i+1]+digit*digitCount;
         modPrefixes[i]%=2019;
         if(digit==0)runningZeroes++;
         else {
            runningZeroes=0;
            modCount[modPrefixes[i]]++;
         }
      }
      System.out.println(Arrays.toString(modPrefixes));
      //System.out.println(Arrays.toString(modCount));
      long count=0;
      for(int i=0;i<2019;i++){
         count+=modCount[i]*(modCount[i]-1)/2;
      }
      System.out.println(count);
   }
}