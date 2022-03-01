import java.io.*;
import java.util.*;

public class Main {
    private static char[][] gameboard = new char[3][3];
    private static TreeSet<Character> singleCow = new TreeSet<>();
    private static TreeSet<String> teams = new TreeSet<>();

    private static void check(char first, char second, char third) {
        TreeSet<Character> contained = new TreeSet<>();
        contained.add(first);
        contained.add(second);
        contained.add(third);
        if (contained.size() == 1) {
            singleCow.add(contained.first());
        } else if (contained.size() == 2) {
            teams.add(contained.first() + "" + contained.last());
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("tttt");

        for (int i = 0; i < gameboard.length; i++) {
            String line = io.next();
            gameboard[i][0] = line.charAt(0);
            gameboard[i][1] = line.charAt(1);
            gameboard[i][2] = line.charAt(2);
        }

        // Check rows
        for (int i = 0; i < gameboard.length; i++) {
            check(gameboard[i][0], gameboard[i][1], gameboard[i][2]);
        }

        // Check columns
        for (int i = 0; i < gameboard.length; i++) {
            check(gameboard[0][i], gameboard[1][i], gameboard[2][i]);
        }

        // Check diagonals
        check(gameboard[0][0], gameboard[1][1], gameboard[2][2]);
        check(gameboard[0][2], gameboard[1][1], gameboard[2][0]);

        io.println(singleCow.size());
        io.println(teams.size());

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
