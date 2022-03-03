import java.io.*;
import java.util.*;

public class Main {
    private static class Entry implements Comparable<Entry> {
        private int index;
        private int value;

        public Entry(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Entry other) {
            if (this.value == other.value) {
                return this.index - other.index;
            } else {
                return this.value - other.value;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("sort");

        int n = io.nextInt();

        Entry[] entries = new Entry[n];
        for (int i = 0; i < n; i++) {
            entries[i] = new Entry(i, io.nextInt());
        }

        Arrays.sort(entries);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, entries[i].index - i);
        }

        io.println(result + 1);

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
