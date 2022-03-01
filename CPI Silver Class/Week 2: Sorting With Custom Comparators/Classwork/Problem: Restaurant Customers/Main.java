import java.io.*;
import java.util.*;

public class Main {
    private static class Customer {
		int time;
		int type;
        public Customer(int time, int type) {
            this.time = time;
            this.type = type;
        }
	}

	private static class CustomerComparator implements Comparator<Customer> {
		public int compare (Customer one, Customer two) {
			return Integer.compare(one.time, two.time);
		}
	}

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();
        Customer[] customers = new Customer[2 * n];

        for (int i = 0; i < n; i++) {
            Customer customer1 = new Customer(io.nextInt(), 1);
            Customer customer2 = new Customer(io.nextInt(), -1);
            customers[2 * i] = customer1;
            customers[2 * i + 1] = customer2;
        }

        Arrays.sort(customers, new CustomerComparator());

        int currentCustomer = 0;
        int result = 0;
        for (Customer customer : customers) {
            currentCustomer += customer.type;
            result = Math.max(result, currentCustomer);
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
