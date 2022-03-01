import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("guess");

        int n = io.nextInt();
        List<List<String>> characteristics = new ArrayList<List<String>>();
        for (int i = 0; i < n; i++) {
            String[] animal = io.readLine().split(" ");
            List<String> characteristic = new ArrayList<String>();
            for (int j = 2; j < animal.length; j++) {
                characteristic.add(animal[j]);
            }
            characteristics.add(characteristic);
        }

        int greatestCommon = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int common = 0;
                for (String iCharacteristic : characteristics.get(i)) {
                    for (String jCharacteristic : characteristics.get(j)) {
                        if (iCharacteristic.equals(jCharacteristic)) {
                            common++;
                        }
                    }
                }
                greatestCommon = Math.max(greatestCommon, common);
            }
        }

        io.println(greatestCommon + 1);

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
