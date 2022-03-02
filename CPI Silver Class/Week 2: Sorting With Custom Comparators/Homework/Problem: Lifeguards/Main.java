import java.io.*;
import java.util.*;

public class Main {
    private static class Lifeguard implements Comparable<Lifeguard> {
        private int time;
        private int id;
        private boolean isStart;

        public Lifeguard(int time, int id, boolean isStart) {
            this.time = time;
            this.id = id;
            this.isStart = isStart;
        }

        public int compareTo(Lifeguard lifeguard) {
            return time - lifeguard.time;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lifeguards");

        int n = io.nextInt();

        Lifeguard[] lifeguards = new Lifeguard[2 * n];
        for (int i = 0; i < n; i++) {
            int start = io.nextInt();
            int end = io.nextInt();
            lifeguards[2 * i] = new Lifeguard(start, i, true);
            lifeguards[2 * i + 1] = new Lifeguard(end, i, false);
        }

        Arrays.sort(lifeguards);
        
        TreeSet<Integer> activeLifeguards = new TreeSet<Integer>();

        int totalTime = 0;
        int[] aloneTime = new int[n];
        int prevTime = 0;

        for (Lifeguard lifeguard : lifeguards) {
            int currentTime = lifeguard.time;

            if (!activeLifeguards.isEmpty()) {
                totalTime += currentTime - prevTime;
            }

            if (activeLifeguards.size() == 1) {
                aloneTime[activeLifeguards.first()] += currentTime - prevTime;
            }

            if (lifeguard.isStart) {
                activeLifeguards.add(lifeguard.id);
            } else {
                activeLifeguards.remove(lifeguard.id);
            }

            prevTime = currentTime;

        }

        int minimumAloneTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minimumAloneTime = Math.min(minimumAloneTime, aloneTime[i]);
        }

        io.println(totalTime - minimumAloneTime);

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
