import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] start;
    static int[] end;
    static int[] times = new int[1000];

    private static int fireCow(int cow) {
        int timeCovered = 0;
        for(int i = start[cow]; i < end[cow]; i++){
            times[i]--;
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i] > 0) {
                timeCovered++;
            }
        }
        for(int i = start[cow]; i < end[cow]; i++){
            times[i]++;
        }
        return timeCovered;
    }

    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("lifeguards");

        n = io.nextInt();
        start = new int[n];
        end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = io.nextInt();
            end[i] = io.nextInt();

            for(int j = start[i]; j < end[i]; j++){
                times[j]++;
            }

        }

        int timeCovered = -1;
        for (int i = 0; i < n; i++) {
            timeCovered = Math.max(timeCovered, fireCow(i));
        }

        io.println(timeCovered);

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
