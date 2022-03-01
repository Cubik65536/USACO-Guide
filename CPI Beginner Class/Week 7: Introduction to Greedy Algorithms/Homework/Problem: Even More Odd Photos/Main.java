import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int o = 0;
        int e = 0;

        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            int next = io.nextInt();
            if (next % 2 == 0) {
                e++;
            } else {
                o++;
            }
        }

        while (o > e) {
            o = o - 2;
            e++;
        }

        if (e > o + 1) {
            e = o + 1;
        }

        io.println(e + o);

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
