import java.io.*;
import java.util.*;

public class Main {
    private static int winner(int p1, String m1, int p2, String m2) {
        if (m1.equals("rock")) {
            if (m2.equals("paper")) {
                return p2;
            } else {
                return p1;
            }
        } else if (m1.equals("paper")) {
            if (m2.equals("rock")) {
                return p1;
            } else {
                return p2;
            }
        } else {
            if (m2.equals("rock")) {
                return p2;
            } else{
                return p1;
            }
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        String[] line = io.readLine().split(" ");
        while (!(line.length == 1 && line[0].equals("0"))) {
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]) * n * (n - 1) / 2;
            double[] games = new double[n];
            double[] wins = new double[n];
            for (int i = 0; i < k; i++) {
                line = io.readLine().split(" ");
                int p1 = Integer.parseInt(line[0]);
                String m1 = line[1];
                int p2 = Integer.parseInt(line[2]);
                String m2 = line[3];
                if (!m1.equals(m2)) {
                    games[p1 - 1]++;
                    games[p2 - 1]++;
                    wins[winner(p1, m1, p2, m2) - 1]++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (games[i] == 0.0) {
                    io.println("-");
                } else {
                    io.println(String.format("%.3f", wins[i] / games[i]));
                }
            }
            line = io.readLine().split(" ");
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
