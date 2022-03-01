import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("revegetate");

        int n = io.nextInt();
        int m = io.nextInt();

        int[] types = new int[n];
        for (int i = 0; i < n; i++) {
            types[i] = 1;
        }

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();

            if (!map.containsKey(a)) {
                map.put(a, new TreeSet<>());
            }
            map.get(a).add(b);

            if (!map.containsKey(b)) {
                map.put(b, new TreeSet<>());
            }
            map.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(i + 1)) {
                for (int j : map.get(i + 1)) {
                    if (i + 1 < j) {
                        if (types[i] == types[j - 1]) {
                            types[j - 1]++;
                        }
                    } else {
                        if (types[i] == types[j - 1]) {
                            types[i]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            io.print(types[i]);
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
