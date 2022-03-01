import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("traffic");

        int n = io.nextInt();
        String[] code = new String[n];
        int[] lower = new int[n];
        int[] upper = new int[n];

        for (int i = 0; i < n; i++) {
            code[i] = io.next();
            lower[i] = io.nextInt();
            upper[i] = io.nextInt();
        }

        int lowerAfter = 0;
        int upperAfter = 1001;

        for (int i = 0; i < n; i++) {
            if (code[i].equals("none")) {
                lowerAfter = Math.max(lowerAfter, lower[i]);
                upperAfter = Math.min(upperAfter, upper[i]);
            } else if (code[i].equals("on")) {
                lowerAfter = lowerAfter + lower[i];
                upperAfter = upperAfter + upper[i];
            } else {
                lowerAfter = Math.max(0, lowerAfter - upper[i]);
                upperAfter = upperAfter - lower[i];
            }
        }

        int lowerBefore = 0;
        int upperBefore = 1001;

        for (int i = n - 1; i >= 0; i--) {
            if (code[i].equals("none")) {
                lowerBefore = Math.max(lowerBefore, lower[i]);
                upperBefore = Math.min(upperBefore, upper[i]);
            } else if (code[i].equals("on")) {
                lowerBefore = Math.max(0, lowerBefore - upper[i]);
                upperBefore = upperBefore - lower[i];
            } else {
                lowerBefore = lowerBefore + lower[i];
                upperBefore = upperBefore + upper[i];
            }
        }

        io.println(lowerBefore + " " + upperBefore + "\n" + lowerAfter + " " + upperAfter);

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
