import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int q = io.nextInt();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = io.readLine();
            for (int j = 0; j < n; j++) {
                map[i + 1][j + 1] = map[i][j + 1] + map[i + 1][j] - map[i][j] + (line.charAt(j) == '*' ? 1 : 0);
            }
        }

        while (q-- > 0) {
            int y1 = io.nextInt();
            int x1 = io.nextInt();
            int y2 = io.nextInt();
            int x2 = io.nextInt();
            io.println(map[y2][x2] - map[y1 - 1][x2] - map[y2][x1 - 1] + map[y1 - 1][x1 - 1]);
        }

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
