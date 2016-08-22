package server;

import java.net.Socket;

import common.Logger;

public class NullLSocketExecutor implements SocketExecutor {

	@Override
	public void execute(Socket socket, Logger logger) {
		// Null Pattern, It's not going to do anything
	}

}
