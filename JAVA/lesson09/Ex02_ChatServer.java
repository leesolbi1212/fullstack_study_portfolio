package lesson09;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Ex02_ChatServer {
    private static final int PORT = 12345;
    private static final Set<Ex02_ClientHandler> clients = ConcurrentHashMap.newKeySet();
    public static void main(String[] args) {
        System.out.println("채팅 서버 시작 ...");
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트 연결됨 : " + socket.getInetAddress());
                Ex02_ClientHandler handler = new Ex02_ClientHandler(socket);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String message, Ex02_ClientHandler sender) {
        for(Ex02_ClientHandler client : clients) {
            if(client != sender) {
                client.sendMessage(message);
            }
        }
    }
    public static void removeClient(Ex02_ClientHandler client) {
        clients.remove(client);
    }
}
