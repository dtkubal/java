package server;

import common.ServerType;

public class SocketExecutorFactory {

	private static SocketExecutorFactory m_factory = null;

	private SocketExecutorFactory() {
	}

	public static SocketExecutorFactory getInstance() {
		if (m_factory == null) {
			m_factory = new SocketExecutorFactory();
		}
		return m_factory;
	}

	public SocketExecutor getExecutor(ServerType typeof) {
		switch (typeof) {
		default:
			return new NullLSocketExecutor();
		case LineReader:
			return new LineReaderSocketExecutor();
		case FileRecevier:
			return new FileInputSocketExecutor();
		case FileSender:
			return new FileOutputSocketExecutor();
		}

	}
}
