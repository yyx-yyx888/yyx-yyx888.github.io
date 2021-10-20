package 学习.网络编程.图片Socket;

import java.io.*;

public class SocketUtil {
    //将一个文件输入流转化为bytes数组，方便传输
    public static byte[] fileToByteArray(InputStream is) throws IOException {
        //创建字节数组用于接收从文件中得到的byte字节
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int read;
        while ((read=is.read(buf))!=-1){
            byteArrayOutputStream.write(buf,0,read);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        is.close();
        return bytes;
    }
}
