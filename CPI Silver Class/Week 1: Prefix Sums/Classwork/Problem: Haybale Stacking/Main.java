import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int k = io.nextInt();

        int[] difference = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            difference[a]++;
            difference[b + 1]--;
        }

        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += difference[i];
            prefixSum[i] = sum;
        }

        Arrays.sort(prefixSum);
        io.println(prefixSum[n / 2]);

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
