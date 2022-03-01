import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        TreeMap<String, Integer> candidates = new TreeMap<>();
        int maximum = 0;
        while (true) {
            String next = io.readLine();
            if (next.equals("***")) {
                break;
            }
            if (!candidates.containsKey(next)) {
                candidates.put(next, 1);
            } else {
                candidates.put(next, candidates.get(next) + 1);
            }
            maximum = Math.max(maximum, candidates.get(next));
        }

        int maximumCount = 0;
        for (String candidate : candidates.keySet()) {
            if (candidates.get(candidate) == maximum) {
                maximumCount++;
            }
        }

        if (maximumCount == 1) {
            for (String candidate : candidates.keySet()) {
                if (candidates.get(candidate) == maximum) {
                    io.println(candidate);
                    break;
                }
            }
        } else {
            io.println("Runoff!");
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
