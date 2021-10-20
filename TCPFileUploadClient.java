package 学习.网络编程.图片Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        //1.连接服务端（传入参数一：InetAddress.getLocalHost():本地测试/192.168.1.194/别人的ip地址，参数二：端口号）
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //2.将文件输入流转化为字节数组
        byte[] bytes = SocketUtil.fileToByteArray(new FileInputStream("C:\\Users\\你亲亲的杨怡鑫\\Desktop\\我的笔记\\我的信息\\图片.jpg"));
        //3.得到sock的字节缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //4.将bytes数组写入socket管道
        bos.write(bytes);
        socket.shutdownOutput();//设置写入数据的结束标志
        //5.关闭流
        bos.close();
        socket.close();
    }
}
