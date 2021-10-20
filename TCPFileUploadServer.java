package 学习.网络编程.图片Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        //1.在本机的9999端口监听，等待连接（要求9999没被占用）
        //     serverSocket中可以创建多个serverSocket.accept()对象（多个客户端连接服务器的并发）
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口，等待连接..");
        //2.有客户端连接9999，返回Socket对象
        // 没有客户端连接9999，程序阻塞，等待连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接到服务端" + socket);
        //3.从socket管道中得到的字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //4.调用方法，将缓冲流转换为bytes数组
        byte[] bytes = SocketUtil.fileToByteArray(bis);
        //5. 定义文件输出位置
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\picture.png"));
        //6.写入我们的资源
        bos.write(bytes);
        //7.关闭流
        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
    }
}
