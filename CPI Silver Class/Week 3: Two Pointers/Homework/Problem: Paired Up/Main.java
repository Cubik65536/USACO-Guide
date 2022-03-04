import java.io.*;
import java.util.*;

public class Main {
    private static class Pair implements Comparable<Pair> {
        private int milkTime;
        private int cowsNum;

        public Pair(int cowsNum, int milkTime) {
            this.milkTime = milkTime;
            this.cowsNum = cowsNum;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.milkTime, other.milkTime);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("pairup");

        int n = io.nextInt();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(io.nextInt(), io.nextInt()));
        }

        Collections.sort(pairs);

        int result = 0;
        for (int i = 0, j = n - 1; i <= j;) {
            int numPaired = Integer.min(pairs.get(i).cowsNum, pairs.get(j).cowsNum);
            if (i == j) {
                numPaired /= 2;
            }
            result = Integer.max(result, pairs.get(i).milkTime + pairs.get(j).milkTime);
            pairs.get(i).cowsNum -= numPaired;
            pairs.get(j).cowsNum -= numPaired;

            if (pairs.get(i).cowsNum == 0) {
                i++;
            }
            if (pairs.get(j).cowsNum == 0) {
                j--;
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
