import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("word");

        int n = io.nextInt();
        int k = io.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = io.next();
        }

        String nextToPrint = "";
        int caracterCount = 0;
        for (int i = 0; i < n; i++) {
            if (caracterCount + words[i].length() < k) {
                nextToPrint += words[i] + " ";
                caracterCount += words[i].length();
            } else if (caracterCount + words[i].length() == k) {
                io.println(nextToPrint + words[i]);
                nextToPrint = "";
                caracterCount = 0;
            } else {
                io.println(nextToPrint.trim());
                nextToPrint = words[i] + " ";
                caracterCount = words[i].length();
            }
        }

        if (!nextToPrint.isBlank()) {
            io.println(nextToPrint.trim());
        }

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
