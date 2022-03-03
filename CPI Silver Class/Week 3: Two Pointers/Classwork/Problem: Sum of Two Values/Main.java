import java.io.*;
import java.util.*;

public class Main {
    private static class Pair implements Comparable<Pair> {
        private int index;
        private int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }

    }
 
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int x = io.nextInt();

        List<Pair> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Pair(i + 1, io.nextInt()));
        }

        Collections.sort(a);

        for (int i = 0, j = n - 1; i < j;) {
            if (a.get(i).value + a.get(j).value < x) {
                i++;
            } else if (a.get(i).value + a.get(j).value > x) {
                j--;
            } else {
                io.println(a.get(i).index + " " + a.get(j).index);
                io.close();
                return;
            }
        }

        io.println("IMPOSSIBLE");

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
