import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("speeding");

        int n = io.nextInt();
        int m = io.nextInt();

        int[] roadSegments = new int[n];
        int[] speedLimit = new int[n];
        for (int i = 0; i < n; i++) {
            roadSegments[i] = io.nextInt();
            speedLimit[i] = io.nextInt();
        }

        int[] distances = new int[m];
        int[] speeds =  new int[m];
        for (int i = 0; i < m; i++) {
            distances[i] = io.nextInt();
            speeds[i] = io.nextInt();
        }

        int roadLength = 100;

        int[] limitSpeed = new int[roadLength];
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < roadSegments[i]; j++) {
                limitSpeed[start + j] = speedLimit[i];
            }
            start += roadSegments[i];
        }

        int[] bessieSpeed = new int[roadLength];
        start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < distances[i]; j++) {
                bessieSpeed[start + j] = speeds[i];
            }
            start += distances[i];
        }

        int amountOver = 0;
        for (int i = 0; i < roadLength; i++) {
            amountOver = Math.max(amountOver, bessieSpeed[i] - limitSpeed[i]);
        }

        io.println(amountOver);

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
