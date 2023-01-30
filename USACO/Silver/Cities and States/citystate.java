import java.util.*;
import java.io.*;
public class citystate{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken());
      HashSet<String> fSet=new HashSet<String>(), rSet=new HashSet<String>();
      HashMap<String,Integer> fMap=new HashMap<String,Integer>(), rMap=new HashMap<String,Integer>();
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         String city=s.nextToken().substring(0,2);
         String state=s.nextToken();
         if(city.equals(state))
            continue;
         String f=city+state;
         String r=state+city;
         if(!fSet.contains(f)){
            fSet.add(f);
            fMap.put(f,1);
         }
         else{
            fMap.replace(f,fMap.get(f)+1);
         }
         if(!rSet.contains(r)){
            rSet.add(r);
            rMap.put(r,1);
         }
         else{
            rMap.replace(r,rMap.get(r)+1);
         }
      }
      int count=0;
      for(String str: fSet){
         if(rSet.contains(str)){
            count+=fMap.get(str)*rMap.get(str);
         }
      }
      count/=2;
      System.out.println(count);
      pw.println(count);
      pw.close();
   }
}