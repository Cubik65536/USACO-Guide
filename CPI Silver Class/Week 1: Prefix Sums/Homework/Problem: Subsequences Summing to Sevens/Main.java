import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 7;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("div7");

        int n = io.nextInt();

        int result = 0;
        Vector<Integer> v = new Vector<Integer>();
        for (int i = 0; i < MOD; i++) {
            v.add(-1);
        }

        v.set(0, 0);

        int curr = 0;
        for (int i = 1; i <= n; i++) {
            int cow = io.nextInt();
            curr = (curr + cow) % MOD;
            if (v.get(curr) == -1) {
                v.set(curr, i);
            } else {
                result = Math.max(result, i - v.get(curr));
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
    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    // read next line
    public String readLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
