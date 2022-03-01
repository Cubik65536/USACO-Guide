import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> subset = new ArrayList<Integer>();
    public static double output = Double.MAX_VALUE;
    public static double half;

    private static void sum(int[] arr, ArrayList<Integer> indices) {
        double subsum = 0;
        for (int k: indices) {
            subsum += arr[k];
        }
        double diff = Math.abs(half-subsum);
        output = Math.min(diff, output);
    }

    private static void search(int[] arr, int x, int nums) {
        if (x == nums) {
            sum(arr, subset);
        } else {
            search(arr, x+1, nums);
            subset.add(x);
            search(arr, x+1, nums);
            subset.remove(subset.size()-1);
        }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        long sum = 0;

        int n = io.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = io.nextInt();
            sum += p[i];
        }

        half = (double)sum/2;

        search(p, 0, n);

        io.println((int)(output*2));

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
