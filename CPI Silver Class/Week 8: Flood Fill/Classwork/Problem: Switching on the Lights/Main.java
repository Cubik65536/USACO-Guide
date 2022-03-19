import java.io.*;
import java.util.*;

public class Main {
    private static class Pair {
		public int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

    private static ArrayList<Pair>[][] switches;
    private static boolean[][] on;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

    private static boolean hasVisitedNeighbor(int x, int y) {
		for(int k = 0; k < dx.length; k++) {
			if(isOn(x + dx[k], y + dy[k]) && isVisited(x + dx[k], y + dy[k])) {
				return true;
			}
		}
		return false;
	}

    private static boolean isOn(int x, int y) {
		return x >= 0 && x < on.length && y >= 0 && y < on[x].length && on[x][y];
	}

    private static boolean isVisited(int x, int y) {
		return x >= 0 && x < visited.length && y >= 0 && y < visited[x].length && visited[x][y];
	}

    private static void floodFill(int x, int y) {
        if (isVisited(x, y)) {
            return;
        }
        visited[x][y] = true;
        for (Pair next: switches[x][y]) {
            if (!on[next.x][next.y]) {
                on[next.x][next.y] = true;
                if (hasVisitedNeighbor(next.x, next.y)) {
                    floodFill(next.x, next.y);
                }
            }
        }
        for (int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isOn(nx, ny)) {
                floodFill(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lightson");

        int n = io.nextInt();
        int m = io.nextInt();

        switches = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            int x = io.nextInt() - 1;
            int y = io.nextInt() - 1;
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            switches[x][y].add(new Pair(a, b));
        }

        on = new boolean[n][n];
        on[0][0] = true;

        visited = new boolean[n][n];

        floodFill(0, 0);

        int result = 0;
        for (boolean[] row : on) {
            for (boolean col : row) {
                if (col) {
                    result++;
                }
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
