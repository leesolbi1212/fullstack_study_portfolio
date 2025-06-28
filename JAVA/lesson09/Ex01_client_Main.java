package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex01_client_Main {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int port = 12345;

        try (Socket socket = new Socket(serverIP, port)) {
            System.out.println("서버에 연결됨 🤝");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("안녕 서버");
            String response = in.readLine();
            System.out.println("서버 응답 : " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
