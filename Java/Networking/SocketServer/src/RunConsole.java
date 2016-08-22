import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.ConsoleLogger;
import common.ServerType;
import server.ThrededServer;
import server.Runnable;

public class RunConsole {

	public static void main(String[] args) {
		try {
			Runnable m_runnable = new ThrededServer(8000, new ConsoleLogger(),
					ServerType.LineReader);
			m_runnable.run();
			System.out.println("Server UP");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String cmd = br.readLine();
			if (cmd == "0") {
				m_runnable.close();
				System.out.println("Server Down");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
