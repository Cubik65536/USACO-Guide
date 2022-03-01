import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = io.nextInt();
        }

        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = io.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distances = Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);
                if (distances > max) {
                    max = (int) distances;
                }
            }
        }

        io.println(max);

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
