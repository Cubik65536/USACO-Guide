import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("rental");

        int n = io.nextInt();
        int m = io.nextInt();
        int r = io.nextInt();

        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = io.nextInt();
        }

        long[][] store = new long[m][2];
        for (int i = 0; i < m; i++) {
            store[i][0] = io.nextLong();
            store[i][1] = io.nextLong();
        }

        long[] rent = new long[r];
        for (int i = 0; i < r; i++) {
            rent[i] = io.nextLong();
        }

        Arrays.sort(cows);
        Arrays.sort(store, (a, b) -> (int)(b[1] - a[1]));
        Arrays.sort(rent);

        for (int i = r - 2; i >= 0; i--) {
            rent[i] += rent[i + 1];
        }

        long result = rent[r - Math.min(n, r)];
        long sold = 0;
        int currentStore = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (cows[i] > 0 && currentStore < m) {
                if (store[currentStore][0] <= cows[i]) {
                    sold += store[currentStore][0] * store[currentStore][1];
                    cows[i] -= store[currentStore][0];
                    currentStore++;
                } else {
                    sold += store[currentStore][1] * cows[i];
                    store[currentStore][0] -= cows[i];
                    cows[i] = 0;
                }
            }
            result = Math.max(result, sold + (i == 0 ? 0 : rent[r - Math.min(i, r)]));
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
