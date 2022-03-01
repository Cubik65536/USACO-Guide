import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] paint;

    private static boolean color_appears(int c) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (paint[i][j] == c) return true;
            }
        }
        return false;
    }

    private static boolean on_top_of(int c1, int c2) {
        int top = n, bottom = 0, left = n, right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; ++j) {
                if (paint[i][j] == c2) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (paint[i][j] == c1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("art");

        n = io.nextInt();
        paint = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = io.readLine();
            for (int j = 0; j < n; j++) {
                paint[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        int result = 0;
        for (int i = 1; i <= 9; ++i) {
            if (color_appears(i)) {
                boolean could_be_first = true;
                for (int j = 1; j <= 9; ++j) {
                    if (j != i && color_appears(j) && on_top_of(i, j)) could_be_first = false;
                }
                if (could_be_first) {
                    result++;
                }
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
