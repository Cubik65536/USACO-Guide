import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("diamond");

        int n = io.nextInt();
        int k = io.nextInt();

        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            diamonds[i] = io.nextInt();
        }
        
        Arrays.sort(diamonds);

        int[] maxDiamondFirst = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && diamonds[j] - diamonds[i] <= k) {
                j++;
            }
            maxDiamondFirst[i] = j - i;
        }

        int[] maxDiamondSecond = new int[n + 1];
        maxDiamondSecond[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxDiamondSecond[i] = Math.max(maxDiamondFirst[i], maxDiamondSecond[i + 1]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxDiamondFirst[i] + maxDiamondSecond[i + maxDiamondFirst[i]]);
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
