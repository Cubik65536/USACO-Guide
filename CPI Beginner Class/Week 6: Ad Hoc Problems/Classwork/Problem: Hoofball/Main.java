import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] x, passTo;

    private static int target(int target) {
        int l = -1, ld = 1000;
        int r = -1, rd = 1000;
        for (int i = 0; i < N; i++) {
            if (x[i] < x[target] && x[target] - x[i] < ld) {
                l = i;
                ld = x[target] - x[i];
            }
            if (x[i] > x[target] && x[i] - x[target] < rd) {
                r = i;
                rd = x[i] - x[target];
            }
        }
        if (ld <= rd) {
            return l;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("hoofball");

        N = io.nextInt();
        x = new int[N];
        passTo = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = io.nextInt();
        }
        for (int i = 0; i < N; i++) {
            passTo[target(i)]++;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (passTo[i] == 0)
                result++;
            if (i < target(i) && target(target(i)) == i && passTo[i] == 1 && passTo[target(i)] == 1)
                result++;
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
