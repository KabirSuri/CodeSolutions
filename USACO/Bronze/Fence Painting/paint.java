import java.util.*;
import java.io.*;
public class paint{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("paint.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int N=Integer.parseInt(s.nextToken()), K=Integer.parseInt(s.nextToken()), currentIndex=0;
      ArrayList<Integer> indexes=new ArrayList<Integer>();
      HashSet<Integer> hs=new HashSet<Integer>();
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
      map.put(0,0);
      hs.add(0);
      indexes.add(0);
      
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine()); 
         int change=Integer.parseInt(s.nextToken());
         char dir=s.nextToken().charAt(0);
         if(dir=='L')change*=-1;
         int oldIndex=currentIndex;
         currentIndex+=change;
         int min=Math.min(oldIndex,currentIndex);
         int max=Math.max(oldIndex,currentIndex);
         if(!hs.contains(min)){
            indexes.add(min);
            map.put(min,0);
            hs.add(min);
         }
         if(!hs.contains(max)){
            indexes.add(max);
            map.put(max,0);
            hs.add(max);
         }
         map.replace(min,map.get(min)+1);
         map.replace(max,map.get(max)-1);
      }
      Collections.sort(indexes);
      int sum=0,totalArea=0;
      for(int i=0;i<indexes.size();i++){
         sum+=map.get(indexes.get(i));
         if(sum>=K){
            totalArea+=(indexes.get(i+1)-indexes.get(i));
         }
      }
      
      System.out.println(totalArea);
      pw.println(totalArea);
      pw.close();
   }
}