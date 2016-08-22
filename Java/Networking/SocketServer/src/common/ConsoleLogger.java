package common;

public class ConsoleLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println(message);
	}

	@Override
	public void logException(Exception ex) {
		System.out.println(ex);
	}

}
