package server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import common.Logger;

public class FileInputSocketExecutor implements SocketExecutor {

	public void execute(Socket socket, Logger logger) {

		try {
			InputStream in = socket.getInputStream();
			OutputStream out = new FileOutputStream("c:\\xmlsls.xml");
			byte[] bytes = new byte[16 * 1024];
			int count;
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
			}
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			logger.logException(e);
		}
	}

}
