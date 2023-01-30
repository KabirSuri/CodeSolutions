/*
ID: surikab1
LANG: JAVA
TASK: ariprog
*/
/*
ID: surikab1
LANG: JAVA
TASK: ariprog
*/
import java.util.*;
import java.io.*;
public class ariprog{
   public static int N;
   public static int M;
   public static HashSet<Integer> bisquares=new HashSet<Integer>();
   public static ArrayList<Answer> answers=new ArrayList<Answer>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      M=Integer.parseInt(s.nextToken());
      for(int p=0;p<=M;p++){
         for(int q=p;q<=M;q++){
            bisquares.add(p*p+q*q);
         }
      }
      int upperBound=2*M*M;
      for(int a:bisquares){
         for(int b=1;a+b*(N-1)<=upperBound;b++){
            int sum=a;
            boolean works=true;
            for(int i=1;i<N;i++){
               sum+=b;
               if(sum>2*M*M||!bisquares.contains(sum)){
                  works=false;
                  break;
               }
            }
            if(works)answers.add(new Answer(a,b));
         }
      }
      Collections.sort(answers);
      for(int i=0;i<answers.size();i++){
         //System.out.println(answers.get(i).a+" "+answers.get(i).b);
         pw.println(answers.get(i).a+" "+answers.get(i).b);
      }
      if(answers.size()==0)pw.println("NONE");
      pw.close();
   }
}
class Answer implements Comparable<Answer>{
   int a;
   int b;
   public Answer(int A, int B){
      a=A;
      b=B;
   }
   public int compareTo(Answer other){
      if(b==other.b)return a-other.a;
      return b-other.b;
   }
}
/*import java.util.*;
import java.io.*;
public class ariprog{
   public static int N;
   public static int M;
   public static HashSet<Integer> bisquares=new HashSet<Integer>();
   public static void main(String[] args)throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      s=new StringTokenizer(br.readLine());
      M=Integer.parseInt(s.nextToken());
      for(int p=0;p<=M;p++){
         for(int q=p;q<=M;q++){
            bisquares.add(p*p+q*q);
         }
      }
      int upperBound=2*M*M;
      boolean setExists=false;
      int b=1;
      int bMultiplied=b*(N-1);
      while(bMultiplied<=upperBound){
         for(int a=0;a+bMultiplied<=upperBound;a++){
            if(bisquares.contains(a)){
               int sum=a;
               boolean works=true;
               for(int i=1;i<N;i++){
                  sum+=b;
                  if(!bisquares.contains(sum)){
                     works=false;
                     break;
                  }
               }
               if(works){
                  //System.out.println(a+" "+b);
                  pw.println(a+" "+b);
                  setExists=true;
               }
            }
         }
         b++;
         bMultiplied=b*(N-1);
      }
      if(!setExists)pw.println("NONE");
      pw.close();
   }
}*/