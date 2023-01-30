import java.util.*;
import java.io.*;
public class odometer{
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("odometer.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("odometer.out")));
      StringTokenizer sT=new StringTokenizer(br.readLine());
      int[] X=longToArr(Long.parseLong(sT.nextToken()));
      int[] Y=longToArr(Long.parseLong(sT.nextToken()));
      int[] gen=new int[17];
      long count=0;
      for(int f=14;f>=0;f--){
         for(int n=0;n<=9;n++){
            for(int i=f;i<=16;i++)gen[i]=n;
            for(int s=f;s<=16;s++){
               if(s>f&&gen[f]==0)break;
               for(int m=0;m<=9;m++){
                  if(m==n)continue;
                  gen[s]=m;
                  boolean interesting=interesting(gen,f);
                  if(compareTo(gen,X)>=0&&compareTo(gen,Y)<=0&&interesting){
                     count++;
                  }
               }
               gen[s]=n;
            }
         }
      }
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
   public static int[] longToArr(long a){
      int[] arr=new int[17];
      for(int i=16;i>=0;i--){
         arr[i]=(int)(a%10);
         a/=10;
      }
      return arr;
   }
   public static boolean interesting(int[] a, int index){
      while(a[index]==0)index++;
      int num=a[index];
      for(int i=index;i<=16;i++){
         if(a[i]!=num)return true;
      }
      return false;
   }
   public static int compareTo(int[] a, int[] b){
      int sum=0;
      for(int i=0;i<a.length;i++){
         sum+=(a[i]-b[i]);
         if(sum!=0)return sum;
      }
      return 0;
   }
}