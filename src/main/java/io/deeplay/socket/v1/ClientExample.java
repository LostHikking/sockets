package io.deeplay.socket.v1;

import java.io.*;
import java.net.Socket;

public class ClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6070);
        socket.setSoTimeout(5000);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println(bufferedReader.readLine());
        bufferedWriter.write("bye");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());
    }
}
