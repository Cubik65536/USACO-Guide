import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("herding");

        int n = io.nextInt();

        int[] herd = new int[n];
        for (int i = 0; i < n; i++) {
            herd[i] = io.nextInt();
        }

        Arrays.sort(herd);

        int total = 0;
        for (int i = 1; i < n; i++) {
            total += herd[i] - herd[i - 1] - 1;
        }

        int minimum = Integer.MAX_VALUE;
        if ((herd[n - 2] - herd[0] == n - 2 && herd[n - 1] - herd[n - 2] > 2) 
            || (herd[n - 1] - herd[1] == n - 2 && herd[1] - herd[0] > 2)) {
            minimum = 2;
        } else {
            for (int i = 0, j = 0; i < n; i++) {
                while (j + 1 < n && herd[j + 1] - herd[i] < n) {
                    j++;
                }
                minimum = Math.min(minimum, n - (j - i + 1));
            }
        }

        int maximum = Math.max(total - (herd[1] - herd[0] - 1), total - (herd[n - 1] - herd[n - 2] - 1));

        io.println(minimum);
        io.println(maximum);

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
