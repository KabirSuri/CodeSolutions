import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Arrays;



public class emailFiling{
   public static StringBuffer out=new StringBuffer();
   public static void main(String[] args) throws IOException{
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      //BufferedReader br = new BufferedReader(new FileReader("redistributingGifts.in"));
      StringTokenizer s=new StringTokenizer(br.readLine());
      int T=Integer.parseInt(s.nextToken());
      for(int t=0;t<T;t++){
         s=new StringTokenizer(br.readLine());
         int M=Integer.parseInt(s.nextToken());
         int N=Integer.parseInt(s.nextToken());
         int K=Integer.parseInt(s.nextToken());
         TreeMap<Integer,Integer> multiset=new TreeMap<Integer,Integer>();
         TreeSet<Integer> positions[]=new TreeSet[M];
         for(int i=0;i<M;i++){
            positions[i]=new TreeSet<Integer>();
         }
         int[] emails=new int[N];
         boolean[] filed=new boolean[N];
         s=new StringTokenizer(br.readLine());
         for(int i=0;i<N;i++){
            emails[i]=Integer.parseInt(s.nextToken())-1;
            if(multiset.get(emails[i])==null)multiset.put(emails[i],0);
            multiset.put(emails[i],multiset.get(emails[i])+1);
            positions[emails[i]].add(i);
         }
         Integer topFile=multiset.firstKey();
         int currentEmail=0;
         int numFiled=0;
         int direction=1;
         int highestEmailFiled=-1;
         boolean no=false;
         boolean turnAround=false;
         //int turnAroundCount=0;
         int highestVisited=0;
         while(numFiled!=N){
            //System.out.println("line 29");
            /*if(emails[currentEmail]<topFile){
               no=true;
               System.out.println("line 33");
               break;
            }*/
            highestVisited=Math.max(highestVisited,currentEmail);
            if(!filed[currentEmail]&&emails[currentEmail]-topFile>=0&&emails[currentEmail]-topFile<K){
               multiset.put(emails[currentEmail],multiset.get(emails[currentEmail])-1);
               if(multiset.get(emails[currentEmail])==0){
                  multiset.remove(emails[currentEmail]);
               }
               numFiled++;
               positions[emails[currentEmail]].remove(currentEmail);
               filed[currentEmail]=true;
            }
            System.out.println("numFiled:"+numFiled);
            System.out.println("emails:"+Arrays.toString(emails));
            System.out.println("filed:"+Arrays.toString(filed));
            System.out.println("multiSet:"+multiset);
            System.out.println("currentEmail:"+(currentEmail));
            if(direction==-1&&emails[currentEmail]-topFile>=K){
               if(turnAround==false||positions[topFile].first()<currentEmail){
                  no=true;
                  //System.out.println("line 46");
                  break;
               }
               direction=1;
               //turnAroundCount++;
            }
            if(numFiled==N){
               //System.out.println("line 50");
               break;
            }
            topFile=multiset.firstKey();
            if(currentEmail==N-1||positions[topFile].first()<currentEmail)direction=-1;
            if(direction==-1&&!filed[currentEmail]){
               turnAround=true;
            }
            if(direction==-1&&positions[topFile].first()>currentEmail)direction=1;
            do{currentEmail+=direction;}
            while(currentEmail>-1&&filed[currentEmail]);
            if(currentEmail==-1){
               direction=1;
               currentEmail=0;
            }
            /*if(direction==1)topFile=multiset.firstKey();
            if(direction==-1){
               System.out.println("SWITCH");
               //topFile=Math.max(emails[currentEmail]-K+1,topFile);
            }*/
            System.out.println("currentEmail:"+(currentEmail));
            System.out.println("direction:"+direction);
            System.out.println("topFile:"+topFile);
            System.out.println();
         }
         if(no){
            out.append("NO\n");
         }
         else{
            out.append("YES\n");
         }
      }
      System.out.print(out);
   }
}