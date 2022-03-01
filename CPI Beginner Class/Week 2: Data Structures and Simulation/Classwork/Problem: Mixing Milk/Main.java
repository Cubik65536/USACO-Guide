import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("mixmilk");

        int[][] buckets = new int[3][2];
        for (int i = 0; i < 3; i++) {
            buckets[i][0] = io.nextInt();
            buckets[i][1] = io.nextInt();
        }

        for (int i = 0; i < 100; i++) {
            int from = i % 3;
            int to = (i + 1) % 3;
            int available = buckets[to][0] - buckets[to][1];

            if (available >= buckets[from][1]) {
                buckets[to][1] += buckets[from][1];
                buckets[from][1] = 0;
            } else {
                buckets[from][1] -= available;
                buckets[to][1] += available;
            }

        }

        for (int i = 0; i < 3; i++) {
            io.println(buckets[i][1]);
        }

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
