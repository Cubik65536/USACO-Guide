import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<String>[] ind;
    private static ArrayList<String> all;

    private static boolean crosses(int a, int b) {
        int A = 0, B = 0, AB = 0;
        for (int i = 0; i < N; i++) {
            boolean has_a = false, has_b = false;
            for (String x : ind[i]) {
                if (x.equals(all.get(a))) {
                    has_a = true;
                }
                if (x.equals(all.get(b))) {
                    has_b = true;
                }
            }
            if (has_a && has_b) {
                AB++;
            } else if (has_a) {
                A++;
            } else if (has_b) {
                B++;
            }
        }
        return A > 0 && B > 0 && AB > 0;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("evolution");

        N = io.nextInt();
        ind = new ArrayList[N];
        all = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ind[i] = new ArrayList<>();
            int k = io.nextInt();
            for (int j = 0; j < k; j++) {
                String feature = io.next();
                ind[i].add(feature);
                boolean exists = false;
                for (String x : all) {
                    exists |= x.equals(feature);
                }
                if (!exists) {
                    all.add(feature);
                }
            }
        }

        boolean possible = true;
        for (int i = 0; possible && i < all.size(); i++) {
            for (int j = i + 1; possible && j < all.size(); j++) {
                possible &= !crosses(i, j);
            }
        }

        if (possible) {
            io.println("yes");
        } else {
            io.println("no");
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
