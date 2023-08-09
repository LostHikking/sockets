package io.deeplay.socket.v2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientExample {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 6070);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            bufferedWriter.write("Hello");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            String response = bufferedReader.readLine();
            System.out.println(response);
        }
    }
}
