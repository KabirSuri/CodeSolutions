import java.util.*;
import java.io.*;
public class nocow{
   static int N;
   static int K;
   static ArrayList<ArrayList<String>> combos=new ArrayList<>();
   static HashSet<String> strings=new HashSet<>();
   static TreeSet<String> notHas=new TreeSet<>();
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader("nocow.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("nocow.out")));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      K=Integer.parseInt(s.nextToken())-1;
      for(int i=0;i<N;i++){
         s=new StringTokenizer(br.readLine());
         int index=0;
         String builder="";
         for(int k=0;k<4;k++)s.nextToken();
         String str=s.nextToken();
         while(!str.equals("cow.")){
            if(!strings.contains(str)){
               if(index>=combos.size())combos.add(new ArrayList<String>());
               combos.get(index).add(str);
               strings.add(str);
            }
            builder+=(str+" ");
            index++;
            str=s.nextToken();
         }
         notHas.add(builder);
      }
      for(int i=0;i<combos.size();i++){
         Collections.sort(combos.get(i));
      }
      for(String str:notHas){
         s=new StringTokenizer(str);
         int arr[]=new int[combos.size()];
         for(int i=0;i<combos.size();i++){
            String token=s.nextToken();
            for(int k=0;k<combos.get(i).size();k++){
               if(token.equals(combos.get(i).get(k))){
                  arr[i]=k;
                  break;
               }
            }
         }
         if(arrToInt(arr)<=K)K++;
      }
      int arr[]=new int[combos.size()];
      String ans=dfs(arr,0);
      System.out.println(ans);
      pw.println(ans);
      pw.close();
   }
   public static String dfs(int[] arr,int index){
      if(index>=combos.size())return arrToStr(arr);
      for(int i=0;i<combos.get(index).size();i++){
         arr[index]++;
         if(arrToInt(arr)>K){
            arr[index]--;
            break;
         }
      }
      return dfs(arr,index+1);
   }
   public static String arrToStr(int[] arr){
      String builder="";
      for(int i=0;i<arr.length-1;i++){
         builder+=combos.get(i).get(arr[i])+" ";
      }
      builder+=combos.get(combos.size()-1).get(arr[combos.size()-1]);
      return builder;
   }
   public static int arrToInt(int[] arr){
      int num=0;
      int place=1;
      for(int i=arr.length-1;i>=0;i--){
         num+=place*arr[i];
         place*=combos.get(i).size();
      }
      return num;
   }
}