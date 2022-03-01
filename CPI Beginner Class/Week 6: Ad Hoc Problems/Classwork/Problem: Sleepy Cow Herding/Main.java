import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("herding");

        int[] locaction = new int[3];
        locaction[0] = io.nextInt();
        locaction[1] = io.nextInt();
        locaction[2] = io.nextInt();

        Arrays.sort(locaction);

        int distance1 = locaction[1] - locaction[0];
        int distance2 = locaction[2] - locaction[1];

        if (locaction[0] + 2 == locaction[2]) {
            io.println(0);
        } else if (distance1 == 2 || distance2 == 2) {
            io.println(1);
        } else {
            io.println(2);
        }

        io.println(Math.max(distance1, distance2) - 1);

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
