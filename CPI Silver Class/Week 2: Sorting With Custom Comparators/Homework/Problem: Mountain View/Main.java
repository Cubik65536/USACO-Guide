import java.io.*;
import java.util.*;

public class Main {
    private static class Mountain implements Comparable<Mountain> {
        private int s;
        private int e;

        public Mountain(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Mountain other) {
            if (this.s != other.s) {
                return Integer.compare(this.s, other.s);
            } else {
                return Integer.compare(other.e, this.e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mountains");

        int n = io.nextInt();

        Mountain[] mountains = new Mountain[n];
        for (int i = 0; i < n; i++) {
            int x = io.nextInt();
            int y = io.nextInt();
            int s = x - y;
            int e = x + y;
            mountains[i] = new Mountain(s, e);
        }

        Arrays.sort(mountains);

        int maximum = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (mountains[i].e > maximum) {
                maximum = mountains[i].e;
                result++;
            }
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
