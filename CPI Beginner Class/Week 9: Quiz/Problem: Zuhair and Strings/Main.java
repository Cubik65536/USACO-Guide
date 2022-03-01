import java.io.*;
import java.util.*;

public class Main {
    private static boolean meetRequirement(String s, char c, int start, int end) {
        boolean meet = true;
        if (s.charAt(start) != c) {
            meet = false;
        } else {
            for (int i = start + 1; meet && i < end; i++) {
                meet &= s.charAt(i - 1) == s.charAt(i);
            }
        }
        return meet;
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int k = io.nextInt();
        String s = io.next();

        int x = 0;
        for (int i = 97; i <= 122; i++) {
            int tempX = 0;
            for (int j = 0; j < n - k + 1; j++) {
                if (meetRequirement(s, (char) i, j, j + k)) {
                    tempX++;
                    j += k - 1;
                }
            }
            if (tempX > x) {
                x = tempX;
            }
        }

        io.println(x);

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
