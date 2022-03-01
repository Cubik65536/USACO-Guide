import java.io.*;
import java.util.*;

public class Main {
    static int[] personDrink;
    static int[] milkDrink;
    static int[] timeDrink;

    static int[] personSick;
    static int[] timeSick;

    private static int numPeopleDrink (int milk) {
        boolean[] didDrink = new boolean[personDrink.length];
        for (int i = 0; i < personDrink.length; i++) {
            if (milkDrink[i] == milk) {
                didDrink[i] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < didDrink.length; i++) {
            if (didDrink[i]) {
                count++;
            }
        }
        return count;

    }

    private static boolean personDrankMilkBefore (int person, int milk, int time) {
        for (int i = 0; i < personDrink.length; i++) {
            if (personDrink[i] == person && milkDrink[i] == milk && timeDrink[i] < time) {
                return true;
            }
        }
        return false;
    }

    private static boolean canMilkBeBad(int milk) {
        for (int i = 0; i < personSick.length; i++) {
            if (!personDrankMilkBefore(personSick[i], milk, timeSick[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("badmilk");

        int n = io.nextInt();
        int m = io.nextInt();
        int d = io.nextInt();
        int s = io.nextInt();

        personDrink = new int[d];
        milkDrink = new int[d];
        timeDrink = new int[d];
        for (int i = 0; i < d; i++) {
            personDrink[i] = io.nextInt();
            milkDrink[i] = io.nextInt();
            timeDrink[i] = io.nextInt();
        }

        personSick = new int[s];
        timeSick = new int[s];
        for (int i = 0; i < s; i++) {
            personSick[i] = io.nextInt();
            timeSick[i] = io.nextInt();
        }

        int maxSick = 0;

        for (int i = 1; i <= m; i++) {
            if (canMilkBeBad(i)) {
                int numDrank = numPeopleDrink(i);
                if (numDrank > maxSick) {
                    maxSick = numDrank;
                }
            }
        }

        io.println(maxSick);

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
