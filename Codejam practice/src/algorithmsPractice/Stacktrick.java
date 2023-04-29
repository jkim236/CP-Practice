package algorithmsPractice;
import java.lang.Thread.UncaughtExceptionHandler;

// Used to avoid stack overflow errors for problems where a large recursive stack is needed
public class Stacktrick {
	static boolean killMePls = false;
	public static void main(String[] args) throws Exception {
		Thread.UncaughtExceptionHandler h = new UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				killMePls = true;
			}
		};
		Thread t = new Thread(null,()->A(args),"",1<<28);
		t.setUncaughtExceptionHandler(h);
		t.start();
		t.join();
		if (killMePls) {
			throw null;
		}
	}
	public static void A(String[] args) {}
}
