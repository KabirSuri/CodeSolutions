import java.io.*;
import java.util.*;
public class MovieFestival2 {
	public static void main(String[] args){
	   FastIO io=new FastIO();
      int N=io.nextInt();
      int K=io.nextInt();
      TreeMap<Integer,Integer> bValues=new TreeMap<>();
      Interval[] arr=new Interval[N];
      for(int i=0;i<N;i++){
         arr[i]=new Interval(io.nextInt(),io.nextInt());
      }
      Arrays.sort(arr);
      int count=0;
      bValues.put(0,K);
      for(int i=0;i<N;i++){
         int a=arr[i].a;
         int b=arr[i].b;
         Integer floorKey=bValues.floorKey(a);
         if(floorKey!=null){
            bValues.put(floorKey,bValues.get(floorKey)-1);
            if(bValues.get(floorKey)==0)bValues.remove(floorKey);
            floorKey=bValues.floorKey(a);
            if(bValues.get(b)==null)bValues.put(b,0);
            bValues.put(b,bValues.get(b)+1);
            count++;
         }
      }
      io.println(count);
      io.close();
   }
}
class Interval implements Comparable<Interval>{
   int a;
   int b;
   public Interval(int A, int B){
      a=A;
      b=B;
   }
   public int compareTo(Interval o){
      if(b==o.b)return o.a-a;
      return b-o.b;
   }
}
class FastIO extends PrintWriter {
	private InputStream stream;
	private byte[] buf = new byte[1 << 16];
	private int curChar;
	private int numChars;

	// standard input
	public FastIO() { this(System.in, System.out); }

	public FastIO(InputStream i, OutputStream o) {
		super(o);
		stream = i;
	}

	// file input
	public FastIO(String i, String o) throws IOException {
		super(new FileWriter(o));
		stream = new FileInputStream(i);
	}

	// throws InputMismatchException() if previously detected end of file
	private int nextByte() {
		if (numChars == -1) {
			throw new InputMismatchException();
		}
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars == -1) {
				return -1;  // end of file
			}
		}
		return buf[curChar++];
	}

	// to read in entire lines, replace c <= ' '
	// with a function that checks whether c is a line break
	public String next() {
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');

		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = nextByte();
		} while (c > ' ');
		return res.toString();
	}

	public int nextInt() {  // nextLong() would be implemented similarly
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');

		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = nextByte();
		}

		int res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res = 10 * res + c - '0';
			c = nextByte();
		} while (c > ' ');
		return res * sgn;
	}

	public double nextDouble() { return Double.parseDouble(next()); }
}