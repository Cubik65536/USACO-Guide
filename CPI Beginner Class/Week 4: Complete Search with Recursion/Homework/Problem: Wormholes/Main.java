import java.io.*;
import java.util.*;

public class Main {
    private static boolean cycleExists(int[] nextOnRight, int[] partner, int N) {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int count = 0; count < N; count++) {
                pos = nextOnRight[partner[pos]];
            }
            if (pos != 0) {
                return true;
            }
        }
        return false;
    }

    private static int solve(int[] nextOnRight, int[] partner, int N) {
        int total = 0;
        int i;
        for (i = 1; i <= N; i++) {
            if (partner[i] == 0) {
                break;
            }
        }
        if (i > N) {
            if (cycleExists(nextOnRight, partner, N)) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int j = i + 1; j <= N; j++) {
            if (partner[j] == 0) {
                partner[i] = j;
                partner[j] = i;
                total += solve(nextOnRight, partner, N);
                partner[i] = 0;
                partner[j] = 0;
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("wormhole");

        int n = io.nextInt();
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        int[] partner = new int[n + 1];
        int[] nextOnRight = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            x[i] = io.nextLong();
            y[i] = io.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] < x[j] && y[i] == y[j]) {
                    if (nextOnRight[i] == 0 || x[j] - x[i] < x[nextOnRight[i]] - x[i]) {
                        nextOnRight[i] = j;
                    }
                }
            }
        }

        io.println(solve(nextOnRight, partner, n));

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
