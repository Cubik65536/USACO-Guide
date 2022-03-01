import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = io.nextInt();
            }
        }

        long horizontalAnswer = 0;
        for (int x = 0; x < n; x++) {
            long[] sums = new long[2];
            for (int y = 0; y < n; y++) {
                sums[y % 2] += grid[x][y];
            }
            horizontalAnswer += Math.max(sums[0], sums[1]);
        }

        long verticalAnswer = 0;
        for (int x = 0; x < n; x++) {
            long[] sums = new long[2];
            for (int y = 0; y < n; y++) {
                sums[y % 2] += grid[y][x];
            }
            verticalAnswer += Math.max(sums[0], sums[1]);
        }

        io.println(Math.max(horizontalAnswer, verticalAnswer));

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
