package server;

import java.io.IOException;
import java.net.*;
import common.Logger;
import common.ServerType;

public final class ThrededServer extends Thread implements Runnable {

	private ServerSocket m_server;
	private boolean m_run = false;
	private Logger m_logger;
	private ServerType m_type;

	public ThrededServer(Logger logger, ServerType typeOf) throws IOException {
		m_server = new ServerSocket();
		m_logger = logger;
		m_type = typeOf;
	}

	public ThrededServer(int port, Logger logger, ServerType typeOf)
			throws IOException {
		m_server = new ServerSocket(port);
		m_logger = logger;
		m_type = typeOf;
	}

	public void run() {
		m_run = true;
		while (m_run) {
			m_logger.log(String.format("Waiting for client on port %d",
					m_server.getLocalPort()));
			try {
				SocketExecutorFactory.getInstance().getExecutor(m_type)
						.execute(m_server.accept(), m_logger);
			} catch (IOException e) {
				m_logger.logException(e);
			}
		}
	}

	public void close() {
		m_run = false;
		m_logger.log("Server Stopped");
	}

	public void finalize() {
		try {
			m_server.close();
		} catch (IOException e) {
		}
	}
}