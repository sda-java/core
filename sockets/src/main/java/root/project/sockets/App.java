package root.project.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
	public static void main(String[] args) throws IOException {
		ServerSocket tcpServer = new ServerSocket(9876);

		Socket clientSocket = tcpServer.accept();

		Reader whatClientSays = new InputStreamReader(clientSocket.getInputStream());
		BufferedReader in = new BufferedReader(whatClientSays);

		Writer whatClientReceives = new OutputStreamWriter(clientSocket.getOutputStream());
		BufferedWriter out = new BufferedWriter(whatClientReceives);

		sendToClient(out, "hello! send me 5 lines");

		for (int i = 0; i < 5; i++) {
			String lineFromClient = in.readLine();

			System.out.println(i + " " + lineFromClient);

			sendToClient(out, "you sent: " + lineFromClient);
		}

		new Thread();
	}

	private static void sendToClient(BufferedWriter out, String message) throws IOException {
		out.write(message);
		out.flush();
	}
}
