import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("buckets");
      
		int barn_x = -1, barn_y = -1, lake_x = -1, lake_y = -1, rock_x = -1, rock_y = -1;

		for (int i = 0; i < 10; i++) {
			String line = io.next();
			for (int j = 0; j < 10; j++) {
				if (line.charAt(j) == 'B') {
					barn_x = i;
					barn_y = j;
				} else if (line.charAt(j) == 'L') {
					lake_x = i;
					lake_y = j;
				} else if (line.charAt(j) == 'R') {
					rock_x = i;
					rock_y = j;
				} else;
			}
		}

		int distance_barn_lake = Math.abs(barn_x - lake_x) + Math.abs(barn_y - lake_y);
		int distance_barn_rock = Math.abs(barn_x - rock_x) + Math.abs(barn_y - rock_y);
		int distance_rock_lake = Math.abs(rock_x - lake_x) + Math.abs(rock_y - lake_y);

		if ((barn_x == lake_x || barn_y == lake_y) && distance_barn_lake == distance_barn_rock + distance_rock_lake) {
			io.println(distance_barn_lake + 1);
		} else {
			io.println(distance_barn_lake - 1);
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
