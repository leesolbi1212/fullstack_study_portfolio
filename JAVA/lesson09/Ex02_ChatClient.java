package lesson09;

import java.io.*;
import java.net.Socket;

public class Ex02_ChatClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int port = 12345;

        try (Socket socket = new Socket(serverIP, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 서버 메시지 수신 스레드
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);

                        if (line.startsWith("파일 [") && line.endsWith("] 수신 완료")) {
                            String fileName = line.substring(4, line.indexOf("]"));
                            receiveFile(socket, fileName);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("서버 연결 종료");
                }
            }).start();

            // 키보드 입력 처리
            String input;
            while ((input = keyboard.readLine()) != null) {
                if (input.startsWith("/file ")) {
                    String filePath = input.substring(6);
                    sendFile(socket, filePath, out);
                } else {
                    out.println(input);
                    if (input.equalsIgnoreCase("exit")) break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(Socket socket, String filePath, PrintWriter out) {
        try {
            File file = new File(filePath);
            long fileSize = file.length();
            String fileName = file.getName();

            out.println("/file " + fileName);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            FileInputStream fis = new FileInputStream(file);

            dos.writeLong(fileSize);

            byte[] buffer = new byte[4096];
            long totalSent = 0;
            int read, percent = 0;

            System.out.println("파일 전송 시작: " + fileName + " (" + fileSize + " bytes)");

            while ((read = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, read);
                totalSent += read;
                int newPercent = (int)((totalSent * 100) / fileSize);
                if (newPercent > percent) {
                    percent = newPercent;
                    System.out.print("\r클라이언트 전송 진행률: " + percent + "%");
                }
            }

            fis.close();
            dos.flush();
            System.out.println("\n파일 전송 완료: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getUniqueFile(String baseName) {
        File file = new File("client_" + baseName);
        int count = 1;
        while (file.exists()) {
            String name = baseName;
            int dotIndex = name.lastIndexOf('.');
            if (dotIndex != -1) {
                name = name.substring(0, dotIndex) + "(" + count + ")" + name.substring(dotIndex);
            } else {
                name = name + "(" + count + ")";
            }
            file = new File("client_" + name);
            count++;
        }
        return file;
    }

    private static void receiveFile(Socket socket, String fileName) {
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
                    System.out.print("\r클라이언트 수신 진행률: " + percent + "%");
                }
            }

            fos.close();
            System.out.println("\n파일 저장 완료: " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}