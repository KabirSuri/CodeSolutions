import java.util.*;
import java.io.*;
public class cowjog{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cowjog.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
        StringTokenizer s=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(s.nextToken());
        long T=Long.parseLong(s.nextToken());
        long[] cows=new long[N];
        for(int i=0;i<N;i++){
            s=new StringTokenizer(br.readLine());
            long n=Long.parseLong(s.nextToken());
            cows[i]=n+Long.parseLong(s.nextToken())*T;
        }
        long end=Long.MAX_VALUE;
        int groups=0;
        for(int i=cows.length-1;i>=0;i--){
            if(cows[i]<end){
                end=cows[i];
                groups++;
            }
        }
        System.out.println(groups);
        pw.println(groups);
        pw.close();
    }
}