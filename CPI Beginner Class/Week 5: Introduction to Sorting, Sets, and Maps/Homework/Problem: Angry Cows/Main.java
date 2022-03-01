import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> pos = new ArrayList<Integer>();

    private static int explode(int loc, int rad, boolean direction, boolean exist) {
        if (!exist) {
            return loc;
        } else {
            exist = false;
            int newLoc = loc;
            if (direction) {
                for (int i = loc + rad; i >= loc + 1; i--) {
                    if (pos.contains(i)) {
                        newLoc = i;
                        exist = true;
                        break;
                    }
                }
            } else {
                for (int i = loc - rad; i <= loc - 1; i++) {
                    if (pos.contains(i)) {
                        newLoc = i;
                        exist = true;
                        break;
                    }
                }
            }
            return explode(newLoc, rad + 1, direction, exist);
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("angry");
        int curr = -1;
        int n = io.nextInt();

        for (int i = 0; i < n; i++) {
            pos.add(io.nextInt());
        }

        Collections.sort(pos);

        for (int i : pos) {
            int left = explode(i, 1, false, true);
            int right = explode(i, 1, true, true);
            int count = pos.indexOf(right) - pos.indexOf(left) + 1;
            curr = Math.max(count, curr);
        }

        io.println(curr);
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
