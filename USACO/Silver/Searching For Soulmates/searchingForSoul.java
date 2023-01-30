import java.util.*;
import java.io.*;
public class searchingForSoul{
   public static int N;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      StringBuffer out=new StringBuffer();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         long a=Long.parseLong(s.nextToken()), b=Long.parseLong(s.nextToken());
         TreeMap<Long,Long> bFactors=new TreeMap<Long,Long>();
         long oper=0;
         long pos=1;
         bFactors.put(b,0L);
         while(b>0){
            if(b%2==1){
               b--;
               bFactors.put(b,pos);
               pos++;
            }
            else{
               b/=2;
               bFactors.put(b,pos);
               pos++;
            }
         }
         while(true){
            Long fPos=bFactors.get(a);
            if(fPos!=null){
               oper+=fPos;
               break;
            }
            Long nearest=bFactors.ceilingKey(a);
            if(a%2==1){a++; oper++;}
            if(nearest==null){
               a/=2;
               oper++;
            }
            else{
               Long nearest2=bFactors.ceilingKey(a/2);
               if(nearest-a<bFactors.get(nearest2)-bFactors.get(nearest)+nearest2-a/2+1){
                  oper+=nearest-a+bFactors.get(nearest);
                  break;
               }
               else{
                  oper++;
                  a/=2;
               }
            }
         }
         out.append(oper+"\n");
      }
      System.out.print(out);
   }
}
class Factor implements Comparable<Factor>{
   long num;
   int pos;
   public Factor(long n,int p){
      num=n;
      pos=p;
   }
   public int compareTo(Factor o){
      return pos-o.pos;
   }
}