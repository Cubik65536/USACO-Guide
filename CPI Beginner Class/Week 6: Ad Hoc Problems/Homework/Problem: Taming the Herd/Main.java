import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("taming");

        int n = io.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
        }

        if (a[0] > 0) {
            io.println(-1);
            io.close();
            return;
        }

        a[0] = 0;

        int m = 0, M = 0;
        int t = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (t >= 0) {
                t--;
            }
            if (t != -1 && a[i] != -1 && a[i] != t) {
                io.println(-1);
                io.close();
                return;
            }
            if (a[i] > 0) {
                t = a[i];
            } else if (a[i] == 0) {
                m++;
            } else {
                if (t == 0) {
                    m++;
                } else if (t < 0) {
                    M++;
                } else;
            }
        }

        M += m;

        io.println(m + " " + M);

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
