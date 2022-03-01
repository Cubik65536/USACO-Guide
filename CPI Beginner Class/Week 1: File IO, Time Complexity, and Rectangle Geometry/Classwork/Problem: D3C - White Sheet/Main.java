import java.io.*;
import java.util.*;

public class Main {
    public static class Rectangle {
        int x1, x2, y1, y2;
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public int getArea() {
            return (x2 - x1) * (y2 - y1);
        }

        public int getIntersection(Rectangle r) {
            int x1 = Math.max(this.x1, r.x1);
            int y1= Math.max(this.y1, r.y1);
            int x2 = Math.min(this.x2, r.x2);
            int y2 = Math.min(this.y2, r.y2);
            return Integer.max(0, (x2 - x1)) * Integer.max(0, (y2 - y1));
        }

        public int getIntersection(Rectangle r1, Rectangle r2) {
            int x1 = Math.max(Math.max(this.x1, r1.x1), r2.x1);
            int y1 = Math.max(Math.max(this.y1, r1.y1), r2.y1);
            int x2 = Math.min(Math.min(this.x2, r1.x2), r2.x2);
            int y2 = Math.min(Math.min(this.y2, r1.y2), r2.y2);
            return Integer.max(0, (x2 - x1)) * Integer.max(0, (y2 - y1));
        }

    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        Rectangle white = new Rectangle(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
        Rectangle black1 = new Rectangle(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
        Rectangle black2 = new Rectangle(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());

        int whiteArea = white.getArea() - white.getIntersection(black1) - white.getIntersection(black2) +
                white.getIntersection(black1, black2);

        if (0 < whiteArea) {
            io.println("YES");
        } else {
            io.println("NO");
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
