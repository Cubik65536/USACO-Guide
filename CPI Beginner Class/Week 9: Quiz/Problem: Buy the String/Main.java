import java.io.*;
import java.util.*;

public class Main {
    private static Kattio io;

    private static void solve(int n, int c0, int c1, int h, String s) {
        int cost = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                cost += Math.min(c0, c1 + h);
            } else {
                cost += Math.min(c1, c0 + h);
            }
        }
        io.println(cost);
    }

    public static void main(String[] args) {
        io = new Kattio();

        int t = io.nextInt();
        for (int i = 0; i < t; i++) {
            solve(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt(), io.next());
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
