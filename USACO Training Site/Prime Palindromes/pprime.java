/*
ID: surikab1
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;
public class pprime {
    public static void main(String[] args) throws Exception {
        //long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer line = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(line.nextToken());
        int end = Integer.parseInt(line.nextToken());
        List<Integer> pals = generatePal(0, 0, 3);
        HashSet<Integer> ps = new HashSet<Integer>();
        ps.addAll(pals);
        pals = new ArrayList<Integer>();
        pals.addAll(ps);
        pals.sort(Comparator.naturalOrder());
        for (int i = 0; i < pals.size(); i++) {
            if (pals.get(i)>=start && pals.get(i)<=end) {
                out.println(pals.get(i));
            }
        }
        br.close();
        out.close();
    }
    public static List<Integer> generatePal(int digits, int N, int max) {
        List<Integer> pals = new ArrayList<Integer>();
        String temp1 = String.valueOf(digits);
        StringBuilder temp2 = new StringBuilder(temp1);
        temp1+=temp2.reverse();
        if (isPrime(Integer.parseInt(temp1))) {
            pals.add(Integer.parseInt(temp1));
        }
        if (N>1) {
            int temp3 = digits/10;
            temp1 = String.valueOf(digits);
            temp2 = new StringBuilder(String.valueOf(temp3));
            temp1+=temp2.reverse();
            if (isPrime(Integer.parseInt(temp1))) {
                pals.add(Integer.parseInt(temp1));
            }
        } else if (isPrime(digits)) {
            pals.add(digits);
        }    
        if (N==0) {
            for (int d = 1; d <= 9; d+=2) {
                pals.addAll(generatePal(d, N+1, max));
            }
        } else if (N<=max) {
            for (int d = 0; d <= 9; d++) {
                int temp = digits*10;
                temp+=d; 
                pals.addAll(generatePal(temp, N+1, max));
            }
        }
        return pals;
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
