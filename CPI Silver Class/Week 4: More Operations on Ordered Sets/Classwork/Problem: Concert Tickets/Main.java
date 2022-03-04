import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int m = io.nextInt();

        NavigableMap<Integer, Integer> tickets = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int h = io.nextInt();
            if (tickets.containsKey(h)) {
                tickets.put(h, tickets.get(h) + 1);
            } else {
                tickets.put(h, 1);
            }
        }

        for (int i = 0; i < m; i++) {
            int t = io.nextInt();

            Map.Entry<Integer, Integer> ticket = tickets.lowerEntry(t + 1);
            if (ticket == null) {
                io.println("-1");
            } else {
                io.println(ticket.getKey());
                if (ticket.getValue() == 1) {
                    tickets.remove(ticket.getKey());
                } else {
                    tickets.put(ticket.getKey(), ticket.getValue() - 1);
                }
            }
        }

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
