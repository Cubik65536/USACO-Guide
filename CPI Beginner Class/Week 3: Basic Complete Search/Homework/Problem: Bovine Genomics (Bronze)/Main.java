import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cownomics");

        int n = io.nextInt();
        int m = io.nextInt();

        char[][] spotty = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = io.readLine();
            for (int j = 0; j < m; j++) {
                spotty[i][j] = line.charAt(j);
            }
        }

        char[][] plain = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = io.readLine();
            for (int j = 0; j < m; j++) {
                plain[i][j] = line.charAt(j);
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            boolean contains = false;
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(spotty[j][i]);
            }

            for (int j = 0; j < n; j++) {
                if (set.contains(plain[j][i])) {
                    contains = true;
                    break;
                }
            }

            if (!contains) result++;

        }

        io.println(result);

        io.close();
    }
}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in,System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName+".out"));
        r = new BufferedReader(new FileReader(problemName+".in"));
    }
    // read next line
    public String readLine() {
        try {
            return r.readLine();
        } catch (IOException e) {}
        return null;
    }
    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}
