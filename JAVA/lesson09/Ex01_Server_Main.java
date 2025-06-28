package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01_Server_Main {
    public static void main(String[] args) {
        int port = 12345;
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버 대기 중.....❤️");
            Socket clientSocket = serverSocket.accept(); //클라이언트가 대기하는 메서드
            System.out.println("클라이언트 연결됨 : " + clientSocket.getInetAddress()); //사용자가 하나 들어올 때마다 이 밑으로 넘어옴
            // 사용자의 ip 찍어주기
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 변수로 만들어서 넣어줄 걸, 그냥 여기서 바로 쓸 거니까 여기서 객체 만들어서 쓰는 것. 그리고 in에 저장함.
            // Buffer : 데이터가 안정적으로 쌓여지면 보여주는 역할임. 영상을 쪼개서 보여줄 순 없기 때문
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //자동으로 밖으로 나가는 역할

            String input = in.readLine(); //사용자가 나에게 전달한 메시지가 버퍼에 담겨져 있다면
            System.out.println("클라이언트로부터 받은 메시지 : " + input);

            out.println(input);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
