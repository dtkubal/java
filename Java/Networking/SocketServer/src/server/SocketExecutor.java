package server;

import java.net.Socket;
import common.Logger;

public interface SocketExecutor {

	void execute(Socket socket, Logger logger);

}
