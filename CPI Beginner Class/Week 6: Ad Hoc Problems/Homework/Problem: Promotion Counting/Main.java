import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("promote");

        int[][] participants = new int[4][2];
        for (int i = 0; i < 4; i++) {
            participants[i][0] = io.nextInt();
            participants[i][1] = io.nextInt();
        }

        int goldToPlatinum = participants[3][1] - participants[3][0];
        int silverToGold = participants[2][1] - participants[2][0] + goldToPlatinum;
        int bronzeToSilver = participants[1][1] - participants[1][0] + silverToGold;

        io.println(bronzeToSilver);
        io.println(silverToGold);
        io.println(goldToPlatinum);

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
