package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import common.Logger;

public class LineReaderSocketExecutor implements SocketExecutor {

	public void execute(Socket socket, Logger logger) {
		try {
			DataInputStream input = new DataInputStream(
					socket.getInputStream());
			logger.log(String.format("Message %s", input.readUTF()));
			DataOutputStream output = new DataOutputStream(
					socket.getOutputStream());
			output.writeUTF("Message Recevied");
			socket.close();
		} catch (IOException e) {
			logger.logException(e);
		}
	}
}
