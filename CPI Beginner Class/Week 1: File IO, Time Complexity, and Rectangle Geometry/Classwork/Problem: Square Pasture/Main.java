import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("square");

        int[] pasture1 = new int[4];
        for (int i = 0; i < 4; i++) {
            pasture1[i] = io.nextInt();
        }

        int[] pasture2 = new int[4];
        for (int i = 0; i < 4; i++) {
            pasture2[i] = io.nextInt();
        }

        int minX = Math.min(pasture1[0], pasture2[0]);
        int maxX = Math.max(pasture1[2], pasture2[2]);
        int minY = Math.min(pasture1[1], pasture2[1]);
        int maxY = Math.max(pasture1[3], pasture2[3]);
        int xDiff = maxX - minX;
        int yDiff = maxY - minY;

        io.println((int) Math.pow(Math.max(xDiff, yDiff), 2));

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
