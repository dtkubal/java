package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import common.Logger;

public class FileOutputSocketExecutor implements SocketExecutor {

	public void execute(Socket socket, Logger logger) {
		try {
			File myFile = new File("C:\\ZMLSL.XML");
			byte[] mybytearray = new byte[(int) myFile.length()];
			FileInputStream fis = new FileInputStream(myFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			bis.read(mybytearray, 0, mybytearray.length);
			OutputStream os = socket.getOutputStream();
			os.write(mybytearray, 0, mybytearray.length);
			os.flush();
			bis.close();
			os.close();
			socket.close();
		} catch (FileNotFoundException e) {
			logger.logException(e);
		} catch (IOException e) {
			logger.logException(e);
		}
	}
}
