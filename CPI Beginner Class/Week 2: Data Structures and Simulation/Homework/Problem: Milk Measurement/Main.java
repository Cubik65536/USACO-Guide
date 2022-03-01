import java.io.*;
import java.util.*;

public class Main {
    private static class Log {
        public int day;
        public String name;
        public int delta;

        public Log(int d, String n, int dl) {
            day = d;
            name = n;
            delta = dl;
        }

    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("measurement");

        int[] milkOutput = {7, 7, 7};
        boolean[] cowsOn = {true, true, true};

        int n = io.nextInt();
        ArrayList<Log> logs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            logs.add(new Log(io.nextInt(), io.next(), io.nextInt()));
        }

        int changes = 0;

        for (int day = 1; day <= 100; day++) {
            for (Log log : logs) {
                if (log.day == day) {
                    if (log.name.equals("Bessie")) {
                        milkOutput[0] += log.delta;
                    } else if (log.name.equals("Elsie")) {
                        milkOutput[1] += log.delta;
                    } else {
                        milkOutput[2] += log.delta;
                    }
                }
            }

            int max = Integer.max(milkOutput[0], Integer.max(milkOutput[1], milkOutput[2]));

            boolean bessieOnNext = milkOutput[0] == max;
            boolean elsieOnNext = milkOutput[1] == max;
            boolean mildredOnNext = milkOutput[2] == max;

            if (bessieOnNext != cowsOn[0] || elsieOnNext != cowsOn[1] || mildredOnNext != cowsOn[2]) {
                changes++;
            }

            cowsOn[0] = bessieOnNext;
            cowsOn[1] = elsieOnNext;
            cowsOn[2] = mildredOnNext;

        }

        io.println(changes);

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
