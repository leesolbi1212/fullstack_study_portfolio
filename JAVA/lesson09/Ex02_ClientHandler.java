package lesson09;

import java.io.*;
import java.net.Socket;

public class Ex02_ClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Ex02_ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("서버에 연결되었습니다. 닉네임을 입력하세요:");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    private File getUniqueFile(String baseName) {
        File file = new File("server_" + baseName);
        int count = 1;
        while (file.exists()) {
            String name = baseName;
            int dotIndex = name.lastIndexOf('.');
            if (dotIndex != -1) {
                name = name.substring(0, dotIndex) + "(" + count + ")" + name.substring(dotIndex);
            } else {
                name = name + "(" + count + ")";
            }
            file = new File("server_" + name);
            count++;
        }
        return file;
    }

    private void receiveFile(String fileName) {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            long fileSize = dis.readLong();
            File file = getUniqueFile(fileName);
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buffer = new byte[4096];
            long totalRead = 0;
            int read, percent = 0;

            System.out.println("파일 수신 시작: " + file.getName() + " (" + fileSize + " bytes)");

            while (totalRead < fileSize && (read = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
                totalRead += read;
                int newPercent = (int)((totalRead * 100) / fileSize);
                if (newPercent > percent) {
                    percent = newPercent;
                    System.out.print("\r서버 수신 진행률: " + percent + "%");
                }
            }

            System.out.println("\n파일 저장 완료: " + file.getName());
            fos.close();
            Ex02_ChatServer.broadcast("파일 [" + file.getName() + "] 수신 완료", this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String name = in.readLine();
            Ex02_ChatServer.broadcast(name + "님이 입장하셨습니다.", this);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/file ")) {
                    String fileName = message.substring(6);
                    receiveFile(fileName);
                } else if (message.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    Ex02_ChatServer.broadcast(name + ": " + message, this);
                }
            }

            out.println("채팅을 종료합니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Ex02_ChatServer.removeClient(this);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

