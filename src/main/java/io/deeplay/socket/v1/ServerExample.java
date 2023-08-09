package io.deeplay.socket.v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6070);
        System.out.println("Ready to accept");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Accept");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        while (!clientSocket.isClosed()) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String response = getResponse(line);
                bufferedWriter.append(response);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static String getResponse(String request) {
        return request.toUpperCase();
    }
}