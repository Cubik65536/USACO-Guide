import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] w = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            w[i] = io.nextInt();
        }

        Arrays.sort(w);

        int result = (int) 1e9;
        for (int i = 0; i < 2 * n; i++) {
            for (int j = i + 1; j < 2 * n; j++) {
                int temp = 0;
                int prev = -1;
                for(int k = 0; k < 2 * n; k++){
                    if(k == i || k == j)
                        continue;
                    if(prev == -1){
                        prev = k;
                    }
                    else{
                        temp += w[k] - w[prev];
                        prev = -1;
                    }
                }
                result = Math.min(result, temp);
            }
        }

        io.println(result);

        io.close();
    }
}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in,System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName+".out"));
        r = new BufferedReader(new FileReader(problemName+".in"));
    }
    // read next line
    public String readLine() {
        try {
            return r.readLine();
        } catch (IOException e) {}
        return null;
    }
    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}
