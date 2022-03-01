import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("reststops");

        int l = io.nextInt();
        int n = io.nextInt();
        int rF = io.nextInt();
        int rB = io.nextInt();
        int[][] rest = new int[n][2];

        for (int i = 0; i < n; i++) {
            rest[i][0] = io.nextInt();
            rest[i][1] = io.nextInt();
        }

        boolean[] isMax = new boolean[n];
        int maxNum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (rest[i][1] > maxNum) {
                maxNum = rest[i][1];
                isMax[i] = true;
            }
        }

        long tastiness = 0;
        long timeF = 0;
        long timeB = 0;
        int last = 0;
        for (int i = 0; i < n; ++i) {
            if (isMax[i]) {
                timeF += (rest[i][0] - last) * ((long) rF);
                timeB += (rest[i][0] - last) * ((long) rB);
                tastiness += (timeF - timeB) * ((long) rest[i][1]);
                timeB = timeF;
                last = rest[i][0];
            }
        }

        io.println(tastiness);

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
