/*
ID: surikab1
LANG: JAVA
TASK: sprime
*/
import java.util.*;
import java.io.*;
public class sprime{
   public static int N;
   public static int[] primeOnes={1,2,3,5,7,9};
   public static TreeSet<String> sprimes=new TreeSet<String>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      generatePrimes("",0);
      for(String i:sprimes){
         //System.out.println(i);
         pw.println(i);
      }
      pw.close();
   }
   public static void generatePrimes(String number, int index){
      if(index==N){
         sprimes.add(number);
         return;
      }
      for(int i:primeOnes){
         if(isPrime(Integer.parseInt(number+i)))generatePrimes(number+i,index+1);
      }
   }
   public static boolean isPrime(int number) {
        int sqrt=(int)Math.sqrt(number);
        if(number==2)return true;
        if(number%2==0||number==1)return false;
        for (int i = 3; i<=sqrt; i+=2) {
            if (number%i==0){
                return false;
            }
        }
        return true;
    }
}