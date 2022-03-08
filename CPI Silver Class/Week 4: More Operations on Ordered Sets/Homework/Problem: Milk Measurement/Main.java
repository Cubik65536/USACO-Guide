import java.io.*;
import java.util.*;

public class Main {
    private static class Log{
		private int day; 
        private int id;
        private int milkDelta;
		
        public Log(int day, int id, int milkDelta){
            this.day = day;
            this.id = id;
            this.milkDelta = milkDelta;
        }

	}

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("measurement");

        Map<Integer, Integer> ids = new HashMap<>();
        TreeMap<Integer, Integer> values = new TreeMap<>((o1, o2) -> o2 - o1);

        int n = io.nextInt();
        int g = io.nextInt();

        Log[] logs = new Log[n];
        for (int i = 0; i < n; i++) {
            int day = io.nextInt();
            int id = io.nextInt();
            int milkDelta = io.nextInt();
            logs[i] = new Log(day, id, milkDelta);
            ids.put(id, 0);
        }

        Arrays.sort(logs, Comparator.comparingInt(log -> log.day));
        values.put(0, n + 1);

        int result = 0;
        for (int i = 0; i < n; i++) {
            int milkDelta = ids.get(logs[i].id);
            boolean wasTop = milkDelta == values.firstKey();
            int prevCnt = values.get(milkDelta);
            values.put(milkDelta, values.get(milkDelta) - 1);

            if (values.get(milkDelta) == 0) {
                values.remove(milkDelta);
            }

            milkDelta += logs[i].milkDelta;
            ids.put(logs[i].id, milkDelta);
            values.put(milkDelta, values.getOrDefault(milkDelta, 0) + 1);

            boolean isTop = milkDelta == values.firstKey();
            int currCnt = values.get(milkDelta);

            if (wasTop) {
                if (isTop && currCnt == prevCnt && currCnt == 1) {
                    continue;
                }
                result++;
            } else if (isTop) {
                result++;
            }

        }

        io.println(result);

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
