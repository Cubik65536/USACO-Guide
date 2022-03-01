import java.io.*;
import java.util.*;

public class Main {
    private static final int WIDTH = 1000;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("paintbarn");

        int n = io.nextInt();
        int k = io.nextInt();

        int[][] barn = new int[WIDTH + 1][WIDTH + 1];

        for (int i = 0; i < n; i++) {
            int x1 = io.nextInt();
            int y1 = io.nextInt();
            int x2 = io.nextInt();
            int y2 = io.nextInt();
            barn[x1][y1]++;
            barn[x1][y2]--;
            barn[x2][y1]--;
            barn[x2][y2]++;
        }

        int validArea = 0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i > 0) {
                    barn[i][j] += barn[i - 1][j];
                }
                if (j > 0) {
                    barn[i][j] += barn[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    barn[i][j] -= barn[i - 1][j - 1];
                }
                validArea += barn[i][j] == k ? 1 : 0;
            }
        }

        io.println(validArea);

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
