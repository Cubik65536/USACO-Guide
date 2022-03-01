import java.io.*;
import java.util.*;

public class Main {
    private static String getMother(String child, String[][] relations) {
        for (String[] pair : relations) {
            if (child.equals(pair[1])) {
                return pair[0];
            }
        }
        return null;
    }

    private static int getAncestorDistance(String start, String end, String[][] relations) {
        int dist = 0;
        while (end != null) {
            if (end.equals(start)) {
                return dist;
            }
            dist++;
            end = getMother(end, relations);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("family");

        int relNum = io.nextInt();
        String cowX = io.next();
        String cowY = io.next();
        String[][] relations = new String[relNum][2];
        for (int i = 0; i < relNum; i++) {
            relations[i][0] = io.next();
            relations[i][1] = io.next();
        }

        int minXDist = 0;
        int minYDist = 0;
        String commonAncestor = cowX;
        while (commonAncestor != null) {
            if (getAncestorDistance(commonAncestor, cowY, relations) != -1) {
                minYDist = getAncestorDistance(commonAncestor, cowY, relations);
                break;
            }
            commonAncestor = getMother(commonAncestor, relations);
            minXDist++;
        }

        if (commonAncestor == null) {
            io.println("NOT RELATED");
        } else if (minXDist == 1 && minYDist == 1) {
            io.println("SIBLINGS");
        } else if (minXDist > 1 && minYDist > 1) {
            io.println("COUSINS");
        } else if (minXDist == 0 || minYDist == 0) {
            boolean xIsAncestor = minXDist == 0;
            io.print(String.format("%s is the ", commonAncestor));
            for (int i = 0; i < (xIsAncestor ? minYDist : minXDist) - 2; i++) {
                io.print("great-");
            }
            if ((xIsAncestor ? minYDist : minXDist) > 1) {
                io.print("grand-");
            }
            io.println(String.format("mother of %s", xIsAncestor ? cowY : cowX));
        } else {
            boolean auntIsX = minXDist == 1;
            io.print(String.format("%s is the ", auntIsX ? cowX : cowY));
            for (int i = 0; i < (auntIsX ? minYDist : minXDist) - 2; i++) {
                io.print("great-");
            }
            io.println(String.format("aunt of %s", auntIsX ? cowY : cowX));
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
