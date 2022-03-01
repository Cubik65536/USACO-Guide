import java.io.*;
import java.util.*;

public class Main {
    private static int result = 0;
    private static boolean[] column = new boolean[8];
    private static boolean[] ULLRDiag = new boolean[16];
    private static boolean[] URLLDiag = new boolean[16];

    private static void place(char[][] chessboard, int q) {
        if (q == 8) {
            result++;
        } else {
            for (int i = 0; i < 8; i++) {
                if (chessboard[q][i] == '.') {
                    if (!column[i] && !ULLRDiag[q - i + 8 - 1] && !URLLDiag[q + i])
                    {
                        column[i] = ULLRDiag[q - i + 8 - 1] = URLLDiag[q + i] = true;
                        place(chessboard, q+1);
                        column[i] = ULLRDiag[q - i + 8 - 1] = URLLDiag[q + i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        char chessboard[][] = new char[8][8];
        for (int i = 0; i < 8; i++) {
            chessboard[i] = io.readLine().toCharArray();
        }

        place(chessboard, 0);

        io.println(result);

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
