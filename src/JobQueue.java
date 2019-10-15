import java.io.*;
import java.util.*;

public class JobQueue {
	private int numWorkers;
	private int[] jobs;

	private int[] assignedWorker;
	private long[] startTime;

	private List<WorkerObj> result;
	private FastScanner in;
	private PrintWriter out;

	public static void main(String[] args) throws IOException {
		new JobQueue().solve();
	}

	private void readData() throws IOException {
		numWorkers = in.nextInt();
		int m = in.nextInt();
		jobs = new int[m];
		for (int i = 0; i < m; ++i) {
			jobs[i] = in.nextInt();
		}
	}

	private void writeResponse() {
		for (int i = 0; i < jobs.length; ++i) {
			out.println(assignedWorker[i] + " " + startTime[i]);
		}
	}

	private void assignJobs() {
		assignedWorker = new int[jobs.length];
		startTime = new long[jobs.length];
		PriorityQueue<WorkerObj> pq = new PriorityQueue<WorkerObj>(numWorkers, new Comparator<WorkerObj>() {
			@Override
			public int compare(WorkerObj w1, WorkerObj w2) {
				if (w1.release_time == w2.release_time) {
					return w1.thread_id - w2.thread_id;
				} else {
					return (int) (w1.release_time - w2.release_time);
				}
			}
		});
		for (int i = 0; i < numWorkers; i++) {
			pq.offer(new WorkerObj(i));
		}
		for (int i = 0; i < jobs.length; i++) {
			WorkerObj freeThread = pq.poll();
			assignedWorker[i] = freeThread.thread_id;
			startTime[i] = freeThread.release_time;
			freeThread.release_time += jobs[i];
			pq.offer(freeThread);
		}
	}

	private class WorkerObj {
		int thread_id;
		long release_time;

		public WorkerObj(int thread_id) {
			this.thread_id = thread_id;
			this.release_time = 0;
		}

	}

	public void solve() throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		readData();
		assignJobs();
		writeResponse();
		out.close();
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
