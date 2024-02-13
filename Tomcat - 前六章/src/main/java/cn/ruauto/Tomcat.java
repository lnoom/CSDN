package cn.ruauto;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tomcat {
    public void start() {
        // socket连接 tcp
        try {
            //浏览器开启两个窗口 解决串行问题
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            ServerSocket serverSocket = new ServerSocket(8080);
            //循环接收 不能请求一次就断开
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new SocketProcessor(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.start();
    }
}
